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
import haui.lethanhha.com.mothercare.adapter.DatTenAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.model.DatTen;


public class DatTenFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<DatTen> datTenList;

    private RecyclerView recyclerViewDatTen;

    private DatTenAdapter datTenAdapter;

    public DatTenFragment(List<DatTen> datTenList) {
        this.datTenList = datTenList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dat_ten, container, false);
        recyclerViewDatTen = view.findViewById(R.id.recyclerDatTen);
        datTenAdapter = new DatTenAdapter(datTenList,getContext());

        recyclerViewDatTen.setAdapter(datTenAdapter);
        recyclerViewDatTen.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDatTen.setHasFixedSize(true);
        return view;

    }

    @Override
    public void onClick(int position) {

    }
}
