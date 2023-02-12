package com.tenmafrank.projectwife.ui.loginactivity.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.databinding.FragmentLoginBinding
import com.tenmafrank.projectwife.ui.MainActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this,
            object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.logInButton.setOnClickListener {
            openActivity(MainActivity())
            activity?.finish()
        }

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signinFragment)
        }

        binding.aboutButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_aboutFragment)
        }
        return binding.root
    }

    private fun openActivity(activityName: Activity){
        val intent = Intent(activity, activityName::class.java)
        val context = view?.context
        context?.startActivity(intent)
    }
}