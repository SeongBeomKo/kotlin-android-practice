package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.Activity4SubBinding

class SubActivity4 : AppCompatActivity() {

    private val binding by lazy { Activity4SubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val profileList = arrayListOf<Profile>(
            Profile(R.drawable.boy, "davidko", 31, "안드로이드 개발자"),
            Profile(R.drawable.woman, "ashley", 22, "backend"),
            Profile(R.drawable.woman, "sylvia", 28, "backend"),
            Profile(R.drawable.boy, "mark", 33, "frontend"),
            Profile(R.drawable.woman, "Juliet", 21, "IOS Developer"),
            Profile(R.drawable.boy, "Ryan", 32, "Infra engineer"),
            )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }
}