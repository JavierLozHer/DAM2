package edu.iesam.dam2.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String){
    Glide
        .with(this)
        .load(url)
        .into(this)
}

/*
fun ImageView.loadUrlCoil(url: String) {
    this.load(url)
}

 */