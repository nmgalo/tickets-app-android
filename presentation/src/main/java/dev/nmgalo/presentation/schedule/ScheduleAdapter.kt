package dev.nmgalo.presentation.schedule

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.nmgalo.presentation.R
import dev.nmgalo.presentation.databinding.ScheduleItemBinding
import dev.nmgalo.presentation.utils.inflate


class ScheduleAdapter : ListAdapter<ScheduleUIModel, ScheduleAdapter.ViewHolder>(
    ListItemCallback()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.schedule_item)) {
        fun onBind(item: ScheduleUIModel) {
            val binder = ScheduleItemBinding.bind(itemView)
            binder.root.setOnClickListener { item.onClick() }
            binder.fromStationTextView.text = item.FromStationNameGeo
            binder.departureTimeTextView.text = "08:00"
            binder.enteringTimeTextView.text = "12:19"
            binder.toStationTextView.text = item.ToStationNameGeo
        }
    }


    class ListItemCallback : DiffUtil.ItemCallback<ScheduleUIModel>() {
        override fun areItemsTheSame(
            oldItem: ScheduleUIModel,
            newItem: ScheduleUIModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ScheduleUIModel,
            newItem: ScheduleUIModel
        ) = oldItem.GeorgianRailwayStationsId == newItem.GeorgianRailwayStationsId
    }

}