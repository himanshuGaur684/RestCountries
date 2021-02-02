package gaur.himanshu.august.restcountries.remote.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.august.restcountries.remote.FeatchNetworkRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteHiltModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://restcountries.eu/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideFeatchNetworkRequest(retrofit: Retrofit): FeatchNetworkRequest {
        return retrofit.create(FeatchNetworkRequest::class.java)
    }
}