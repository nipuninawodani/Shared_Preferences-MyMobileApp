package com.nnperera.android.vaccination_status

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //shared preferences (Name. Mode)
        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        //handle save button click: input data and save in shared preferences
        saveBtn.setOnClickListener {
            //input data
            val name = nameEt.text.toString()
            val age = Integer.parseInt(ageEt.text.toString())
            val vaccinated = switchh.isChecked //if checked then true else false

            //Edit shared preferences to put data
            val editor = sharedPreferences.edit()

            //put data in shared preferences
            editor.putString("NAME", name.toString())
            editor.putInt("AGE",age)
            editor.putBoolean("vaccinated",vaccinated)

            //apply changes to shared preferences
            editor.apply()
        }

        //handle show info button click : get info from shared preferences and show in textview
        showInfoBtn.setOnClickListener {
            //get data from shared preferences
            val name = sharedPreferences.getString("NAME","")
            val age = sharedPreferences.getInt("AGE",0)
            val vaccinated = sharedPreferences.getBoolean("vaccinated",false)

            //show data in text view
            infoTv.text = "Name: $name \nAge: $age \nFully vaccinated: $vaccinated"
        }

    }

}
