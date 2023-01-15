package com.romanticshayarihindi.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.romanticshayarihindi.Model.QuteModel
import com.romanticshayarihindi.OnItemClickListener
import com.romanticshayarihindi.R

class AdapterQuotes(
    private val data: ArrayList<QuteModel>,
    private var listener: OnItemClickListener?
) :
    Adapter<AdapterQuotes.Holder>() {

    private val colors = listOf(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.qutote.text = data.get(position).qute
        holder.buttonCopy.setOnClickListener() {
            listener?.onCopyClick(position)
        }
        holder.buttonShare.setOnClickListener() {
            listener?.onshareClick(position)
        }
        holder.itemView.setBackgroundColor(colors[position % colors.size])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val qutote: TextView = itemView.findViewById(R.id.qute_text)
        val buttonCopy: LinearLayout = itemView.findViewById(R.id.copy_qute)
        val buttonShare: LinearLayout = itemView.findViewById(R.id.share_qute)
    }
}
