package dev.nmgalo.presentation.schedule

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.nmgalo.presentation.R
import dev.nmgalo.presentation.common.IntIdentityDiffUtilCallback
import dev.nmgalo.presentation.databinding.ScheduleItemBinding
import dev.nmgalo.presentation.utils.inflate

class ScheduleAdapter : ListAdapter<ScheduleUIModel, ScheduleAdapter.ViewHolder>(
    IntIdentityDiffUtilCallback()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.schedule_item)) {
        fun onBind(item: ScheduleUIModel) {
            val binder = ScheduleItemBinding.bind(itemView)
            binder.itemTitle.text = item.title
        }
    }


}