package gaur.himanshu.august.restcountries.local.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gaur.himanshu.august.restcountries.BR
import gaur.himanshu.august.restcountries.R
import gaur.himanshu.august.restcountries.databinding.ListItemBinding
import gaur.himanshu.august.restcountries.remote.response.RestEduResponseItem
import kotlinx.android.synthetic.main.list_item.view.*

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

        Glide.with(holder.viewDataBinding.root).load(list[position].flag)
            .placeholder(R.drawable.ic_loading).error(R.drawable.ic_error_image).into(
                holder.viewDataBinding.root.list_item_image
            )
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}
