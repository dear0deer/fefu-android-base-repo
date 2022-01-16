package ru.fefu.activitytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityMainBinding
import ru.fefu.activitytracker.fragments.ActivityFragmentFlow
import ru.fefu.activitytracker.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fragmentContainerView,
                    ActivityFragmentFlow(),
                    "activityFragment"
                )
                commit()
            }
        }

        binding.bottomNav.setOnNavigationItemSelectedListener {
            val activityFragment = supportFragmentManager.findFragmentByTag("activityFragment")
            val profileFragment = supportFragmentManager.findFragmentByTag("profileFragment")
            when (it.itemId) {
                R.id.activity_navigation -> {
                    if (profileFragment !== null) {
                        supportFragmentManager.beginTransaction().hide(profileFragment).commit()
                    }
                    if (activityFragment !== null) {
                        supportFragmentManager.beginTransaction().show(activityFragment).commit()
                    }
                }

                R.id.profile_navigation -> {
                    if (activityFragment !== null) {
                        supportFragmentManager.beginTransaction().hide(activityFragment).commit()
                    }
                    if (profileFragment !== null) {
                        supportFragmentManager.beginTransaction().show(profileFragment).commit()
                    } else {
                        supportFragmentManager.beginTransaction().apply {
                            add(
                                R.id.fragmentContainerView,
                                ProfileFragment(),
                                "profileFragment"
                            )
                            commit()
                        }
                    }
                }
            }
            true
        }
    }

    override fun onBackPressed() {
        val active = supportFragmentManager.fragments.firstOrNull{!it.isHidden}!!
        val childManager = active.childFragmentManager

        if (childManager.backStackEntryCount != 0) {
            childManager.popBackStack()
        }

        else if (supportFragmentManager.backStackEntryCount != 0) {
            supportFragmentManager.popBackStack()
        }

        else {
            super.onBackPressed()
        }
    }
}