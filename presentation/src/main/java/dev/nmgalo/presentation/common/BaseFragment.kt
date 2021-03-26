package dev.nmgalo.presentation.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.nmgalo.presentation.R
import dev.nmgalo.presentation.utils.nav.NavigationCommand

abstract class BaseFragment<out VM : BaseViewModel>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId) {

    abstract val viewModel: VM

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigationCommands.observe(viewLifecycleOwner, { command ->
            when (command) {
                is NavigationCommand.To ->
                    findNavController().navigate(command.directions)
                is NavigationCommand.BackTo ->
                    findNavController().navigate(command.destinationId)
                NavigationCommand.Back ->
                    findNavController().popBackStack()
                NavigationCommand.ToRoot ->
                    findNavController().navigate(R.id.scheduleFragment)
            }
        })
    }

}