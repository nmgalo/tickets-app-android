package dev.nmgalo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import dev.nmgalo.presentation.utils.SingleLiveEvent
import dev.nmgalo.presentation.utils.nav.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    val navigationCommands =
        SingleLiveEvent<NavigationCommand>()

    fun NavDirections.navigate() =
        navigationCommands.postValue(NavigationCommand.To(this))

}
