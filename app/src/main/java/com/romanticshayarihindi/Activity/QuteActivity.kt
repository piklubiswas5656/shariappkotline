package com.romanticshayarihindi.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.romanticshayarihindi.Adapter.AdapterQuotes
import com.romanticshayarihindi.Model.QuteModel
import com.romanticshayarihindi.OnItemClickListener
import com.romanticshayarihindi.R

class QuteActivity : AppCompatActivity(),OnItemClickListener{
    //wid
    lateinit var data: ArrayList<QuteModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qute)
        init()
    }

    fun init() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterQuotes(getdata(),this)
        recyclerView.adapter = adapter

    }

    fun getdata(): ArrayList<QuteModel> {
        data = ArrayList<QuteModel>()
        data.add(QuteModel("this is qutoe"))
        data.add(QuteModel("this is o"))
        data.add(QuteModel("this is qutoe"))
        data.add(QuteModel("this is o"))
        data.add(QuteModel("this is qutoe"))
        data.add(QuteModel("this is o"))
        return data
    }

    override fun onCopyClick(position: Int) {
        Toast.makeText(this, "copy", Toast.LENGTH_SHORT).show()
    }

    override fun onshareClick(position: Int) {
        Toast.makeText(this, "share", Toast.LENGTH_SHORT).show()
    }
}