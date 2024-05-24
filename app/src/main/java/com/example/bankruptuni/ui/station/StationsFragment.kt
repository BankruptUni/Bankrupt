package com.example.bankruptuni.ui.station

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bankruptuni.databinding.FragmentStationsBinding

class StationsFragment : Fragment() {
    private var _binding : FragmentStationsBinding? = null
    //private var map : GoogleMap? = null
    /*this property is only valid between
    onCreateView and onDestroyView.*/
    private val binding get() = _binding!!
    private val params_stations: Array<String> = arrayOf("selecione", "5° de Madureira", "Canastro")
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {
        val stationViewModel =
            ViewModelProvider(this).get(StationsViewModel::class.java)

        _binding = FragmentStationsBinding.inflate(inflater, container, false)
        val root:View = binding.root

        val textView: TextView = binding.textStations
        stationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val spinner: Spinner = binding.spinnerStations
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(spinner.context,
                                            android.R.layout.simple_spinner_dropdown_item,
                                            params_stations
            )
        spinner.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}