package gaur.himanshu.august.restcountries.local.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.august.restcountries.local.adapters.HomeAdapter
import gaur.himanshu.august.restcountries.local.home.repository.HomeRepository
import gaur.himanshu.august.restcountries.local.home.repository.IHomeRepository
import gaur.himanshu.august.restcountries.remote.FeatchNetworkRequest
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalHiltModule {


    @Provides
    @Singleton
    fun provideHomeRepository(retrofit: FeatchNetworkRequest): IHomeRepository {
        return HomeRepository(retrofit)
    }

    @Provides
    @Singleton
    fun provideHomeAdapter():HomeAdapter{
        return HomeAdapter()
    }
}