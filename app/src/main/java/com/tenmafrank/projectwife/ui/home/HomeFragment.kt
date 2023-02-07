package com.tenmafrank.projectwife.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.data.Message
import com.tenmafrank.projectwife.databinding.FragmentHomeBinding
import com.tenmafrank.projectwife.ui.home.chatadapter.ChatAdapter
import com.tenmafrank.projectwife.utils.Constants.RECEIVE_ID
import com.tenmafrank.projectwife.utils.Constants.SEND_ID
import com.tenmafrank.projectwife.utils.Time
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: ChatAdapter

    var messagesList = mutableListOf<Message>()

    private val welcomemsg = listOf("Hola!",
        "Hola ❤",
        "Uh-huh",
        "Estas... cansado?",
        "quieres una siesta conmigo",
        "Seguirias conmigo incluso si crezco?",
        "💕❤💕")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val hiList = resources.getStringArray(R.array.default_greatings)

        recyclerView()

        clickEvents()

        val random = (hiList.indices).random()
        customBotMessage(hiList[random])
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    /**
     * recyclerView
     * Description: initalize the main recycler view
     * 06/02/2023
     * TenmaFran
     **/
    private fun recyclerView() {
        adapter = ChatAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(binding.root.context)

    }

    /**
     * clickEvents
     * Description: handle the events triggered trough click
     * 06/02/2023
     * TenmaFran
     **/
    private fun clickEvents() {
        //Send a message
        binding.btnSend.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        binding.userMessageTextField.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    /**
     * sendMessage
     * Description: read the messasge and add to the recycler view
     * 06/02/2023
     * TenmaFran
     **/
    private fun sendMessage() {
        val message = binding.userMessageInputTextField.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, SEND_ID, timeStamp))
            binding.userMessageInputTextField.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

            //botResponse(message)
        }
    }

    /**
     * customBotMessage
     * Description: send a message as bot
     * 06/02/2023
     * TenmaFran
     **/
    private fun customBotMessage(message: String) {
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}