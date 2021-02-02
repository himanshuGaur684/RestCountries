package gaur.himanshu.august.restcountries.local.home.repository

import gaur.himanshu.august.restcountries.Result
import gaur.himanshu.august.restcountries.remote.response.RestEduResponse

interface IHomeRepository {

    suspend fun  featchData():Result<RestEduResponse>

}