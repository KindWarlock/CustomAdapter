package com.example.coollist

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

const val TAG = "MyTag"

class MainActivity : AppCompatActivity() {
    data class Person(val name: String, val surname: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content: String = assets.open("test.json")
            .bufferedReader().use { it.readText() }
        val jsonArr = JSONArray(content)
        val people: MutableList<Person> = ArrayList(jsonArr.length())
        for (i in 0 until jsonArr.length()) {
            val newPerson = jsonArr.getJSONObject(i)
            val name =  newPerson.getJSONObject("name")
            people.add(
                Person(
                    name.getString("firstname"),
                    name.getString("lastname")
                )
            )
        }

        val listView:ListView = findViewById(R.id.list);
        listView.adapter = CustomAdapter(this, people)
        Log.i(TAG, people.toString())
    }
}