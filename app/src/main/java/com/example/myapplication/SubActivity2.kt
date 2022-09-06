package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity2SubBinding

class SubActivity2 : AppCompatActivity() {

    private val binding by lazy { Activity2SubBinding.inflate(layoutInflater)}

    val userList = arrayListOf<User>(
        User("소주", R.drawable.soju, "28", "안녕하세요"),
        User("술", R.drawable.soju, "22", "안녕하세요"),
        User("알콜", R.drawable.soju, "21", "안녕하세요"),
        User("음료", R.drawable.soju, "16", "안녕하세요"),
        User("캬아", R.drawable.soju, "19", "안녕하세요")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d(TAG, "SubActivity2 - onCreate() is called")

//        val array = arrayOf("사과", "배", "딸기", "오렌지", "키위")
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)

        val adapter = UserAdapter(this, userList)
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()

        }
    }
}