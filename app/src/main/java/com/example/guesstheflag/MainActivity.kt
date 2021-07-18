package com.example.guesstheflag

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_start.setOnClickListener {
            if(et_nama.text.toString().isEmpty()){
                Toast.makeText(this,"Need Name First",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,Quizp_Activity::class.java)//next page
                startActivity(intent)
                finish()
            }
        }
    }
}