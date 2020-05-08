package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.fragment.TiemPhongFragment;
import haui.lethanhha.com.mothercare.model.AnUong;
import haui.lethanhha.com.mothercare.model.TiemPhong;

public class TiemPhongAdapter extends RecyclerView.Adapter<TiemPhongAdapter.ViewHolder> {

    private List<TiemPhong> tiemPhongList;

    private Context context;

    public TiemPhongAdapter(List<TiemPhong> tiemPhongList, Context context) {
        this.tiemPhongList = tiemPhongList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tiem_phong_item_recycler_view, parent, false);
        TiemPhongAdapter.ViewHolder viewHolder = new TiemPhongAdapter.ViewHolder(view);
        viewHolder.tvTieuDe = view.findViewById(R.id.tvTieuDe);
        viewHolder.tvNoiDung = view.findViewById(R.id.tvNoiDung);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(tiemPhongList.get(position));
    }

    @Override
    public int getItemCount() {
        return tiemPhongList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTieuDe,tvNoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(TiemPhong tiemPhong) {
            tvTieuDe.setText(tiemPhong.getTenTiemPhong());
            tvNoiDung.setText(tiemPhong.getNoiDung());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
