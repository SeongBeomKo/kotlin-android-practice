package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Frag2Binding
import com.example.myapplication.databinding.Frag3Binding
import com.example.myapplication.databinding.FragmentSecondBinding


//ctrl + o -> overriding
class Fragment3 :Fragment() {

    private var frag3Binding: Frag3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frag3Binding = Frag3Binding.inflate(inflater, container, false)
        return frag3Binding!!.root
    }
}