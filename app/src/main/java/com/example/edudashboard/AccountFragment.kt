package com.example.edudashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.edudashboard.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveProfile.setOnClickListener {
            val name = binding.etName.text.toString()
            val nim = binding.etNim.text.toString()
            val ipkStr = binding.etIpk.text.toString()

            var isValid = true

            if (name.isEmpty()) {
                binding.etName.error = getString(R.string.error_empty_field)
                isValid = false
            }

            if (nim.isEmpty()) {
                binding.etNim.error = getString(R.string.error_empty_field)
                isValid = false
            }

            if (ipkStr.isEmpty()) {
                binding.etIpk.error = getString(R.string.error_empty_field)
                isValid = false
            } else {
                val ipk = ipkStr.toDoubleOrNull()
                if (ipk == null || ipk < 0.0 || ipk > 4.0) {
                    binding.etIpk.error = getString(R.string.error_invalid_ipk)
                    isValid = false
                }
            }

            if (isValid) {
                val bundle = Bundle().apply {
                    putString("EXTRA_NAME", name)
                    putString("EXTRA_NIM", nim)
                    putString("EXTRA_IPK", ipkStr)
                }

                val intent = Intent(requireContext(), DetailAccountActivity::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}