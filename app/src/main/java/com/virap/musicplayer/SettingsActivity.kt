package com.virap.musicplayer

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.virap.musicplayer.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Settings"

        when (MainActivity.themeIndex) {
            0 -> binding.lightTheme.setBackgroundColor(Color.LTGRAY)
            1 -> binding.darkTheme.setBackgroundColor(Color.BLUE)
            2 -> binding.blackTheme.setBackgroundColor(Color.BLACK)
        }

        binding.lightTheme.setOnClickListener {
            saveTheme(0)
        }
        binding.darkTheme.setOnClickListener {
            saveTheme(1)
        }
        binding.blackTheme.setOnClickListener {
            saveTheme(2)
        }
        binding.versionName.text = setVersionDetails()
    }
    private fun saveTheme(index: Int) {
        if (MainActivity.themeIndex != index) {
            val editor = getSharedPreferences("THEMES", MODE_PRIVATE).edit()
            editor.putInt("themeIndex", index)
            editor.apply()

            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle("Apply Theme")
                .setMessage("Do you want to apply theme ?")
                .setPositiveButton("Yes") { _, _ ->
                    exitApplication()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
            val  customDialog = builder.create()
            customDialog.show()
            customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE)
            customDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE)
        }
    }
    private fun setVersionDetails(): String {
        return "Version Name: 0.${BuildConfig.VERSION_NAME}"
    }
}