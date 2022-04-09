package com.nnperera.android.vaccination_status

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

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
            val name = nameEt.text.toString().trim()
            val age = Integer.parseInt(ageEt.text.toString().trim())
            val vaccinated = switchh.isChecked //if checked then true else false

            //Edit shared preferences to put data
            val editor = sharedPreferences.edit()

            //put data in shared preferences
            editor.putString("NAME", name.toString())
            editor.putInt("AGE",age)
            editor.putBoolean("VACCINATED",vaccinated)

            //apply changes to shared preferences
            editor.apply()
        }

        //handle show info button click : get info from shared preferences and show in textview
        showInfoBtn.setOnClickListener {
            //get data from shared preferences
            val name = sharedPreferences.getString("Name","")
            val age = sharedPreferences.getInt("AGE",0)
            val vaccinated = sharedPreferences.getBoolean("vaccinated",false)

            //show data in text view
            infoTv.text = "NAME: $name \nAGE: $age \nvaccinated ?: $vaccinated"
        }

    }

}
