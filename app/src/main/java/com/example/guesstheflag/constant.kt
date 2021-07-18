package com.example.guesstheflag

object constant {//getter soal

    fun getsoal(): ArrayList<soal>{
        val soallist = ArrayList<soal>()

        //soal 1
        val soal1 = soal(
            1,"which flag is this?",
            R.drawable.australia,
            "brazil","turkey","australia","afghanistan",
            3)
        soallist.add(soal1)
        //soal 2
        val soal2 = soal(
            2,"which flag is this?",
            R.drawable.turkey,
            "australia","turkey","pakistan","iraq",
            2)
        soallist.add(soal2)
        //soal 3
        val soal3 = soal(
            3,"which flag is this?",
            R.drawable.brazil,
            "brazil","argentina","iran","colombia",
            1)
        soallist.add(soal3)
        //soal 4
        val soal4 = soal(
            4,"which flag is this?",
            R.drawable.turkmenistan,
            "belarussia","mongolia","turkmenistan","iraq",
            3)
        soallist.add(soal4)

        return soallist
    }
}