package haui.lethanhha.com.mothercare.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.adapter.TiemPhongAdapter;
import haui.lethanhha.com.mothercare.model.TiemPhong;

public class TiemPhongFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<TiemPhong> tiemPhongList;

    private RecyclerView recyclerViewTiemPhong;

    private TiemPhongAdapter tiemPhongAdapter;

    public TiemPhongFragment(List<TiemPhong> tiemPhongList) {
        this.tiemPhongList = tiemPhongList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tiem_phong, container, false);
        recyclerViewTiemPhong = view.findViewById(R.id.recyclerTiemPhong);
        tiemPhongAdapter = new TiemPhongAdapter(tiemPhongList, getContext());

        recyclerViewTiemPhong.setAdapter(tiemPhongAdapter);
        recyclerViewTiemPhong.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewTiemPhong.setHasFixedSize(true);
        return view;

    }

    @Override
    public void onClick(int position) {

    }
}
