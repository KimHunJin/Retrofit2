package dxmnd.com.retrofit2.java.service;

import java.util.Map;

import dxmnd.com.retrofit2.kotlin.model.Model;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by HunJin on 2018-02-24.
 */

public interface RetrofitService {
    /**
     * url 경로 (FormUrlEncoded 중요)
     * @param key
     * @return
     */
    @FormUrlEncoded
    @POST("rest/post/")
    Call<Model> getPost(
            @FieldMap Map<String, String> key
    );

}
