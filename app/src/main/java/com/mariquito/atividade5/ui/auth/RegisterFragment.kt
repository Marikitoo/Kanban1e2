package com.mariquito.atividade5.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mariquito.atividade5.R
import com.mariquito.atividade5.databinding.FragmentRegisterBinding
import com.mariquito.atividade5.databinding.FragmentSplashBinding
import com.mariquito.atividade5.util.initToolbar

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()

    }

    private fun initListener(){
        binding.buttonRegister.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextPassword.text.toString().trim()
        if (email.isNotBlank()){
            if (senha.isNotBlank()){
                Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Preencha sua senha!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Preencha seu e-mail!", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}