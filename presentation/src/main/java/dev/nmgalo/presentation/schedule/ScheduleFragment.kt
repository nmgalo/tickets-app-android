package dev.nmgalo.presentation.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.nmgalo.presentation.R
import dev.nmgalo.presentation.databinding.FragmentScheduleBinding

@AndroidEntryPoint
class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val viewModel: ScheduleViewModel by viewModels()

    private val adapter = ScheduleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentScheduleBinding.bind(view).onViewBind()
    }

    private fun FragmentScheduleBinding.onViewBind() {
        viewModel.schedules.observe(viewLifecycleOwner, adapter::submitList)
        scheduleRecyclerView.layoutManager = LinearLayoutManager(context)
        scheduleRecyclerView.adapter = adapter
    }

}