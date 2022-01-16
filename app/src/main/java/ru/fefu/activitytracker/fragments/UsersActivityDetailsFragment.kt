package ru.fefu.activitytracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActivityUsersDetailsBinding


class UsersActivityDetailsFragment (details: ListItem.Item) :
    BaseFragment<FragmentActivityUsersDetailsBinding>(R.layout.fragment_activity_users_details) {
    private var _binding: FragmentActivityUsersDetailsBinding? = null
    override val binding get() = _binding!!
    private val detail = details

    companion object {
        fun newInstance(info: ListItem.Item): UsersActivityDetailsFragment {
            return UsersActivityDetailsFragment(info)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textUserName.text = detail.user
        binding.textUserDistance.text = detail.distance
        binding.textUserDate.text = detail.date
        binding.textUserTime.text = detail.time
        binding.textUserStartTime.text = detail.startTime
        binding.textUserFinishTime.text = detail.endTime
        binding.toolbarUser.title = detail.activity
        binding.toolbarUser.setNavigationOnClickListener() {
            activity?.onBackPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivityUsersDetailsBinding.inflate(inflater, container, false)
        return binding.root     }
}