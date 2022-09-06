package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context: Context, val userList: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): Any {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)
        val profile = view.findViewById<ImageView>(R.id.profile)
        val name = view.findViewById<TextView>(R.id.name)
        val greet = view.findViewById<TextView>(R.id.greet)
        val age = view.findViewById<TextView>(R.id.age)

        val user = userList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        greet.text = user.greet
        age.text = user.age

        return view
    }


}