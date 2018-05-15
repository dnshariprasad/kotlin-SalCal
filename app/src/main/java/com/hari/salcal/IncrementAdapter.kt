package com.hari.salcal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_incrent.view.*

class IncrementAdapter(val context: Context, val items: List<Increment>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_incrent, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.incrementTv?.text = items.get(position).percentage
        holder.yearIncrementTv?.text = "Y ${items.get(position).yearIncrement}"
        holder.monthIncrementTv?.text = "M ${items.get(position).monthIncrement}"
        holder.effectiveSalTv?.text = "E ${items.get(position).effectiveSal}"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val incrementTv = view.percentage_tv
    val yearIncrementTv = view.year_incremented_tv
    val monthIncrementTv = view.month_incremented_tv
    val effectiveSalTv = view.effective_sal_tv
}
