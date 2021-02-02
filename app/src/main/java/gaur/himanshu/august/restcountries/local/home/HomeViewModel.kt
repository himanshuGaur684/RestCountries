package gaur.himanshu.august.restcountries.local.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.august.restcountries.Events
import gaur.himanshu.august.restcountries.Result
import gaur.himanshu.august.restcountries.Status
import gaur.himanshu.august.restcountries.local.home.repository.IHomeRepository
import gaur.himanshu.august.restcountries.remote.response.RestEduResponse
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository:IHomeRepository) : ViewModel() {


    private val _list=MutableLiveData<Events<gaur.himanshu.august.restcountries.Result<RestEduResponse>>>()
    val list:LiveData<Events<gaur.himanshu.august.restcountries.Result<RestEduResponse>>> = _list

    init {
        featchEduResponse()
    }


    fun featchEduResponse()= viewModelScope.launch {
        _list.postValue(Events(Result(Status.LOADING,null,null)))
        _list.postValue(Events(repository.featchData()))
    }

}