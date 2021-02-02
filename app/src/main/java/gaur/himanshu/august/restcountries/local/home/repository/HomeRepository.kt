package gaur.himanshu.august.restcountries.local.home.repository

import android.util.Log
import gaur.himanshu.august.restcountries.Result
import gaur.himanshu.august.restcountries.Status
import gaur.himanshu.august.restcountries.remote.FeatchNetworkRequest
import gaur.himanshu.august.restcountries.remote.response.RestEduResponse

class HomeRepository(private val retrofit: FeatchNetworkRequest) : IHomeRepository {
    override suspend fun featchData(): Result<RestEduResponse> {
        return try {
            val response = retrofit.getAllAsiaCountries()
            if (response.isSuccessful) {
                Log.d("TAG", "featchData:${response.body()} ")
                Result(Status.SUCCESS, response.body(), null)
            } else {
                Result(Status.ERROR, null, null)
            }
        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }

    }
}