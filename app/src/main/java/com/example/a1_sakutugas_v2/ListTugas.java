package com.example.a1_sakutugas_v2;

public class ListTugas {
    private String tugas;
    private String tanggal;
    private String keterangan;

    public ListTugas(String tugas, String tanggal, String keterangan) {
        this.tugas = tugas;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
