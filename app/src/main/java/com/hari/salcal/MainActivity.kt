package com.hari.salcal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ok_iv.setOnClickListener {
            var salList = mutableListOf<Increment>()
            var sal = sal_et?.text?.toString()?.toDouble() ?: 0.0
            for (i in 5..100 step 5) {
                var incrementByAmount = (i / 100.0) * sal
                var newSal = incrementByAmount + sal
                salList.add(Increment(i.toString() + "%", incrementByAmount.toString(), newSal.toString()))
            }
            salList.forEach {
                Log.d(TAG, it.percentage.toString()
                        + " " + it.incrementedByAmount
                        + " " + it.effectiveSal)
            }
        }

    }
}
