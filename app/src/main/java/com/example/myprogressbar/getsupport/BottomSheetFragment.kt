package com.example.myprogressbar.getsupport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myprogressbar.R
import com.example.myprogressbar.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            Reasons("General enquiry"),
            Reasons("Bookings enquiry"),
            Reasons("Booking request enquiry"),
            Reasons("Services enquiry"),
            Reasons("Riding academy")
        )


        adapter = Adapter(list)
        adapter.onItemClicked = { selectedReason ->
            (activity as? GetSupportActivity)?.setSelectedValue(selectedReason.reasons)
            dismiss()
        }

        binding.reasonsRecycler.apply {
            adapter = this@BottomSheetFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
