package com.example.labass5intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickShowDetail(v: View) {
        val selectID :Int = radio_group.checkedRadioButtonId
        var gender = ""
        try {
            var radioButtonChecked : RadioButton = findViewById(selectID)
            gender = radioButtonChecked.text as String
        }catch (t: Throwable){
            gender = ""
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(
            "EmpData",
            Employee(editName.text.toString(), gender.toString(), editEmail.text.toString(),
                editSalary.text.toString().toInt()))
        startActivity(intent)
    }

    fun onClickReset(view: View) {
        editName.text.clear()
        editEmail.text.clear()
        editSalary.text.clear()
        radio_group.clearCheck()
    }


}





