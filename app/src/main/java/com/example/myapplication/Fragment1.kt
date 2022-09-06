package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Frag1Binding
import com.example.myapplication.databinding.FragmentFirstBinding


//ctrl + o -> overriding
class Fragment1 :Fragment() {

    //추후에 뷰가 사라질때 (메모리에서 삭제) 뷰바인딩 객체도 같이 날리기 위해 전체 fragment에서 변수 생성
    private var frag1Binding: Frag1Binding? = null

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 뷰 바인딩 가져오기. 뷰바인딩 클래스는 xml과 연동이 되어있기 때문에 layout를 명시해줄필요가없다.
        frag1Binding = Frag1Binding.inflate(inflater, container, false)
        return frag1Binding!!.root
    }
}