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
import android.widget.TextView;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.activities.HomeActivity;
import ge.aleksandre.tskhovrebovi.finalproject.adapters.ActivesRecyclerAdapter;
import ge.aleksandre.tskhovrebovi.finalproject.adapters.TransactionsRecyclerAdapter;
import ge.aleksandre.tskhovrebovi.finalproject.api.Api;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo.Transactions;
import ge.aleksandre.tskhovrebovi.finalproject.retrofits.HomeRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TransactionsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TransactionsRecyclerAdapter adapter;


    public static TransactionsFragment getInstance() {
        TransactionsFragment fragment = new TransactionsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = HomeRetrofit.getInstance();
        Api api = retrofit.create(Api.class);

        final View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        HomeActivity.setCorrespondingBackground(view.findViewById(R.id.transactions_header_background));

        api.getUserTracsactions().enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {
                recyclerView = view.findViewById(R.id.transactions_recycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new TransactionsRecyclerAdapter();
                recyclerView.setAdapter(adapter);

                TextView incomeText = view.findViewById(R.id.transactions_total_income_value);
                TextView outcomeText = view.findViewById(R.id.transactions_total_outcome_value);

                incomeText.setText(response.body().getIncomeSum());
                outcomeText.setText(response.body().getOutcomeSum());

                adapter.setData(response.body().getOperations());
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {
                Log.d("cxcx", t.getMessage());
            }
        });

        return view;
    }
}
