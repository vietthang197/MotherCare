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
import haui.lethanhha.com.mothercare.adapter.MuaLamAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.model.CanMuaCanLam;

public class MuaLamFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<CanMuaCanLam> canMuaCanLamList;

    private RecyclerView recyclerViewMuaLam;

    private MuaLamAdapter muaLamAdapter;

    public MuaLamFragment(List<CanMuaCanLam> canMuaCanLamList) {
        this.canMuaCanLamList = canMuaCanLamList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mua_lam, container, false);
        recyclerViewMuaLam = view.findViewById(R.id.recyclerMuaLam);
        muaLamAdapter = new MuaLamAdapter(canMuaCanLamList, getContext());

        recyclerViewMuaLam.setAdapter(muaLamAdapter);
        recyclerViewMuaLam.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMuaLam.setHasFixedSize(true);
        return view;

    }

    @Override
    public void onClick(int position) {

    }
}
