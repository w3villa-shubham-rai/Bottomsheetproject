package com.example.bottonsheetkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bottonsheetkotlin.databinding.FragmentKotlinfragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.logging.Logger

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [kotlinfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class kotlinfragment : BottomSheetDialogFragment() {
    var url = "https://jsonplaceholder.typicode.com/photos"

    private lateinit var recyclerView: RecyclerView;
    val dataList = ArrayList<datamodel>()
    lateinit var binding:FragmentKotlinfragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
       
    ): View {
        binding=FragmentKotlinfragmentBinding.inflate(inflater,container,false)

      binding.recycleview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        getData()


        return  binding.root;

    }


    fun getData() {
        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                Log.v("data",response.toString())
                try {
                    val jsonarray = JSONArray(response)
                    for (i in 0 until jsonarray.length()) {
                        val singleObj = jsonarray.getJSONObject(i)
                        singleObj.getString("title")
                      //  singleObj.getString("description")
                        dataList.add(datamodel(singleObj.getString("id").toString(),  (singleObj.getString("title")),(singleObj.getString("thumbnailUrl"))))
                    }

                   binding.recycleview.adapter=Myadapter(dataList)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
                Log.e("api", "onErrorResponse: " + error.localizedMessage)
            })


        val queue = Volley.newRequestQueue(requireContext())
        queue.add(stringRequest)
    }





}