package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.R;

import haui.lethanhha.com.mothercare.model.DatTen;

public class DatTenAdapter extends RecyclerView.Adapter<DatTenAdapter.ViewHolder> {

    private List<DatTen> datTenList;

    private Context context;


    public DatTenAdapter(List<DatTen> datTenList, Context context) {
        this.datTenList = datTenList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dat_ten_item_recycler_view, parent, false);
        DatTenAdapter.ViewHolder viewHolder = new DatTenAdapter.ViewHolder(view);
        viewHolder.tvTieuDe = view.findViewById(R.id.tvTieuDe);
        viewHolder.tvNoiDung = view.findViewById(R.id.tvNoiDung);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(datTenList.get(position));
    }

    @Override
    public int getItemCount() {
        return datTenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTieuDe,tvNoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(DatTen datTen) {
            tvTieuDe.setText(datTen.getTenTieuDe());
            tvNoiDung.setText(datTen.getNoiDung());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
