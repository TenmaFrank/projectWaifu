package com.tenmafrank.projectwife.ui.slideshow

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.datepicker.MaterialDatePicker
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.databinding.FragmentConfigsBinding
import java.util.*

class ConfigsFragment : Fragment() {

    private lateinit var binding: FragmentConfigsBinding
    private lateinit var viewModel: ConfigsViewModel

    private val c = Calendar.getInstance()
    private val year = c.get(Calendar.YEAR)
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_configs,container,false)
        viewModel = ViewModelProvider(this)[ConfigsViewModel::class.java]
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText(resources.getText(R.string.config_bday_datepicker_label))
                .build()

        binding.userBdayTextField.setEndIconOnClickListener{
            val dpp = DatePickerDialog(
                requireContext(), { _, mYear, mMonth, mDay ->
                    val sMonth = if(mMonth < 10){
                        "0${mMonth+1}"
                    } else{
                        "${mMonth+1}"
                    }
                    val sDay = if(mDay < 10){
                        "0$mDay"
                    } else{
                        "$mDay"
                    }
                    val birthday = "$sDay/$sMonth/$mYear"
                    binding.userBdayInputTextField.setText(birthday)
                },
                year,
                month,
                day
            )
            c.set(year,month,day)
            dpp.datePicker.maxDate = c.timeInMillis
            dpp.show()
        }

        binding.confirmButton.setOnClickListener {
            val userName = binding.userNameInputTextField.text.toString()
            val userBday = binding.userBdayInputTextField.text.toString()
            val userGender = binding.userGenderInput.text.toString()
            val soName = binding.soNameInputTextField.text.toString()
            val soBday = binding.soBdayInputTextField.text.toString()
            val soGender = binding.soGenderInputTextField.text.toString()
            val soWeight = binding.soWeightInputTextField.text.toString()
            val soHeight = binding.soHeightInputTextField.text.toString()
            val soBust = binding.soBustSizeInputTextField.text.toString()
            val soWaist = binding.soWaistSizeInputTextField.text.toString()
            val soHip = binding.soHipSizeInputTextField.text.toString()
            val soPersonality = binding.soPersonalityInputTextField.text.toString()
            val soBloodType = binding.soSanguineInputTextField.text.toString()
            val soNickname = binding.lovelyNameInputTextField.text.toString()
            val userNickname = binding.userLovelyNameInputTextField.text.toString()
            val registerd = viewModel.setRegister(userName,userBday, userGender, soName, soBday, soGender, soWeight,
            soHeight, soBust, soWaist, soHip, soPersonality, soBloodType, soNickname, userNickname)
        }
        return binding.root
    }
}