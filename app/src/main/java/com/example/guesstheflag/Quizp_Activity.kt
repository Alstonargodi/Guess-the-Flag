package com.example.guesstheflag

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizp.*

class Quizp_Activity : AppCompatActivity(),View.OnClickListener {

    private var mcurrposintiont: Int = 1
    private var msoallist: ArrayList<soal>? = null
    private var mselectedoption : Int = 0
    private var mjawaban:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizp)

        msoallist = constant.getsoal() //jumlah soal

        setsoal()
        tv_optionone.setOnClickListener(this)
        tv_optiontwo.setOnClickListener(this)
        tv_optionthree.setOnClickListener(this)
        tv_optionfour.setOnClickListener(this)
        btn_next.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setsoal(){ //setter soal
//        mcurrposintiont = 1  //posisi pertama
        val question =  msoallist!!.get(mcurrposintiont-1)

        defaultoptionsview()

        if(mcurrposintiont == msoallist!!.size){
            btn_next.text="Finish"
        }else{
            btn_next.text="Enter Answer"
        }

        progressBar.progress = mcurrposintiont
        tv_progress.text = "$mcurrposintiont" + "/" + progressBar.max //progreess bar

        question.soal.also { tv_soal.text = it } //mengambil soal dan gambar
        iv_image.setImageResource((question.gambar))
        tv_optionone.text = question.pilihansatu //pilihan jawaban
        tv_optiontwo.text = question.pilihandua
        tv_optionthree.text = question.pilihantiga
        tv_optionfour.text = question.pilihanempat
    }

    private fun defaultoptionsview(){
        val options = ArrayList<TextView>()
        options.add(0,tv_optionone)
        options.add(1,tv_optiontwo)
        options.add(2,tv_optionthree)
        options.add(3,tv_optionfour)
        for(option in options){
            option.setTextColor(Color.parseColor("#A53333"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@Quizp_Activity,R.drawable.default_pilihan
            )
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) { //fungsi pada saat klik tombol
        when (v?.id) {
            R.id.tv_optionone -> {
                selectedoptions(tv_optionone, 1) //memanggil fungsi jawaban yg dipilih
            }
            R.id.tv_optiontwo -> {
                selectedoptions(tv_optiontwo, 2)
            }
            R.id.tv_optionthree -> {
                selectedoptions(tv_optionthree, 3)
            }
            R.id.tv_optionfour -> {
                selectedoptions(tv_optionfour, 4)
            }
            R.id.btn_next -> {
               if(mselectedoption == 0){
                   mcurrposintiont++
                   when{
                       mcurrposintiont <= msoallist!!.size->{
                           setsoal()
                       }else ->{
                           Toast.makeText(this,"End of game",Toast.LENGTH_SHORT).show()
                       }
                   }
               }else{
                   val question = msoallist?.get(mcurrposintiont-1)
                   if (question!!.jawaban != mselectedoption){
                       jawabview(mselectedoption,R.drawable.salah)//jika salah memberikan warna salah
                   }else{
                       mjawaban++
                   }
                   jawabview(question.jawaban,R.drawable.benar)//jika benar memberikan warna benar

                   if(mcurrposintiont == msoallist!!.size){
                       btn_next.text="Finish"
                   }else{
                       btn_next.text="next question"
                   }
                   mselectedoption=0
               }
            }

        }

    }
        private fun jawabview(jawab : Int,dview:Int){ //inisialisasi
            when(jawab){
                1->{
                    tv_optionone.background = ContextCompat.getDrawable(this@Quizp_Activity,dview)
                }
                2->{
                    tv_optiontwo.background = ContextCompat.getDrawable(this@Quizp_Activity,dview)
                }
                3->{
                    tv_optionthree.background = ContextCompat.getDrawable(this@Quizp_Activity,dview)
                }
                4->{
                    tv_optionfour.background = ContextCompat.getDrawable(this,dview)
                }
            }
        }

    private fun selectedoptions(tv: TextView, selectoption: Int){ //mereset jawaban ketika batal memilih jawaban sebelumnya
        defaultoptionsview()
        mselectedoption = selectoption

        tv.setTextColor(Color.parseColor("#A53333"))
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(
            this@Quizp_Activity,R.drawable.default_pilihan
        )
    }
}