package dxmnd.com.retrofit2.kotlin.service

import dxmnd.com.retrofit2.kotlin.model.Model
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by HunJin on 2018-02-24.
 */

interface RetrofitService {
    /**
     * url 경로 (FormUrlEncoded 중요)
     * @param key
     * @return
     */
    @FormUrlEncoded
    @POST("rest/post/")
    fun getPost(
            @FieldMap key: Map<String, String>
    ): Call<Model>

}
