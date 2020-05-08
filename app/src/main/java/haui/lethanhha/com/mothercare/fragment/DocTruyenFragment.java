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
import haui.lethanhha.com.mothercare.adapter.DocTruyenAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.model.DocTruyen;

public class DocTruyenFragment extends Fragment implements RecyclerViewOnClickListener {

    private List<DocTruyen> docTruyenList;

    private RecyclerView recyclerViewDocTruyen;

    private DocTruyenAdapter docTruyenAdapter;

    public DocTruyenFragment(List<DocTruyen> docTruyenList) {
        this.docTruyenList= docTruyenList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc_truyen, container, false);
        recyclerViewDocTruyen = view.findViewById(R.id.recyclerDocTruyen);
        docTruyenAdapter = new DocTruyenAdapter(docTruyenList, getContext(), this);

        recyclerViewDocTruyen.setAdapter(docTruyenAdapter);
        recyclerViewDocTruyen.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDocTruyen.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onClick(int position) {

    }
}
