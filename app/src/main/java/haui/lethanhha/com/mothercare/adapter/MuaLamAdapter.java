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
import haui.lethanhha.com.mothercare.model.MuaLam;

public class MuaLamAdapter extends RecyclerView.Adapter<MuaLamAdapter.ViewHolder> {

    private List<MuaLam> muaLamList;

    private Context context;

    public MuaLamAdapter(List<MuaLam> muaLamList, Context context) {
        this.muaLamList = muaLamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mua_lam_item_recycler_view, parent, false);
        MuaLamAdapter.ViewHolder viewHolder = new MuaLamAdapter.ViewHolder(view);
        viewHolder.tvTieuDe = view.findViewById(R.id.tvTieuDe);
        viewHolder.tvNoiDung = view.findViewById(R.id.tvNoiDung);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(muaLamList.get(position));
    }

    @Override
    public int getItemCount() {
        return muaLamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTieuDe,tvNoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(MuaLam muaLam) {
            tvTieuDe.setText(muaLam.getTenTieuDe());
            tvNoiDung.setText(muaLam.getNoiDung());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
