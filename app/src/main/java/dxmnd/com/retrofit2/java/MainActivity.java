package dxmnd.com.retrofit2.java;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import dxmnd.com.retrofit2.R;
import dxmnd.com.retrofit2.kotlin.model.Model;
import dxmnd.com.retrofit2.java.service.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HunJin on 2018-02-24.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit();
    }

    private void retrofit() {

        // post로 전달 할 데이터
        Map<String, String> map = new HashMap<>();
        map.put("name", "이름");
        map.put("password", "비밀번호");

        // 최상위 경로
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://124.80.127.237:13000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Model> call = service.getPost(map);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                Model model = response.body();
                Log.e(TAG, "count : " + model.getCount());
                int size = model.getResults().size();

                for (int i = 0; i < size; i++) {
                    Log.e(TAG, "id : " + model.getResults().get(i).getId());
                    Log.e(TAG, "name : " + model.getResults().get(i).getName());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Model> call, Throwable t) {

            }
        });
    }
}
