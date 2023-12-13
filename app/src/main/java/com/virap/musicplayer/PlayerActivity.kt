package com.virap.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.virap.musicplayer.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    companion object {
        lateinit var musicListPA : ArrayList<Music>
        var songPosition: Int = 0
        var mediaPlayer : MediaPlayer? = null
        var isPlaying : Boolean = false
    }

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.lightBlueNav)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeLayout()
        binding.playPauseBtnPA.setOnClickListener {
            if (isPlaying) {
                pauseMusic()
            } else {
                playMusic()
            }
        }
    }

    private fun setLayout() {
        Glide.with(this)
            .load(musicListPA[songPosition].artUri)
            .apply(RequestOptions().placeholder(R.drawable.music_player_icon_slash_screen).centerCrop())
            .into(binding.songImgPA)
        binding.songNamePA.text = musicListPA[songPosition].title
    }

    private fun createMediaPlayer() {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer()
            }
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(musicListPA[songPosition].path)
            mediaPlayer!!.prepare()
            playMusic()
        } catch (e: Exception) {return}
    }

    private fun initializeLayout() {
        songPosition = intent.getIntExtra("index", 0)
        when (intent.getStringExtra("class")) {
            "MusicAdapter" -> {
                musicListPA = ArrayList()
                musicListPA.addAll(MainActivity.MusicListMA)
                setLayout()
                createMediaPlayer()
            }
        }
    }

    private fun playMusic() {
        binding.playPauseBtnPA.setIconResource(R.drawable.pause_icon)
        isPlaying = true
        mediaPlayer!!.start()
    }
    private fun pauseMusic() {
        binding.playPauseBtnPA.setIconResource(R.drawable.play_icon)
        isPlaying = false
        mediaPlayer!!.pause()
    }
}