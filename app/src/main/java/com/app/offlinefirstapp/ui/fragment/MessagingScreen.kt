package com.app.offlinefirstapp.ui.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.app.offlinefirstapp.core.BaseFragment
import com.app.offlinefirstapp.databinding.FragmentMessagingScreenBinding
import com.app.offlinefirstapp.ui.adapter.MessagesAdapter
import com.app.offlinefirstapp.ui.viewmodel.MessagingViewModel
import java.util.UUID
import javax.inject.Inject


class MessagingScreen : BaseFragment<FragmentMessagingScreenBinding>() {

   override fun getViewBinding() : (inflater: LayoutInflater,
                                    container: ViewGroup?,
                                    attachToParent : Boolean
   ) -> FragmentMessagingScreenBinding = FragmentMessagingScreenBinding::inflate

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mViewModel by viewModels<MessagingViewModel> { viewModelFactory }

    private lateinit var mAdapter : MessagesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.homeComponent().create().inject(this)
    }

    override fun initialize() {
        setUpAdapter()
        bindViewModel()
        binding.btnSend.setOnClickListener {
            val message = binding.messageBox.text.toString()
            if(message.isNotEmpty()) {
                mViewModel.sendMessage(message)
            }
        }
    }

    private fun setUpAdapter() {
        mAdapter = MessagesAdapter()
        binding.messageRecyclerView.adapter = mAdapter
    }

    private fun bindViewModel() {
        mViewModel.message.observe(viewLifecycleOwner) {
            mAdapter.updateList(it)
        }
    }
}