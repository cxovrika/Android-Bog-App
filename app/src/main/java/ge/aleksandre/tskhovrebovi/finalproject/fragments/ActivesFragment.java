package ge.aleksandre.tskhovrebovi.finalproject.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.activities.HomeActivity;
import ge.aleksandre.tskhovrebovi.finalproject.adapters.ActivesRecyclerAdapter;
import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;
import ge.aleksandre.tskhovrebovi.finalproject.api.Api;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.activesinfo.Actives;
import ge.aleksandre.tskhovrebovi.finalproject.retrofits.HomeRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ActivesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ActivesRecyclerAdapter activesRecyclerAdapter;

    public static ActivesFragment getInstance() {
        ActivesFragment fragment = new ActivesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Retrofit retrofit = HomeRetrofit.getInstance();
        Api api = retrofit.create(Api.class);

        final View view = inflater.inflate(R.layout.fragment_actives, container, false);
        HomeActivity.setCorrespondingBackground(view);

        api.getUserActives().enqueue(new Callback<Actives>() {
            @Override
            public void onResponse(Call<Actives> call, Response<Actives> response) {
                recyclerView = view.findViewById(R.id.actives_recycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                activesRecyclerAdapter = new ActivesRecyclerAdapter();
                recyclerView.setAdapter(activesRecyclerAdapter);

                List<List<ActiveEntry>> allBlocks = response.body().getAllBlocks();
                activesRecyclerAdapter.setData(allBlocks);
            }

            @Override
            public void onFailure(Call<Actives> call, Throwable t) {
                Log.d("cxcx", t.getMessage());
            }
        });

        return view;
    }


}
