package com.edgedevstudio.recyclerviewtutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val recyclerViewItemDivider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(recyclerViewItemDivider)
        val recyclerViewAdapter = RecyclerViewAdapter(generateDummyData())
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun generateDummyData(): List<DummyData> {
        val dummyDataList = ArrayList<DummyData>()
        for (x in 1..50) {
            dummyDataList.add(DummyData("Title $x", "This is Sub-TITLE $x with a summary"))
        }
        return dummyDataList
    }

    class RecyclerViewAdapter(var dummyDataList: List<DummyData>) : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount() = dummyDataList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.titleTextView.setText(dummyDataList[position].title)
            holder.subTitleTextView.setText(dummyDataList[position].subtitle)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val subTitleTextView: TextView

        init {
            titleTextView = view.findViewById(R.id.title)
            subTitleTextView = view.findViewById(R.id.sub_title)
        }
    }
}
