package dev.nmgalo.presentation.common

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import dev.nmgalo.presentation.common.model.Identity

class IntIdentityDiffUtilCallback<ID : Identity> : DiffUtil.ItemCallback<ID>() {
    override fun areItemsTheSame(oldItem: ID, newItem: ID) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ID, newItem: ID) =
        oldItem == newItem
}
