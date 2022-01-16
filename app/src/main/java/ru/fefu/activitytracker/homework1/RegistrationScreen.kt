package ru.fefu.activitytracker.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.fefu.activitytracker.R

class RegistrationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

    }
    fun back(view: View) {
        onBackPressed()
    }
}