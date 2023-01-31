package com.example.coollist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(val context: Context, val people: MutableList<MainActivity.Person>) : BaseAdapter() {
    override fun getCount(): Int {
        return people.size
    }

    override fun getItem(position: Int): Any {
        return people[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, containerView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.useritem, parent, false)
        val name: TextView = view.findViewById(R.id.name)
        val surname: TextView = view.findViewById(R.id.surname)
        val num: TextView = view.findViewById(R.id.num)
        name.text = people[position].name
        surname.text = people[position].surname
        num.text = (position + 1).toString()
        return view
    }
}