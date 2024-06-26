package com.example.bankruptuni.ui.station

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bankruptuni.databinding.FragmentStationBinding

class StationFragment : Fragment() {
    private var _binding : FragmentStationBinding? = null
    //private var map : GoogleMap? = null
    /*this property is only valid between
    onCreateView and onDestroyView.*/
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {
        val stationViewModel =
            ViewModelProvider(this).get(StationViewModel::class.java)

        _binding = FragmentStationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStation

        stationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}