package gaur.himanshu.august.restcountries

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import gaur.himanshu.august.restcountries.local.adapters.HomeAdapter
import gaur.himanshu.august.restcountries.local.home.HomeFragment
import javax.inject.Inject

class HomeFragmentFactory @Inject constructor(private val homeAdapter: HomeAdapter): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when(className){
            HomeFragment::class.java.name->{
                return HomeFragment(homeAdapter)
            }
        }

        return super.instantiate(classLoader, className)
    }
}