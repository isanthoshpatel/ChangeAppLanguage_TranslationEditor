package com.example.translationeditorexample

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var array: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.app_name)
        array = arrayOf("English", "Hindi", "Telugu")

        bt_lang.setOnClickListener {
            choselang()
        }

        var sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        var lng = sp.getString("lng", "")

    }//onCreate()

    fun choselang() {
        AlertDialog.Builder(this@MainActivity)
            .setTitle("Chose Your Language")
            .setIcon(R.drawable.ic_launcher_background)
            .setSingleChoiceItems(array, -1) { dialog, which ->
                when (which) {
                    0 -> {
                        changelang("en")
                        recreate()

                    }
                    1 -> {
                        changelang("hi")
                        recreate()
                    }
                    2 -> {
                        changelang("te")
                        recreate()
                    }

                }
                dialog.dismiss()
            }.create().show()


    }

    fun changelang(lng: String) {

        val dm = resources.displayMetrics
        val conf = resources.configuration
        conf.setLocale(Locale(lng))
        resources.updateConfiguration(conf, dm)

        getSharedPreferences("sp", Context.MODE_PRIVATE).edit().putString("lng", lng).apply()
    }


}





