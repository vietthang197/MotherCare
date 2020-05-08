package haui.lethanhha.com.mothercare.fragment;

import android.content.Intent;
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
import haui.lethanhha.com.mothercare.activity.AnUongDetailActivity;
import haui.lethanhha.com.mothercare.activity.MenuMainActivity;
import haui.lethanhha.com.mothercare.adapter.AnUongAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.model.AnUong;

public class ThucPhamFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<AnUong> anUongList;

    private RecyclerView recyclerViewAnUong;

    private AnUongAdapter anUongAdapter;

    public ThucPhamFragment(List<AnUong> anUongList) {
        this.anUongList = anUongList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_an_uong, container, false);
        recyclerViewAnUong = view.findViewById(R.id.recyclerAnUong);
        anUongAdapter = new AnUongAdapter(anUongList, getContext(), this);
        recyclerViewAnUong.setAdapter(anUongAdapter);
        recyclerViewAnUong.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAnUong.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getContext(), AnUongDetailActivity.class);
        intent.putExtra("data", anUongList.get(position).getNoidung());
        startActivity(intent);
    }
}
