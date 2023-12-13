package com.virap.musicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.virap.musicplayer.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.lightBlueNav)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}