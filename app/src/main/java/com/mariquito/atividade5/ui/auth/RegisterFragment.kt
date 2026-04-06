package com.mariquito.atividade5.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}