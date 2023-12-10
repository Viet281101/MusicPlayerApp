package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaplayer = MediaPlayer.create( this,R.raw.music )

        play_btn.setOnClickListener {
            if (!mediaplayer.isPlaying) {
                mediaplayer.start()
                play_btn.setImageResource(R.drawable.baseline_pause_24)
            } else {
                mediaplayer.pause()
                play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }
    }
}