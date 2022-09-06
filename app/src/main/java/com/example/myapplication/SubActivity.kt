package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySubBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sub)

        setContentView(binding.root)

        if(intent.hasExtra("msg")) {
            binding.textView.text = intent.getStringExtra("msg")
        }

        binding.btnToast.setOnClickListener {
            binding.ivProfile.setImageResource(R.drawable.iv_profile) //이미지뷰에 새로운 이미지 등록
            Toast.makeText(this@SubActivity, "버튼클릭!",Toast.LENGTH_SHORT).show()
        }
    }
}