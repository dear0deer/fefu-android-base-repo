package ru.fefu.activitytracker.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.ItemAdapter
import ru.fefu.activitytracker.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActivityUsersBinding

class ActivityUsersFragment : BaseFragment<FragmentActivityUsersBinding>(R.layout.fragment_activity_users) {
    private val usersListRepository = UsersListRepo()
    private val adapterItems = ItemAdapter(usersListRepository.getItem())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rcView) {
            adapter = adapterItems
            layoutManager = LinearLayoutManager(requireContext())
        }

        adapterItems.setItemClickListener {
            val manager = activity?.supportFragmentManager?.findFragmentByTag("activityFragment")?.childFragmentManager
            manager?.beginTransaction()?.apply {
                manager.fragments.forEach(::hide)
                replace(
                    R.id.activity_fragment_flow_container,
                    UsersActivityDetailsFragment.newInstance(usersListRepository.getItem()[it] as ListItem.Item),
                    "tadUsers"
                )
                addToBackStack(null)
                commit()
            }
        }
    }



}