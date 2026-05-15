package com.mariquito.atividade5.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mariquito.atividade5.R
import com.mariquito.atividade5.databinding.FragmentRecoverAccountBinding
import com.mariquito.atividade5.databinding.FragmentSplashBinding
import com.mariquito.atividade5.util.initToolbar
import com.mariquito.atividade5.util.showBottomSheet


class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar14)
        initListener()
    }

    private fun initListener(){
        binding.btnRecover.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.recuperarsenha.text.toString().trim()

        if (email.isNotBlank()){
            Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
        }
        else{
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}