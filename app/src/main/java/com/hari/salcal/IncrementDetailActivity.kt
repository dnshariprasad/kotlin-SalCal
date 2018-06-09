package com.hari.salcal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_increment_detail.*


class IncrementDetailActivity : AppCompatActivity() {
    companion object {
        private val INTENT_INFO = "intent_info"
        fun newIntent(context: Context, increment: Increment): Intent {
            val intent = Intent(context, IncrementDetailActivity::class.java)
            intent.putExtra(INTENT_INFO, increment)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increment_detail)
        val inc = intent?.getSerializableExtra(INTENT_INFO) as Increment;
        income_tv.text = (inc.salPerYear)
    }
}
