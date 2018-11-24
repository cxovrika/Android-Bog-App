package ge.aleksandre.tskhovrebovi.finalproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;
import ge.aleksandre.tskhovrebovi.finalproject.holders.ActiveViewHolder;

public class ActivesRecyclerAdapter extends RecyclerView.Adapter<ActiveViewHolder> {

    private int TYPE_BLOCK_HEADER = 0;
    private int TYPE_ITEM = 1;
    private String[] headers = new String[]{"ქულები", "აქტივები", "ვალდებულებები", "ხელმისაწვდომი თანხა"};

    private List< List<ActiveEntry> > data = new ArrayList<>();

    @NonNull
    @Override
    public ActiveViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if (i == TYPE_ITEM) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_active_item, viewGroup, false);
        } else if (i == TYPE_BLOCK_HEADER){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_active_block_header, viewGroup, false);
        }
        return new ActiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveViewHolder activeViewHolder, int i) {
        ActiveEntry entry = getItem(i);
        if (entry != null) {
            activeViewHolder.setItemData(entry);
        } else {
            int headerIndex = getHeaderIndex(i);
            String headerText = headers[headerIndex];
            activeViewHolder.setBlockHeaderData(headerText);
        }
    }

    @Override
    public int getItemCount() {
        return getSize();
    }

    public void setData(List< List<ActiveEntry> > newData) {
        data.clear();
        for (int i = 0; i < newData.size(); i++) {
            data.add(new ArrayList<ActiveEntry>());
            data.get(i).addAll(newData.get(i));
        }
    }

    private int getSize() {
        int res = data.size();
        for (List<ActiveEntry> blockList : data) {
            res += blockList.size();
        }
        return res;
    }

    private ActiveEntry getItem(int index) {
        for (int i = 0; i < data.size(); i++) {
            if (index > data.get(i).size()) {
                index -= data.get(i).size() + 1;
            } else {
                if (index == 0) return null;
                return data.get(i).get(index - 1);
            }
        }
        return null;
    }

    private int getHeaderIndex(int rawIndex) {
        int res = 0;
        for (int i = 0; i < data.size(); i++) {
            if (rawIndex > data.get(i).size()) {
                res++;
                rawIndex -= data.get(i).size() + 1;
            } else {
                return res;
            }
        }
        return  res;
    }


    @Override
    public int getItemViewType(int position) {
        if (getItem(position) == null) {
            return TYPE_BLOCK_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }
}
