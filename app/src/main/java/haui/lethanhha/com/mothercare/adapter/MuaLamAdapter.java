package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.model.CanMuaCanLam;

public class MuaLamAdapter extends RecyclerView.Adapter<MuaLamAdapter.ViewHolder> {

    private List<CanMuaCanLam> canMuaCanLamList;

    private Context context;

    public MuaLamAdapter(List<CanMuaCanLam> canMuaCanLamList, Context context) {
        this.canMuaCanLamList = canMuaCanLamList;
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
        holder.bindView(canMuaCanLamList.get(position));
    }

    @Override
    public int getItemCount() {
        return canMuaCanLamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTieuDe,tvNoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(CanMuaCanLam canMuaCanLam) {
            tvTieuDe.setText(canMuaCanLam.getNoiDung());
            tvNoiDung.setText(canMuaCanLam.getNoiDung());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
