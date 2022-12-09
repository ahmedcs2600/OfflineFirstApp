package com.app.offlinefirstapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.app.offlinefirstapp.App
import com.app.offlinefirstapp.di.AppComponent

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding : VB? = null
    protected val binding : VB
    get() = checkNotNull(_binding)

    protected val appComponent : AppComponent
    get() = ((requireActivity().applicationContext as App).appComponent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding().invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    abstract fun initialize()

    abstract fun getViewBinding() : (inflater: LayoutInflater, container: ViewGroup?, attachToParent : Boolean) -> VB

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}