package com.example.mdan17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.mdan17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fruits = arrayListOf<String>("Olma","Banan","Orik","uzum","Shaftoli")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fruits)
        binding.listview.adapter = adapter

        binding.listview.setOnItemClickListener { _, _, position, _ ->
            Intent(this, FruitImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}