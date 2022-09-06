package com.example.myapplication

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity3SubBinding

class SubActivity3 : AppCompatActivity() {

    private val binding by lazy { Activity3SubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true
        // 웹뷰에서 새창을 띄우지 않도록 방지
        binding.webView.webViewClient = myWebClient()
        binding.webView.webChromeClient = WebChromeClient()
        // 로드할 주소
        binding.webView.loadUrl("https://www.naver.com")
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()  // 웹뷰에서 뒤로갈 페이지가 존재한다면
        } else {
            super.onBackPressed() // 안드로이드 백 버튼 수행
        }
    }
}