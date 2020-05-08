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
import haui.lethanhha.com.mothercare.model.KhamThai;

public class KhamThaiAdapter extends RecyclerView.Adapter<KhamThaiAdapter.ViewHolder> {

    private List<KhamThai> khamThaiList;

    private Context context;

    public KhamThaiAdapter(List<KhamThai> khamThaiList, Context context) {
        this.khamThaiList = khamThaiList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kham_thai_item_recycler_view, parent, false);
        KhamThaiAdapter.ViewHolder viewHolder = new KhamThaiAdapter.ViewHolder(view);
        viewHolder.tvTieuDe = view.findViewById(R.id.tvTieuDe);
        viewHolder.tvNoiDung = view.findViewById(R.id.tvNoiDung);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(khamThaiList.get(position));
    }

    @Override
    public int getItemCount() {
        return khamThaiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTieuDe,tvNoiDung;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(KhamThai khamThai) {
            tvTieuDe.setText(khamThai.getTenTieuDe());
            tvNoiDung.setText(khamThai.getNoiDung());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
