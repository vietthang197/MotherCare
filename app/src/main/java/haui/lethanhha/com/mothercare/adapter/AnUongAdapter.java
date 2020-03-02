package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.model.AnUong;

public class AnUongAdapter extends RecyclerView.Adapter<AnUongAdapter.ViewHolder> {

    private List<AnUong> anUongList;

    private Context context;

    private RecyclerViewOnClickListener listener;

    public AnUongAdapter(List<AnUong> anUongList, Context context, RecyclerViewOnClickListener listener) {
        this.anUongList = anUongList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
