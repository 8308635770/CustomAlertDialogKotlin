package com.example.customalertdialogkotlin

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.Exception

class CustomDialog :DialogFragment() {

     var customDialogListerner: CustomDialogListerner? =null



    interface CustomDialogListerner{
        fun onNextClicked(userName:String,password:String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view= activity?.layoutInflater?.inflate(R.layout.dialog_layout,null)
        val builder=AlertDialog.Builder(activity)

        builder.setTitle("Alert...")
            .setView(view)
            .setPositiveButton("Next",DialogInterface.OnClickListener(){
                dialog, which ->
                customDialogListerner?.onNextClicked(view?.findViewById<EditText>(R.id.edit_username)?.text.toString(),
                                                    view?.findViewById<EditText>(R.id.edit_password)?.text.toString())
            })
//            .setNegativeButton("Cancel",DialogInterface.OnClickListener(){
//                dialog, which ->
//                customDialogListerner?.onNextClicked(view?.findViewById<EditText>(R.id.edit_username)?.text.toString(),
//                    view?.findViewById<EditText>(R.id.edit_password)?.text.toString())
//            })
            .setNegativeButton("Cancel",null)
            .setIcon(R.drawable.ic_launcher_background)

        val alertDialog=builder.create()


        return alertDialog

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is CustomDialogListerner){
            customDialogListerner=context
        }else{
            throw Exception(context.toString()+" customeDialog Listener is not implemented")
        }
    }

    override fun onDetach() {
        super.onDetach()
        customDialogListerner=null
    }
}