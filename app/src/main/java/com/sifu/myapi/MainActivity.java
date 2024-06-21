package com.sifu.myapi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchProducts();
    }

    private void fetchProducts() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.escuelajs.co/api/v1/products").build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    Gson gson = new Gson();
                    Type productListType = new TypeToken<List<Product>>() {}.getType();
                    List<Product> products = gson.fromJson(responseBody, productListType);

                    runOnUiThread(() -> {
                        productAdapter = new ProductAdapter(MainActivity.this, products);
                        recyclerView.setAdapter(productAdapter);
                    });
                }
            }
        });
    }
}
