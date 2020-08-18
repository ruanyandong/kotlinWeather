package com.wings.kotlinweather.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.wings.kotlinweather.R
import kotlinx.android.synthetic.main.fragment_place.*

/**
 * @author -> Wings
 * @date   -> 2020/8/18
 * @email  -> ruanyandongai@gmail.com
729368173@qq.com
 * @phone  -> 18983790146
 * @blog   -> https://ruanyandong.github.io
-> https://blog.csdn.net/qq_34681580
 */
class PlaceFragment : Fragment(){

    private val mViewModel by lazy { ViewModelProviders.of(this).get(PlaceViewModel::class.java) }

    private lateinit var mAdapter: PlaceAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        mAdapter = PlaceAdapter(this,mViewModel.placeList)
        recyclerView.adapter = mAdapter
        searchPlaceEdit.addTextChangedListener{ editable ->
            val content = editable.toString()
            if (content.isNotEmpty()){
                mViewModel.searchPlaces(content)
            }else{
                recyclerView.visibility = View.GONE
                bgImageView.visibility = View.VISIBLE
                mViewModel.placeList.clear()
                mAdapter.notifyDataSetChanged()
            }
        }

        mViewModel.placeLiveData.observe(this, Observer {result ->
            val places = result.getOrNull()
            if (places != null){
                recyclerView.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE
                mViewModel.placeList.clear()
                mViewModel.placeList.addAll(places)
                mAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(activity,"未能查询到任何地点",Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })

    }


}