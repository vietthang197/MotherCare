package haui.lethanhha.com.mothercare.adapter;

import android.content.Context;
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
import haui.lethanhha.com.mothercare.model.Shop;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>  {

    private List<Shop> shops;
    private Context context;

    private RecyclerViewOnClickListener listener;

    public ShopAdapter(List<Shop> shops, Context context, RecyclerViewOnClickListener listener) {
        this.shops = shops;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        ShopAdapter.ViewHolder viewHolder = new ShopAdapter.ViewHolder(view, listener);
        viewHolder.imgShop = view.findViewById(R.id.imgShop);
        viewHolder.tvTitle = view.findViewById(R.id.tvTitleShop);
        viewHolder.tvPrice = view.findViewById(R.id.tvPrice);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder holder, int position) {
        holder.bindView(shops.get(position));
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgShop;
        TextView tvTitle, tvPrice;

        RecyclerViewOnClickListener recyclerViewOnClickListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(ViewHolder.this);
            recyclerViewOnClickListener = listener;
        }

        public void bindView(Shop shop) {
            if (shop.getUrlImage() == null)
                Picasso.with(context).load(shop.getAnhShop()).into(imgShop);
            else
                Picasso.with(context).load(shop.getUrlImage()).into(imgShop);
            tvTitle.setText(shop.getTitle());
            tvPrice.setText(shop.getMoney());
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onClick(getAdapterPosition());
        }
    }
}
