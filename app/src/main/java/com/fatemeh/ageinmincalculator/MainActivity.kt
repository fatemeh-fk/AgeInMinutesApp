package com.fatemeh.ageinmincalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDataPicker.setOnClickListener {view->
           clickDatePicker(view)
            Toast.makeText(this, "button works", Toast.LENGTH_LONG).show()
        }


    }

    fun clickDatePicker(view:View){
        val myCalender=Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd= DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
               view, selectedyear, selectedmonth, selecteddayOfMonth ->
           Toast.makeText(this, "year is $selectedyear, and month is $selectedmonth and day is $selecteddayOfMonth", Toast.LENGTH_LONG).show()
           val selecteddate="$selecteddayOfMonth/$selectedmonth/$selectedyear"
           selectedDate.setText(selecteddate)

           val sdf= SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
           val theDate=sdf.parse(selecteddate)
           val SelectedDateinMINuntes=theDate!!.time/60000

            val selectedatedinDay=theDate!!.time/86400000
           val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))

           val currentDateInMinute=currentDate!!.time/60000

            val currentDateinDay=currentDate!!.time/86400000
           val differenceInMinute=currentDateInMinute-SelectedDateinMINuntes

            val differenceInDay=currentDateinDay-selectedatedinDay
           SelectedDateinMIN.setText(differenceInMinute.toString())
            SelectedDateinDay.setText(differenceInDay.toString())
              }
       ,year,month,day)

      dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show(

        )
    }
}