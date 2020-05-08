package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
import android.content.res.Resources;
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
import haui.lethanhha.com.mothercare.model.AnUong;
import haui.lethanhha.com.mothercare.model.DanhMuc;

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
        View view = LayoutInflater.from(context).inflate(R.layout.an_uong_item_recycler_view, parent, false);
        AnUongAdapter.ViewHolder viewHolder = new AnUongAdapter.ViewHolder(view, listener);
        viewHolder.imgAnUongItem = view.findViewById(R.id.imgAnUongItem);
        viewHolder.tvAnUongItem = view.findViewById(R.id.tvAnUongItem);
        viewHolder.btnChiTietAnUong = view.findViewById(R.id.btnChiTietAnUong);
        viewHolder.imgAllow = view.findViewById(R.id.imgAllow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(anUongList.get(position));
    }

    @Override
    public int getItemCount() {
        return anUongList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgAnUongItem, imgAllow;
        TextView tvAnUongItem;
        Button btnChiTietAnUong;

        RecyclerViewOnClickListener recyclerViewOnClickListener;

        public ViewHolder(View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            recyclerViewOnClickListener = listener;
        }

        void bindView(AnUong anUong) {
            Resources resources = context.getResources();
            int resourceId = resources.getIdentifier(anUong.getHinhAnh(), "drawable",
                    context.getPackageName());
            if (resourceId != 0)
                Picasso.with(context).load(resourceId).into(imgAnUongItem);
            Picasso.with(context).load(anUong.getNenKhongNen().equals("Nên") ? R.drawable.nen : R.drawable.khongnen).into(imgAllow);
            tvAnUongItem.setText(anUong.getTenAnUong());

        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onClick(getAdapterPosition());
        }
    }
}
