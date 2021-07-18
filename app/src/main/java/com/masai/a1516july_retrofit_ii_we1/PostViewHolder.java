package com.masai.a1516july_retrofit_ii_we1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvEmail;
    private TextView mTvBody;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }


    private void initViews() {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvEmail = itemView.findViewById(R.id.tvEmail);
        mTvBody = itemView.findViewById(R.id.tvBody);
    }

    void setData(ResponseModel responseModel) {
        mTvEmail.setText(responseModel.getEmail());
        mTvName.setText(responseModel.getName());
        mTvBody.setText(responseModel.getBody());
    }

}
