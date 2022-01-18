package ru.fefu.activitytracker.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonReg.setOnClickListener {
            startActivity(Intent(this, RegistrationScreen::class.java))
        }

        binding.ButtonLog.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
        }

    }
}