package com.virap.musicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.virap.musicplayer.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    lateinit var binding : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.lightBlueNav)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "About"

        binding.aboutText.text = aboutText()
    }
    private fun aboutText(): String {
        return "Developed By:\nViet NGUYEN\n and \nRaphaël MOSCATELLI" +
                "\n\nRelease version 0.${BuildConfig.VERSION_NAME}" +
                "\n\nIf you want to provide feedback, we will happy to receive it"
    }
}