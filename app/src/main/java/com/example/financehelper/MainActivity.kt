package com.example.financehelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.financehelper.presenter.main_package.root_fragment.RootFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    var onPressedBack: (() -> Boolean)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.basic_fragment_root, RootFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (onPressedBack?.invoke() == false)  super.onBackPressed()

    }
}