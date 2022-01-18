package ru.fefu.activitytracker.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityRegistrationBinding

class RegistrationScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarReg.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}