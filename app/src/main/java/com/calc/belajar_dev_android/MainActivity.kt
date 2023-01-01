package com.calc.belajar_dev_android

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var  nameEditText: EditText
    private lateinit var  sayHelloButton: Button
    private lateinit var  sayHelloTextView: TextView

    private fun initComponents(){
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "enable fingerprint feature")
        }else {
            Log.i("FEATURE", "disable fingerprint feature")
        }
    }

    private fun checkPlatformVersion(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            Log.i("VERSION", "disabled some features")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener{
            checkFingerprint()
//            Log.d("PGZN", "This is debug log")
//            Log.i("PGZN", "This is info log")
//            Log.w("PGZN", "This is warning log")
//            Log.e("PGZN", "This is error log")

            val json = assets.open("sample.json")
                .bufferedReader()
                .use{it.readText()}

            Log.i("ASSET", json)

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use{it.readText()}

            Log.i("RAW", sample)

            Log.i("ValueResource", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResource", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResource", resources.getIntArray(R.array.numbers).toString())
            Log.i("ValueResource", resources.getColor(R.color.background, theme).toString())

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

//            resources.getStringArray(R.array.names).forEach{
//                Log.i("StringArray", it.toString())
//            }
        }

    }
}