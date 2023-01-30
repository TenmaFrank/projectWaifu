package com.tenmafrank.projectwife.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.databinding.FragmentAboutBinding
import com.tenmafrank.projectwife.utils.Toaster

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    private lateinit var viewModel: AboutViewModel

    private val toster = Toaster()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        viewModel = ViewModelProvider(this)[AboutViewModel::class.java]

        binding.aboutRulesButton.setOnClickListener(){
            toster.makeAToast(requireContext(), resources.getString(R.string.coming_soon))
        }
        binding.aboutHowUseButton.setOnClickListener(){
            toster.makeAToast(requireContext(), resources.getString(R.string.coming_soon))
        }
        binding.aboutFaqButton.setOnClickListener(){
            toster.makeAToast(requireContext(), resources.getString(R.string.coming_soon))
        }
        binding.aboutChangeLogButton.setOnClickListener(){
            toster.makeAToast(requireContext(), resources.getString(R.string.coming_soon))
        }
        binding.aboutKumiButton.setOnClickListener(){
           findNavController().navigate(R.id.action_nav_gallery_to_kumiFragment)
        }

        return binding.root
    }
}