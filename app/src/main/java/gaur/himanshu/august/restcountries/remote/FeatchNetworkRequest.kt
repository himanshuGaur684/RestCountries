package gaur.himanshu.august.restcountries.remote

import gaur.himanshu.august.restcountries.remote.response.RestEduResponse
import retrofit2.Response
import retrofit2.http.GET

interface FeatchNetworkRequest {


    @GET("rest/v2/region/asia")
    suspend fun getAllAsiaCountries():Response<RestEduResponse>


}