package com.hari.salcal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ok_iv.setOnClickListener {
            val salList = mutableListOf<Increment>()
            val sal = sal_et?.text?.toString()?.toDouble() ?: 0.0
            for (i in 5..100 step 5) {
                val incrementByAmount = (i / 100.0) * sal
                val newSal = incrementByAmount + sal
                salList.add(Increment(i.toString() + "%", incrementByAmount.toString(), newSal.toString()))
            }
            increment_rv.layoutManager = LinearLayoutManager(this)
            increment_rv.adapter = IncrementAdapter(this, salList)
        }

    }
}
