package com.hari.salcal

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_increnent.*

class IncrementActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increnent)

        ok_iv.setOnClickListener {
            hideKeyboard()
            val salList = mutableListOf<Increment>()
            if (sal_et?.text?.length == 0) {
                return@setOnClickListener
            }
            val sal = sal_et?.text?.toString()?.toDouble() ?: 0.0
            for (i in 0..100 step 5) {
                val yearIncrement: Int = ((i / 100.0) * sal).toInt()
                val monthIncrement: Int = yearIncrement / 12
                val yearSal: Int = (yearIncrement + sal).toInt()
                val monthSal: Int = yearSal / 12
                salList.add(Increment(i.toString() + "%", monthIncrement.toString(), monthSal.toString(), yearIncrement.toString(), yearSal.toString()))
            }
            increment_rv.layoutManager = GridLayoutManager(this, 2)
            increment_rv.adapter = IncrementAdapter(this, salList)
        }
    }
}
