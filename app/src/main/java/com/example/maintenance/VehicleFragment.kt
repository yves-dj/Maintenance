package com.example.maintenance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.data.db.VehicleDB
import com.example.maintenance.data.entities.MaintenanceTask
import com.example.maintenance.data.entities.Vehicle
import com.example.maintenance.databinding.FragmentVehicleBinding
import com.example.maintenance.vehicle.VehicleListAdapter
import com.example.maintenance.viewmodel.VehicleViewModel
import com.example.maintenance.viewmodel.VehicleViewModelFactory
import kotlinx.coroutines.CoroutineScope

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VehicleFragment : Fragment() {

    private var _binding: FragmentVehicleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var vehicleAdapter: VehicleListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = VehicleDB.getInstance(application, CoroutineScope(context!!)).vehicleDao()
        val viewModelFactory = VehicleViewModelFactory(dataSource, application)
        val vehicleViewModel = ViewModelProvider(this, viewModelFactory)[VehicleViewModel::class.java]


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