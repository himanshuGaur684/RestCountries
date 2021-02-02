package gaur.himanshu.august.restcountries.local.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import gaur.himanshu.august.restcountries.R
import gaur.himanshu.august.restcountries.Status
import gaur.himanshu.august.restcountries.databinding.FragmentHomeBinding
import gaur.himanshu.august.restcountries.local.adapters.HomeAdapter
import javax.inject.Inject

class HomeFragment @Inject constructor(private val homeAdapter: HomeAdapter): Fragment(R.layout.fragment_home) {

    lateinit var binding:FragmentHomeBinding

    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel=ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        setRecyclerView()
        viewModel.list.observe(viewLifecycleOwner){
            when(it.peekContent().status){
                Status.LOADING->{
                    showProgress()
                }
                Status.SUCCESS->{
                    hideProgress()
                homeAdapter.setContentList(it.peekContent().data!!)
                }
                Status.ERROR->{
                    hideProgress()
                }
            }
        }
    }

    private fun setRecyclerView(){
        binding.homeRecycler.apply {
            adapter=homeAdapter
        }
    }

    private fun showProgress(){
        binding.progressBarHome.visibility=View.VISIBLE
    }
    private fun hideProgress(){
        binding.progressBarHome.visibility=View.GONE
    }
}