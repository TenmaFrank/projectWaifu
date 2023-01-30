package com.tenmafrank.projectwife.ui.configs

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.datepicker.MaterialDatePicker
import com.tenmafrank.projectwife.R
import com.tenmafrank.projectwife.databinding.FragmentConfigsBinding
import com.tenmafrank.projectwife.userpreferences.UserAplication.Companion.userData
import com.tenmafrank.projectwife.utils.Constants
import com.tenmafrank.projectwife.utils.Toaster
import java.util.*

class ConfigsFragment : Fragment() {

    private lateinit var binding: FragmentConfigsBinding
    private lateinit var viewModel: ConfigsViewModel

    private val toaster = Toaster()
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
        var registerLabel = "incomplete"
        var toastMessage = "nothing to do"

        if (userData.getRegister()){
            with(binding){
                userNameTextField.isEnabled = false
                userNameInputTextField.setText(userData.getUserName())

                userBdayTextField.isEnabled = false
                userBdayInputTextField.setText(userData.getUserBday())

                userGenderTextField.isEnabled = false
                userGenderInput.setText(userData.getUserGender())

                soNameTextField.isEnabled = false
                soNameInputTextField.setText(userData.getSoName())

                soBdayTextField.isEnabled = false
                soBdayInputTextField.setText(userData.getSoBday())

                soGenderTextField.isEnabled = false
                soGenderInputTextField.setText(userData.getSoGender())

                soHeightTextField.isEnabled = false
                soHeightInputTextField.setText(userData.getSoHeight())

                soWeightTextField.isEnabled = false
                soWeightInputTextField.setText(userData.getSoWeightSize())

                soBustSizeTextField.isEnabled = false
                soBustSizeInputTextField.setText(userData.getSoBustSizet())

                soWaistSizeTextField.isEnabled = false
                soWaistSizeInputTextField.setText(userData.getSoWaistSize())

                soHipSizeTextField.isEnabled = false
                soHipSizeInputTextField.setText(userData.getSoHipSize())

                soPersonalityTextField.isEnabled = false
                soPersonalityInputTextField.setText(userData.getSoPersonalitySize())

                soSanguineTextField.isEnabled = false
                soSanguineInputTextField.setText(userData.getSoBloodType())

                lovelyNameTextField.isEnabled = false
                lovelyNameInputTextField.setText(userData.getSoNickname())

                userLovelyNameTextField.isEnabled = false
                userLovelyNameInputTextField.setText(userData.getUserNickname())

                lockConfirmButton()
            }
        }
        else{
            unlockConfirmButton()
        }

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

        binding.soBdayTextField.setEndIconOnClickListener{
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
                    binding.soBdayInputTextField.setText(birthday)
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
            registerLabel = viewModel.setRegister(userName,userBday, userGender, soName, soBday,
                soGender, soWeight, soHeight, soBust, soWaist, soHip, soPersonality, soBloodType,
                soNickname, userNickname)

            when(registerLabel){
                Constants.INCOMPLETE ->
                    toastMessage = resources.getString(R.string.incomplete_form_label)
                Constants.INVALID_CHARS ->
                    toastMessage = resources.getString(R.string.invalid_chars_label)
                Constants.FORBIDDEN_NAME ->
                    toastMessage = resources.getString(R.string.forbidden_name_label)
                Constants.SPECIAL_USER -> {
                    toastMessage = resources.getString(R.string.special_user_welcome)
                    lockConfirmButton()
                }
                Constants.COMPLETE -> {
                    toastMessage = resources.getString(R.string.incomplete_form_label)
                    lockConfirmButton()
                }
            }
            toaster.makeAToast(requireContext(),toastMessage)
        }
        return binding.root
    }

    private fun lockConfirmButton(){
        binding.confirmButton .text = resources.getText(R.string.data_uploaded)
        binding.confirmButton.isEnabled = false
    }

    private fun unlockConfirmButton(){
        binding.confirmButton .text = resources.getText(R.string.upload_data)
        binding.confirmButton.isEnabled = true
    }
}