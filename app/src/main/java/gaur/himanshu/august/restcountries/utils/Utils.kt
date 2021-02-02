package gaur.himanshu.august.restcountries.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import gaur.himanshu.august.restcountries.R


@GlideModule
class SampleAppGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled() = false

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.setLogLevel(Log.DEBUG)
    }
}

@BindingAdapter("glide")
fun loadImage(view:ImageView,url:String){
    GlideApp.with(view).load(url)
        .placeholder(R.drawable.ic_loading).error(R.drawable.ic_error_image).into(
        view
        )
}