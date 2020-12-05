package dev.nmgalo.presentation.schedule

import dev.nmgalo.presentation.common.model.Identity

class ScheduleUiModel(
    override val id: Int,
    val title: String,
    val onClick: () -> Unit
) : Identity {
    constructor(
        schedule: ScheduleUiModel,
        onClick: () -> Unit
    ) : this(
        id = schedule.id,
        title = schedule.title,
        onClick = onClick
    )
}