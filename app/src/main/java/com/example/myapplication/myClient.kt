package com.example.myapplication

import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient


class myWebClient : WebViewClient() {
    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, er: SslError) {
// Ignore SSL certificate errors
        handler.proceed()
    }
}