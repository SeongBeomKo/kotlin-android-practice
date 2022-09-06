package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Frag1Binding
import com.example.myapplication.databinding.Frag2Binding
import com.example.myapplication.databinding.FragmentSecondBinding


//ctrl + o -> overriding
class Fragment2 :Fragment() {

    private var frag2Binding: Frag2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frag2Binding = Frag2Binding.inflate(inflater, container, false)
        return frag2Binding!!.root
    }
}