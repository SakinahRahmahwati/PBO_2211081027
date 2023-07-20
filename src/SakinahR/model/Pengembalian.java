/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.model;

/**
 *
 * @author HP-PC
 */
public class Pengembalian {
    private String kodeAnggota;
    private String namaAnggota;
    private String Kodebuku;
    private String judulBuku;
    private String tglpinjam;
    private String tglkembali;
    private String Dikembalikan;
    private int terlambat;
    private double denda;
    
    public Pengembalian(){

    }

    public Pengembalian(Peminjaman p, String tgldikembalikan, int terlambat, double denda) {
        this.kodeAnggota = kodeAnggota;
        this.namaAnggota = namaAnggota;
        this.Kodebuku = Kodebuku;
        this.judulBuku = judulBuku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
        this.Dikembalikan = Dikembalikan;
        this.terlambat = terlambat;
        this.denda = denda;;
    }

    public String getKodeAnggota() {
        return kodeAnggota;
    }

    public void setKodeAnggota(String kodeAnggota) {
        this.kodeAnggota = kodeAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getKodebuku() {
        return Kodebuku;
    }

    public void setKodebuku(String Kodebuku) {
        this.Kodebuku = Kodebuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public String getDikembalikan() {
        return Dikembalikan;
    }

    public void setDikembalikan(String Dikembalikan) {
        this.Dikembalikan = Dikembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    
}
