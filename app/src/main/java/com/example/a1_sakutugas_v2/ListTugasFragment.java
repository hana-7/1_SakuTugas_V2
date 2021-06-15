package com.example.a1_sakutugas_v2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTugasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTugasFragment extends Fragment implements ListTugasAdapter.ItemClickListener {
    private ArrayList<ListTugas> listTugasArrayList;
    private RecyclerView recyclerView;
    private ListTugasAdapter listTugasAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTugasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTugasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTugasFragment newInstance(String param1, String param2) {
        ListTugasFragment fragment = new ListTugasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_tugas, container, false);
//        FloatingActionButton floatingActionButton = (FloatingActionButton)view.findViewById(R.id.floatingActionButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), TambahTugas.class);
//                startActivity(intent);
//            }
//        });

        getData();

        recyclerView = view.findViewById(R.id.recyclerview);
        listTugasAdapter = new ListTugasAdapter(listTugasArrayList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listTugasAdapter);

        return view;
    }

    public void getData(){
        listTugasArrayList = new ArrayList<>();
        listTugasArrayList.add(new ListTugas("Artikel Pancasila", "11-07-2020", "Materi Berbangsa dan Bernegara"));
        listTugasArrayList.add(new ListTugas("Video corona", "26-07-2020", "-"));
        listTugasArrayList.add(new ListTugas("Essay Bahasa Inggris", "05-08-2020", "-"));
        listTugasArrayList.add(new ListTugas("StatProb, Data", "06-08-2020", "Data sebanyak 50"));
        listTugasArrayList.add(new ListTugas("PPT APSI", "-07-2020", "-"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this.getContext(), ItemDetailActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("tugas", listTugasArrayList.get(position).getTugas());
        bundle.putString("tanggal", listTugasArrayList.get(position).getTanggal());
        bundle.putString("keterangan", listTugasArrayList.get(position).getKeterangan());
        intent.putExtras(bundle);

        startActivity(intent);
    }
}