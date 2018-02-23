package dxmnd.com.retrofit2.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dxmnd.com.retrofit2.R
import dxmnd.com.retrofit2.java.service.RetrofitService
import dxmnd.com.retrofit2.kotlin.model.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun retrofit() {

        // post로 전달 할 데이터
        val map = HashMap<String, String>()
        map.put("name", "이름")
        map.put("password", "비밀번호")

        // 최상위 경로
        val retrofit = Retrofit.Builder()
                .baseUrl("http://124.80.127.237:13000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(RetrofitService::class.java)
        val call = service.getPost(map)
        call.enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val model = response.body()
                Log.e(TAG, "count : " + model!!.count)
                val size = model!!.results!!.size

                for (i in 0 until size) {
                    Log.e(TAG, "id : " + model.results!![i].id)
                    Log.e(TAG, "name : " + model.results!![i].name!!)
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {

            }
        })
    }
}
