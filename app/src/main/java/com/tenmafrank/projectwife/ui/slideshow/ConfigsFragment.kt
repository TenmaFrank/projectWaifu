package com.tenmafrank.projectwife.ui.slideshow

import android.app.DatePickerDialog
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
        /*val textView: TextView = binding.textFieldInput
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return binding.root
    }
}