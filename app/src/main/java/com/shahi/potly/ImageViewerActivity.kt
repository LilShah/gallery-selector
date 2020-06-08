package com.shahi.potly

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_image_viewer.*
import com.bumptech.glide.Glide

class ImageViewerActivity : AppCompatActivity() {
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val actionBar = supportActionBar
        actionBar!!.title = "Confirm Selection"
        actionBar.setDisplayHomeAsUpEnabled(true)

        imageUri = Uri.parse(intent.getStringExtra("image"))
        //image_view.setImageURI(imageUri)

        Glide.with(applicationContext).load(imageUri).into(fullscreen_content)

        send_button.setOnClickListener {
            handleClick()
        }
    }
    private fun uploaded(){
        Toast.makeText(this, "Uploaded...", Toast.LENGTH_LONG).show();
    }
    private fun handleClick() {
        Toast.makeText(this, "Sending...", Toast.LENGTH_LONG).show();
        Handler().postDelayed({onBackPressed()},300)
        Handler().postDelayed({uploaded()},5000)
    }

    override fun onSupportNavigateUp(): Boolean {
        imageUri=null
        onBackPressed()
        return true
    }
}
