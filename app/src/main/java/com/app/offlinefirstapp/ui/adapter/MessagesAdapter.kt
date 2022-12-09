package com.app.offlinefirstapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.app.offlinefirstapp.R
import com.app.offlinefirstapp.database.entities.MessageEntity
import com.app.offlinefirstapp.databinding.MessageItemBinding
import com.app.offlinefirstapp.model.Message

class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {

    private val messages = ArrayList<Message>()

    class ViewHolder(private val binding: MessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(message: Message) {
            binding.message.text = message.message
            if(message.status == MessageEntity.STATUS_PENDING) {
                binding.message.setTextColor(ContextCompat.getColor(binding.message.context,R.color.black_light))
            } else {
                binding.message.setTextColor(ContextCompat.getColor(binding.message.context,R.color.black))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        holder.onBind(message)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun updateList(list : List<Message>) {
        messages.clear()
        messages.addAll(list)
        notifyDataSetChanged()
    }
}