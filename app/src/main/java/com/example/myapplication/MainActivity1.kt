package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMain1Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMain1Binding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageList = intArrayOf(
            R.drawable.starling,
            R.drawable.tit,
            R.drawable.wrens,
            R.drawable.eurasian_chaffinch,
            R.drawable.bird1,
            R.drawable.flinches,
            R.drawable.green_tit
        )
        val ingredientList = intArrayOf(
            R.string.starling,
            R.string.Tit,
            R.string.Wrens,
            R.string.eurasian_chaffinch,
            R.string.bird1,
            R.string.Flinches,
            R.string.green_tit
        )
        val descList = intArrayOf(
            R.string.starling_des,
            R.string.Tit_des,
            R.string.Wrens_des,
            R.string.eurasian_chaffinch_des,
            R.string.bird1_des,
            R.string.flinches_DES,
            R.string.green_tit_des
        )
        val nameList = arrayOf("Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries")
        val timeList = arrayOf("30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins")
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity1, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener =

            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(this@MainActivity1, DetailedActivity::class.java)
                intent.putExtra("name", nameList[i])
                intent.putExtra("time", timeList[i])
                intent.putExtra("ingredients", ingredientList[i])
                intent.putExtra("desc", descList[i])
                intent.putExtra("image", imageList[i])
                startActivity(intent)
            }
    }
}