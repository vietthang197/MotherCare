package haui.lethanhha.com.mothercare.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.activity.MenuMainActivity;
import haui.lethanhha.com.mothercare.adapter.AnUongAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.adapter.ThaiKyAdapter;
import haui.lethanhha.com.mothercare.model.AnUong;
import haui.lethanhha.com.mothercare.model.ThaiKy;

public class ThaiKyFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<ThaiKy> thaiKyList;

    private RecyclerView recyclerViewThaiKy;

    private ThaiKyAdapter thaiKyAdapter;

    public ThaiKyFragment(List<ThaiKy> thaiKyList) {
        this.thaiKyList = thaiKyList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thai_ky, container, false);
        recyclerViewThaiKy = view.findViewById(R.id.recyclerThaiKy);
        thaiKyAdapter = new ThaiKyAdapter(thaiKyList, getContext(), this);

        recyclerViewThaiKy.setAdapter(thaiKyAdapter);
        recyclerViewThaiKy.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewThaiKy.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onClick(int position) {

    }
}
