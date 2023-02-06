package com.tenmafrank.projectwife.ui.home.chatadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.data.Message
import com.tenmafrank.projectwife.utils.Constants.RECEIVE_ID
import com.tenmafrank.projectwife.utils.Constants.SEND_ID


class ChatAdapter: RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {

                //Remove message on the item clicked
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val tvMessage = holder.itemView.findViewById<TextView>(R.id.tv_message)
        val tvBotMessage = holder.itemView.findViewById<TextView>(R.id.tv_bot_message)
        val currentMessage = messagesList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                tvMessage.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                tvBotMessage.visibility = View.GONE
            }
            RECEIVE_ID -> {
                tvBotMessage.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                tvMessage.visibility = View.GONE
            }
        }
    }

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }

}