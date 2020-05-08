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
import haui.lethanhha.com.mothercare.model.DocTruyen;

public class DocTruyenAdapter extends RecyclerView.Adapter<DocTruyenAdapter.ViewHolder> {

    private List<DocTruyen> docTruyenList;

    private Context context;

    private RecyclerViewOnClickListener listener;

    public DocTruyenAdapter(List<DocTruyen> docTruyenList, Context context, RecyclerViewOnClickListener listener) {
        this.docTruyenList = docTruyenList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doc_truyen_item_recycler_view, parent, false);
        DocTruyenAdapter.ViewHolder viewHolder = new DocTruyenAdapter.ViewHolder(view, listener);
        viewHolder.imgDocTruyenItem = view.findViewById(R.id.imgDocTruyenItem);
        viewHolder.tvDocTruyenItem = view.findViewById(R.id.tvDocTruyenItem);
        viewHolder.btnChiTietDocTruyen = view.findViewById(R.id.btnChiTietDocTruyen);
        viewHolder.imgAllow = view.findViewById(R.id.imgAllow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(docTruyenList.get(position));
    }

    @Override
    public int getItemCount() {
        return docTruyenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgDocTruyenItem, imgAllow;
        TextView tvDocTruyenItem;
        Button btnChiTietDocTruyen;

        RecyclerViewOnClickListener recyclerViewOnClickListener;

        public ViewHolder(View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            recyclerViewOnClickListener = listener;
        }

        void bindView(DocTruyen docTruyen) {
            Picasso.with(context).load(docTruyen.getImgMon()).into(imgDocTruyenItem);
            Picasso.with(context).load(docTruyen.getImgAllow()).into(imgAllow);
            tvDocTruyenItem.setText(docTruyen.getTenMon());

        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onClick(getAdapterPosition());
        }
    }
}
