package ge.aleksandre.tskhovrebovi.finalproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.holders.TransactionViewHolder;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo.Operation;

public class TransactionsRecyclerAdapter extends RecyclerView.Adapter<TransactionViewHolder> {

    private List<Operation> data = new ArrayList<>();

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_transaction, viewGroup, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        transactionViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Operation> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }
}
