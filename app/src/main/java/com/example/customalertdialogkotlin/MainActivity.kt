package com.example.customalertdialogkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() ,CustomDialog.CustomDialogListerner {



     lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Activity One")



        btn=findViewById(R.id.button)

        btn.setOnClickListener(View.OnClickListener {

            openAlertDialog()
        })

    }

    private fun openAlertDialog() {

        val customDialog=CustomDialog()
        customDialog.show(supportFragmentManager,"Custom Dialog")

    }

    override fun onNextClicked(userName: String, password: String) {
        findViewById<TextView>(R.id.textview_username).setText(userName)
        findViewById<TextView>(R.id.textview_password).setText(password)
    }
}