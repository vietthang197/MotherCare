package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.model.DanhMuc;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.ViewHolder> {

    private List<DanhMuc> danhMucs;
    private Context context;

    private RecyclerViewOnClickListener listener;

    public DanhMucAdapter(Context context, List<DanhMuc> danhMucs, RecyclerViewOnClickListener listener) {
        this.context = context;
        this.danhMucs = danhMucs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danh_muc, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, listener);
        viewHolder.imgAnhDanhMuc = view.findViewById(R.id.imgItemDanhMuc);
        viewHolder.tvTenDanhMuc = view.findViewById(R.id.tvItemDanhmuc);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindView(danhMucs.get(position));
    }

    @Override
    public int getItemCount() {
        return this.danhMucs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgAnhDanhMuc;
        TextView tvTenDanhMuc;

        RecyclerViewOnClickListener recyclerViewOnClickListener;

        ViewHolder(@NonNull View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            recyclerViewOnClickListener = listener;
        }

        void bindView(DanhMuc danhMuc) {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier(danhMuc.getTenHinhAnh(), "drawable",
                    context.getPackageName());
            Picasso.with(context).load(resourceId).into(imgAnhDanhMuc);
            tvTenDanhMuc.setText(danhMuc.getTenDanhMuc());
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onClick(getAdapterPosition());
        }
    }
}
