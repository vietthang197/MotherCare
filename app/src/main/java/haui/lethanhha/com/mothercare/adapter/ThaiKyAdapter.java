package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
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
import haui.lethanhha.com.mothercare.model.ThaiKy;

public class ThaiKyAdapter extends RecyclerView.Adapter<ThaiKyAdapter.ViewHolder> {

    private List<ThaiKy> thaiKyList;

    private Context context;

    private RecyclerViewOnClickListener listener;

    public ThaiKyAdapter(List<ThaiKy> thaiKyList, Context context, RecyclerViewOnClickListener listener) {
        this.thaiKyList = thaiKyList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.thai_ky_item_recycler_view, parent, false);
        ThaiKyAdapter.ViewHolder viewHolder = new ThaiKyAdapter.ViewHolder(view, listener);
        viewHolder.imgThaiKyItem = view.findViewById(R.id.imgThaikyItem);
        viewHolder.tvThaiKyItem = view.findViewById(R.id.tvThaiKyItem);
        viewHolder.btnChiTietThaiKy = view.findViewById(R.id.btnChiTietThaiKy);
        viewHolder.imgAllow = view.findViewById(R.id.imgAllow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(thaiKyList.get(position));
    }

    @Override
    public int getItemCount() {
        return thaiKyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgThaiKyItem, imgAllow;
        TextView tvThaiKyItem;
        Button btnChiTietThaiKy;

        RecyclerViewOnClickListener recyclerViewOnClickListener;

        public ViewHolder(View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            recyclerViewOnClickListener = listener;
        }

        void bindView(ThaiKy thaiKy) {
//            Picasso.with(context).load(thaiKy.getImgMon()).into(imgThaiKyItem);
//            Picasso.with(context).load(thaiKy.getImgAllow()).into(imgAllow);
//            tvThaiKyItem.setText(thaiKy.getTenMon());

        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onClick(getAdapterPosition());
        }
    }
}
