package com.apiTask.AppsSquare.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.Adapter.DataAdapter
import com.apiTask.AppsSquare.Api.RetrofitFactory
import com.apiTask.AppsSquare.R
import com.apiTask.AppsSquare.models.DataModel
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var myRecycler : RecyclerView
    lateinit var layoutManager: GridLayoutManager
    lateinit var dataAdapter : DataAdapter
    lateinit var constraintLayout : ConstraintLayout
    lateinit var progressBar: ProgressBar
    lateinit var data : DataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val retrofit = RetrofitFactory().apiInterface()
        val call = retrofit.getData()

        call.enqueue(object : retrofit2.Callback<DataModel>{
            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                data = response!!.body()
                installRecycler()
                progressBar.visibility = View.GONE
                constraintLayout.visibility = View.VISIBLE
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                Toast.makeText(this@MainActivity , "no internet connection" , Toast.LENGTH_SHORT).show()
            }

        })

    }



    private fun initView(){
        myRecycler=findViewById(R.id.my_recycler)
        progressBar = findViewById(R.id.progress)
        constraintLayout = findViewById(R.id.layout)
    }

    fun installRecycler(){
        layoutManager = GridLayoutManager(this,2)
        myRecycler.layoutManager = layoutManager
        dataAdapter = DataAdapter(data,this)
        myRecycler.adapter = dataAdapter

    }
}