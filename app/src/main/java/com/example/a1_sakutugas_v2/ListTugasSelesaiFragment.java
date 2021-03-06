package com.example.a1_sakutugas_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTugasSelesaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTugasSelesaiFragment extends Fragment {
    private ArrayList<ListTugasSelesai> listTugasSelesaiArrayList;
    private RecyclerView recyclerView2;
    private ListTugasSelesaiAdapter listTugasSelesaiAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTugasSelesaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTugasSelesaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTugasSelesaiFragment newInstance(String param1, String param2) {
        ListTugasSelesaiFragment fragment = new ListTugasSelesaiFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_tugas_selesai, container, false);

        getData();

        recyclerView2 = view.findViewById(R.id.recyclerview2);
        listTugasSelesaiAdapter = new ListTugasSelesaiAdapter(listTugasSelesaiArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(listTugasSelesaiAdapter);

        return view;
    }

    public void getData(){
        listTugasSelesaiArrayList = new ArrayList<>();
        listTugasSelesaiArrayList.add(new ListTugasSelesai("A", "01-07-2021", "Materi Berbangsa dan Bernegara"));
        listTugasSelesaiArrayList.add(new ListTugasSelesai("B", "26-07-2021", "-"));
        listTugasSelesaiArrayList.add(new ListTugasSelesai("C", "05-08-2021", "-"));
        listTugasSelesaiArrayList.add(new ListTugasSelesai("D", "06-08-2021", "Data sebanyak 50"));
    }
}