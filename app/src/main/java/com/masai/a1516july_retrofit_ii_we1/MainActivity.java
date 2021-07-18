package com.masai.a1516july_retrofit_ii_we1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtPostId;
    private Button mBtnFetch;
    private RecyclerView mRecyclerView;
    private List<ResponseModel> postModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        //int postId = mEtPostId.getText().toString();  //when u type this then parsetoInteger if not done then
        //it NumberFormatException shows..ex."100" => converted to int 100
        int postId = Integer.parseInt(mEtPostId.getText().toString());
        apiService.getPosts(postId).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.body() != null) {
                    postModelList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        PostAdapter postAdapter = new PostAdapter(postModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(postAdapter);
//        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
//        mRecyclerView.setItemAnimator(itemAnimator);
    }

    private void initViews() {
        mEtPostId = findViewById(R.id.etPostId);
        mBtnFetch = findViewById(R.id.btnFetch);
        mRecyclerView = findViewById(R.id.recyclerView);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }
}