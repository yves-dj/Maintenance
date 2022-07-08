package com.example.maintenance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.data.entities.MaintenanceTask
import com.example.maintenance.data.entities.Vehicle
import com.example.maintenance.databinding.FragmentVehicleBinding
import com.example.maintenance.vehicle.VehicleListAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VehicleFragment : Fragment() {

    private var _binding: FragmentVehicleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var vehicleAdapter: VehicleListAdapter

    private var testList = mutableListOf<Vehicle>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (testList.size == 0) {
            var taskForFirstVeh = MaintenanceTask(description = "This needs to be done")
            var firstVeh = Vehicle(0, "HONDA", mutableListOf(taskForFirstVeh))
            var secondVeh = Vehicle(0, "YAMAHA", mutableListOf(taskForFirstVeh))
            var thirdVeh = Vehicle(0, "SUZUKI")
            testList.add(firstVeh)
            testList.add(secondVeh)
            testList.add(thirdVeh)
        }

        _binding = FragmentVehicleBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.vehicleRec) {
            layoutManager = LinearLayoutManager(context)
            vehicleAdapter = VehicleListAdapter(testList) { selectedVehicle ->
                navigateToVehicleDetails(selectedVehicle, view)
            }
            adapter = vehicleAdapter
        }

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToVehicleDetails(vehicle: Vehicle, view: View) {
        Toast.makeText(view.context, "listItem ${vehicle.vehicleName} clicked", Toast.LENGTH_LONG).show()
        val action = VehicleFragmentDirections.actionVehicleFragmentToVehicleDetailFragment(vehicle)
        findNavController().navigate(action)
    }
}