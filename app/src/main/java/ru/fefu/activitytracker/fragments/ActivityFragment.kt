package ru.fefu.activitytracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R

import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.fragments.NumberAdapter
import ru.fefu.activitytracker.databinding.FragmentActivityBinding


class ActivityFragment : Fragment() {
    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myFragment = inflater.inflate(R.layout.fragment_activity, container, false)
        val tabLayout = myFragment.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = myFragment.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = NumberAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) {tab, position->
            when(position) {
                0->{
                    tab.text = "Моя"
                }
                1->{
                    tab.text = "Пользователей"
                }
            }
        }.attach()

        return myFragment
    }

//    override fun getFlowFragmentManager(): FragmentManager = (parentFragment as FlowFragment).getFlowFragmentManager()

}