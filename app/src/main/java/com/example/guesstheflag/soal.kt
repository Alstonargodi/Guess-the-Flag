package com.example.guesstheflag

data class soal (val id : Int,val soal:String,val gambar: Int, //data soal
                 val pilihansatu:String,//pilihan jawaban soal
                 val pilihandua:String,
                 val pilihantiga:String,
                 val pilihanempat:String,
                 val jawaban:Int,//jawaban soal
)