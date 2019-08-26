package com.example.lab4_sec1_603020370_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subjectSpinner = spiner_subject;
        val subjectArray = resources.getStringArray(R.array.subjectName_array)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner.adapter = arrayAdapter

        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                subject = subjectArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }
    fun showTimePickerDialog(v: View){
        val newTimeFragment = TimePickerFragment()
        newTimeFragment.show(supportFragmentManager,"Time Picker")
    }
    fun  showDetail(view : View){
        text_show.text = "ID: ${edit_id.text}\nName: ${edit_name.text}\nSubject: $subject\nTime: ${text_time.text}"

    }

    fun reset(v: View){
        edit_id.text.clear()
        edit_name.text.clear()
        spiner_subject.setSelection(0)
        text_time.text="_ _:_ _"
        text_show.text ="Show detail"
    }
}