package com.ekocaman.movist.movie.service

import io.grpc.stub.StreamObserver
import io.reactivex.Observable
import mu.KLogging
import okhttp3.OkHttpClient
import org.lognet.springboot.grpc.GRpcService
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/")
    fun searchMovies(
            @Query("s") searchKey: String,
            @Query("y") year: String?,
            @Query("type") type: String?): Observable<SearchResultResponse>

    @GET("/")
    fun getMovie(
            @Query("i") id: String): Observable<MovieResponse>

    companion object Factory {
        val API_KEY: String = "b9463c73"
        val BASE_URL: String = "http://www.omdbapi.com/"

        val httpClient = OkHttpClient.Builder()
                .addInterceptor {
                    val request = it.request()
                    val httpUrl = request.url().newBuilder()
                            .addQueryParameter("apikey", API_KEY)
                            .build()
                    it.proceed(request.newBuilder().url(httpUrl).build())
                }
                .build()

        fun create(): MovieService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(MovieService::class.java)
        }
    }
}

@GRpcService
@Service("movieService")
class MovieServiceImpl : MovieService, MovieServiceGrpc.MovieServiceImplBase() {
    companion object : KLogging()

    val service: MovieService = MovieService.Factory.create()

    override fun searchMovies(searchKey: String, year: String?, type: String?): Observable<SearchResultResponse> {
        return service.searchMovies(searchKey, year, type)
    }

    override fun getMovie(id: String): Observable<MovieResponse> {
        return service.getMovie(id)
    }

    override fun search(request: MovieServiceRequest?, responseObserver: StreamObserver<MovieServiceResponse>?) {
        logger.info { "GRPC Request" }
        request?.let {
            logger.info { "Request => $request" }
            searchMovies(it.searchKey, it.year, it.type)
                    .map {
                        it.search
                    }
                    .map {
                        val builder = MovieServiceResponse.newBuilder()
                        it.forEach {
                            builder.addSearch(
                                    MovieData.newBuilder()
                                            .setImdbID(it.imdbID)
                                            .setTitle(it.poster)
                                            .setType(it.type)
                                            .build()
                            )
                        }
                        builder.build()
                    }
                    .subscribe {
                        logger.info { "Response => $it" }
                        responseObserver?.onNext(it)
                        responseObserver?.onCompleted()
                    }

        }
    }
}