package gaur.himanshu.august.restcountries.local.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.restcountries.BR
import gaur.himanshu.august.restcountries.databinding.ListItemBinding
import gaur.himanshu.august.restcountries.remote.response.RestEduResponseItem


class HomeAdapter() :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {


    var list = mutableListOf<RestEduResponseItem>()
    fun setContentList(list: List<RestEduResponseItem>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.setVariable(BR.data, this.list[position])
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}
