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
        // 이 부분에서 rx를 추가할 수도 있어요.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://124.80.127.237:13000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 서비스를 불러옵니다.
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Model> call = service.getPost(map);

        // 귀찮아서 일단은 로그로 찍었습니다.
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                Model model = response.body();

                Log.i(TAG, "count : " + model.getCount()); // 안전한 null 처리를 해주세요. 지금은 안했습니다.
                int size = model.getResults().size(); // 마찬가지로 안전한 null 처리가 필요해요.

                for (int i = 0; i < size; i++) {
                    Log.i(TAG, "id : " + model.getResults().get(i).getId());
                    Log.i(TAG, "name : " + model.getResults().get(i).getName());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Model> call, Throwable t) {

            }
        });
    }
}
