package com.virap.musicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.virap.musicplayer.databinding.ActivityPlaylistDetailsBinding

class PlaylistDetails : AppCompatActivity() {

    lateinit var binding : ActivityPlaylistDetailsBinding

    companion object {
        var currentPlaylistPos: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.lightBlueNav)
        binding = ActivityPlaylistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentPlaylistPos = intent.extras?.get("index") as Int
    }
}
