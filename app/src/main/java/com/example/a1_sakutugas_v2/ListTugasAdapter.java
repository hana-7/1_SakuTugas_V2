package com.example.a1_sakutugas_v2;

import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListTugasAdapter extends RecyclerView.Adapter<ListTugasAdapter.ListTugasViewHolder> {
    private ArrayList<ListTugas> listTugas;
    private ItemClickListener itemListener;

    public ListTugasAdapter(ArrayList<ListTugas> listTugas, ItemClickListener itemListener) {
        this.listTugas = listTugas;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ListTugasAdapter.ListTugasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_tugas, parent, false);
        return new ListTugasViewHolder(view, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTugasViewHolder holder, int position) {
        holder.tvTugas.setText(listTugas.get(position).getTugas());
        holder.tvTanggal.setText(listTugas.get(position).getTanggal());
        holder.tvKeterangan.setText(listTugas.get(position).getKeterangan());

    }

    @Override
    public int getItemCount() {
        return listTugas.size();
        //return (listTugas != null) ? listTugas.size() : 0;
    }

    public class ListTugasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTugas, tvTanggal, tvKeterangan;
        ItemClickListener itemListener;

        public ListTugasViewHolder(View view, ItemClickListener itemListener) {
            super(view);

            tvTugas = view.findViewById(R.id.tvTugas);
            tvTanggal = view.findViewById(R.id.tvTanggal);
            tvKeterangan = view.findViewById(R.id.tvKeterangan);

            this.itemListener = itemListener;
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
