package com.mariquito.atividade5.util

import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mariquito.atividade5.R
import com.mariquito.atividade5.databinding.BottomSheetBinding


fun Fragment.initToolbar(toolbar : Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title =""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed() }
    }

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String,
    onClick: () -> Unit ={}
){

    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate( layoutInflater,  null,  false)

    binding.textviewTitle.text = getText( titleDialog ?: R.string.text_title_warning )

    binding.textviewMessage.text = message

    binding.buttonOk.text = getText( titleButton ?: R.string.text_button_warning)
    binding.buttonOk.setOnClickListener {
        //Quando o botão buttomOk é clicado o código executa o que foi definido no onClick. Depois fecha o Bottom Sheet.
        onClick() //callback
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}

