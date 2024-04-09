package com.mohanraj.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {



    String api = "3708d6c30818471c9b04000e264afa6c";
    ArrayList<Modelclass> modelclassArrayList;
    Adapter adapter;
    String country = "in";

    private RecyclerView recyclerViewofhealth;
    private String catogory = "health";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.healthfragment, null);


        recyclerViewofhealth = v.findViewById(R.id.recyclehealth);
        modelclassArrayList = new ArrayList<>();
        recyclerViewofhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelclassArrayList);
        recyclerViewofhealth.setAdapter(adapter);

        findNews();
        return v;

    }



    private void findNews() {

        ApiUtilities.getApiInterface().getCatogoryNews(country, catogory,100,api).enqueue(new Callback<mainnews>() {
            @Override
            public void onResponse(Call<mainnews> call, Response<mainnews> response) {
                if(response.isSuccessful()){
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainnews> call, Throwable t) {

            }
        });




    }
}

