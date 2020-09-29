package com.example.quizapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoview = findViewById<VideoView>(R.id.videoView)
        val uri = Uri.parse("android.resource://$packageName/" +R.raw.video_three  )
        videoview.setVideoURI(uri)
        videoview.start()

    }



    fun openActivity(view: View) {
        startActivity(Intent(this, Quiz::class.java))
    }
}
