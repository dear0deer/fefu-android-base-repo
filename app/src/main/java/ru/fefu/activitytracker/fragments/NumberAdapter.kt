package ru.fefu.activitytracker.fragments


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class NumberAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->{
                ActivityMyFragment()
            }
            1->{
                ActivityUsersFragment()
            }
            else->{
                ActivityFragment()
            }
        }
    }

}