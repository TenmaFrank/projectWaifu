package com.tenmafrank.projectwife.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.databinding.FragmentConfigsBinding

class ConfigsFragment : Fragment() {

    private lateinit var binding: FragmentConfigsBinding
    private lateinit var viewModel: ConfigsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_configs,container,false)
        viewModel = ViewModelProvider(this)[ConfigsViewModel::class.java]
        /*val textView: TextView = binding.textFieldInput
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return binding.root
    }
}