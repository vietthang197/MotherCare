package haui.lethanhha.com.mothercare.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.AnUongAdapter;
import haui.lethanhha.com.mothercare.model.AnUong;

public class ThucPhamFragment extends Fragment {

    private List<AnUong> anUongList;

    private RecyclerView recyclerViewAnUong;

    private AnUongAdapter anUongAdapter;

    public ThucPhamFragment(/*List<AnUong> anUongList*/) {
     /*   this.anUongList = anUongList;*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_an_uong, container, false);
//        recyclerViewAnUong = view.findViewById(R.id.recyclerAnUong);
//        anUongAdapter = new AnUongAdapter();
        return view;
    }
}
