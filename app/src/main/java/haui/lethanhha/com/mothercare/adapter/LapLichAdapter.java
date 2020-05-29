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
import haui.lethanhha.com.mothercare.model.LapLich;

public class LapLichAdapter extends RecyclerView.Adapter<LapLichAdapter.ViewHolder> {
    private List<LapLich> lapLichList;

    private Context context;


    public LapLichAdapter(List<LapLich> lapLichList, Context context) {
        this.lapLichList = lapLichList;
        this.context = context;
    }

    @NonNull
    @Override
    public LapLichAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lap_lich, parent, false);
        LapLichAdapter.ViewHolder viewHolder = new LapLichAdapter.ViewHolder(view);
        viewHolder.tvNoiDung = view.findViewById(R.id.tvNoiDung);
        viewHolder.tvGioHen = view.findViewById(R.id.tvGioHen);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LapLichAdapter.ViewHolder holder, int position) {
        holder.bindView(lapLichList.get(position));
    }

    @Override
    public int getItemCount() {
        return lapLichList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvNoiDung, tvGioHen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(LapLich lapLich) {
            tvNoiDung.setText("Ngày đặt: " + lapLich.getNgayNhacNho() + " : " + lapLich.getGhiChu());
            tvGioHen.setText("Báo vào lúc: " + lapLich.getGioNhacNho().split(":")[0] + "h:" + lapLich.getGioNhacNho().split(":")[1] + "p");
        }

        @Override
        public void onClick(View v) {

        }
    }
}
