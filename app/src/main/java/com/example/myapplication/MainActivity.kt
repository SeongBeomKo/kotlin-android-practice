package com.example.myapplication
//
//import android.os.Bundle
//import android.util.Log
//import com.google.android.material.snackbar.Snackbar
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.TextView
//import com.example.myapplication.databinding.ActivityMainBinding
//

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


// ctrl + o = overriding method navigator
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액*티비티에 표시 합니다.
        setContentView(binding.root)
        setFrag(0)


        binding.btn1.setOnClickListener {
            setFrag(0)
        }
        binding.btn2.setOnClickListener {
            setFrag(1)
        }
        binding.btn3.setOnClickListener {
            setFrag(2)
        }

        binding.buttonA.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("msg", "눌럿네")
            startActivity(intent)
            //finish() // 액티비티를 파괴하여 뒤로 가기 눌러도 다시 못돌아옴
        }

        binding.buttonB.setOnClickListener {
            val intent2 = Intent(this, SubActivity2::class.java)
            startActivity(intent2)
        }

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START) // start: left, End: right
        }

        binding.naviView.setNavigationItemSelectedListener(this) // 네비게이션 아이템에 클릭 속성 부여

        loadData()  //  저장된 데이터를 불러옴

        binding.buttonWebView.setOnClickListener {
            val intent3 = Intent(this, SubActivity3::class.java)
            startActivity(intent3)
        }

        binding.buttonRecycleView.setOnClickListener {
            val intent4 = Intent(this, SubActivity4::class.java)
            startActivity(intent4)
        }

    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        binding.etHello.setText(pref.getString("name", "")) // 1번째 인자에는 가져올 데이터의 키값을, 2번쨰 인자에는 키 값에 데이터가 존재하지 않을 경우 데체 값
    }

    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        Log.d(TAG, "MainActivity - setFrag() is called")
        
        when(fragNum) {
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 아이템 클릭시 수행

        when(item.itemId) {

            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.send -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.layoutDrawer.closeDrawers()
        } else {
            super.onBackPressed() // 일반 백버튼 (finish)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData()  //edit text 값을 저장
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()
        edit.putString("name", binding.etHello.text.toString())
        edit.apply()
    }
}



//class MainActivity : AppCompatActivity() {
//
//    val TAG: String = "로그"
//
//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
//
//
//        Log.d(TAG, "MainActivity - onCreate() is called")
//
//    }
//
////    override fun onStart() {
////        super.onStart()
////        Log.d(TAG, "MainActivity - onStart() is called")
////
////    }
////
////    override fun onResume() {
////        super.onResume()
////        Log.d(TAG, "MainActivity - onResume() is called")
////
////    }
////
////    override fun onPause() {
////        super.onPause()
////        Log.d(TAG, "MainActivity - onPause() is called")
////
////
////    }
////
////    override fun onStop() {
////        super.onStop()
////        Log.d(TAG, "MainActivity - onStop() is called")
////
////    }
////
////    override fun onDestroy() {
////        super.onDestroy()
////        Log.d(TAG, "MainActivity - onDestroy() is called")
////
////    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        Log.d(TAG, "MainActivity - onCreateOptionsMenu() is called")
//
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        Log.d(TAG, "MainActivity - onOptionsItemSelected() is called")
//
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        Log.d(TAG, "MainActivity - onSupportNavigateUp() is called")
//
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
//}