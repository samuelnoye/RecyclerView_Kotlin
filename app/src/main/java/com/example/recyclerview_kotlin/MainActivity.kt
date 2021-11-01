package com.example.recyclerview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_kotlin.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityMainBinding
 private lateinit var blogAdapter: BlogRecyclerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private  fun initRecyclerView(){

        binding.recyclerView.apply {
              layoutManager =  LinearLayoutManager( this@MainActivity)
              val topSpacingDecorator = TopSpacingItemDecoration(30)
              addItemDecoration(topSpacingDecorator)
              blogAdapter = BlogRecyclerAdapter()
              adapter = blogAdapter
        }


    }
}