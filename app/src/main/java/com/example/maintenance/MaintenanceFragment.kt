package com.example.maintenance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.maintenance.data.MaintenanceTask
import com.example.maintenance.data.Vehicle
import com.example.maintenance.databinding.FragmentMaintenanceBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MaintenanceFragment : Fragment() {

    private var _binding: FragmentMaintenanceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args: MaintenanceFragmentArgs by navArgs()
    private lateinit var vehicle: Vehicle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vehicle = args.vehicle

        _binding = FragmentMaintenanceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = vehicle.vehicleName

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}