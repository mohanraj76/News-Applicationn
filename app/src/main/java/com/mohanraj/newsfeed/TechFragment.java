package com.mohanraj.newsfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechFragment extends Fragment {


    String api = "3708d6c30818471c9b04000e264afa6c";
    ArrayList<Modelclass> modelclassArrayList;
    Adapter adapter;
    String country = "in";

    private RecyclerView recyclerViewoftech;
    private String catogory = "technology";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.technologyfragment, null);
        recyclerViewoftech = v.findViewById(R.id.recyletechno);
        modelclassArrayList = new ArrayList<>();
        recyclerViewoftech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelclassArrayList);
        recyclerViewoftech.setAdapter(adapter);

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

