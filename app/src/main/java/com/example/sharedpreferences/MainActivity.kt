package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferences.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val sharedPreferences=getSharedPreferences("myPrefence", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit();

        binding.button.setOnClickListener {
            val name=binding.editText.text.toString()
            val age=binding.editText2.text.toString().toInt()
            editor.apply(){
                putString("name",name)
                putInt("age",age)
                apply()
            }
        }
        binding.button2.setOnClickListener {
            val name=sharedPreferences.getString("name",null)
            val age=sharedPreferences.getInt("age",0)
            binding.editText.setText(name)
            binding.editText2.setText(age.toString())
        }
    }
}