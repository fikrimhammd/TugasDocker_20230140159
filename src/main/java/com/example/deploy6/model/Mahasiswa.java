package com.example.deploy6.model;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jenisKelamin;
    private String programStudi;
    private String angkatan;

    // Constructor
    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String nim, String jenisKelamin, String programStudi, String angkatan) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.programStudi = programStudi;
        this.angkatan = angkatan;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }
}