package dev.nmgalo.presentation.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.nmgalo.presentation.R
import dev.nmgalo.presentation.databinding.FragmentScheduleBinding

@AndroidEntryPoint
class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val adapter = ScheduleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentScheduleBinding.bind(view).onViewBind()
    }

    private fun FragmentScheduleBinding.onViewBind() {
        scheduleRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.submitList(listOf(
            ScheduleUiModel(1, "Nick is awesome fellow", {}),
            ScheduleUiModel(2, "Nick is still awesome fellow", {}),
        ))
        scheduleRecyclerView.adapter = adapter
    }

}