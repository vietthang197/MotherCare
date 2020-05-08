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
import haui.lethanhha.com.mothercare.adapter.KhamThaiAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.adapter.TiemPhongAdapter;
import haui.lethanhha.com.mothercare.model.KhamThai;
import haui.lethanhha.com.mothercare.model.TiemPhong;


public class KhamThaiFragment extends Fragment implements RecyclerViewOnClickListener {


    private List<KhamThai> khamThaiList;

    private RecyclerView recyclerViewKhamThai;

    private KhamThaiAdapter khamThaiAdapter;

    public KhamThaiFragment(List<KhamThai> khamThaiList) {
        this.khamThaiList = khamThaiList;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kham_thai, container, false);
        recyclerViewKhamThai = view.findViewById(R.id.recyclerKhamThai);
        khamThaiAdapter = new KhamThaiAdapter(khamThaiList, getContext());

        recyclerViewKhamThai.setAdapter(khamThaiAdapter);
        recyclerViewKhamThai.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewKhamThai.setHasFixedSize(true);
        return view;

    }

    @Override
    public void onClick(int position) {

    }
}
