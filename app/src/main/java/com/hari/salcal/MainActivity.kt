package com.hari.salcal

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ok_iv.setOnClickListener {
            hideKeyboard()
            val salList = mutableListOf<Increment>()
            val sal = sal_et?.text?.toString()?.toDouble() ?: 0.0
            for (i in 5..100 step 5) {
                val yearIncrement: Int = ((i / 100.0) * sal).toInt()
                val monthIncrement: Int = yearIncrement / 12
                val newSal: Int = (yearIncrement + sal).toInt()
                salList.add(Increment(i.toString() + "%", monthIncrement.toString(), yearIncrement.toString(), newSal.toString()))
            }
            increment_rv.layoutManager = GridLayoutManager(this, 3)
            increment_rv.adapter = IncrementAdapter(this, salList)
        }
    }
}
