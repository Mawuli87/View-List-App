package com.yawomessie.view_list_app

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.yawomessie.view_list_app.adapters.DeveloperAdapter
import com.yawomessie.view_list_app.databinding.ActivityMainBinding
import com.yawomessie.view_list_app.models.DeveLoper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: DeveloperAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var heroes = arrayListOf<DeveLoper>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        adapter = DeveloperAdapter(this)
        binding.lvList.adapter = adapter

        prepare()
        addItem()

        binding.lvList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val developer = DeveLoper(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(developer)
        }
        adapter.developers = heroes
    }
}