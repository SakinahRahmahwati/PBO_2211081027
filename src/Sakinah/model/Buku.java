/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah.model;

/**
 *
 * @author HP-PC
 */
public class Buku {
    private String kodebuku;
    private String judulbuku;
    private String pengarang;
    private String penerbit;
    private String thnterbit;
    
    public Buku(){
    }
    
    public Buku(String kodebuku, String judulbuku, String pengarang, String penerbit, String thnterbit){
        this.kodebuku = kodebuku;
        this.judulbuku = judulbuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.thnterbit = thnterbit;
        
    }
    
    public String getKodeBuku(){
        return kodebuku;
    }
    public void setKodeBuku(String kodebuku){
        this.kodebuku = kodebuku;
    }
    
    public String getJudulBuku(){
        return judulbuku;
    }
    public void setJudulBuku(String judulbuku){
        this.judulbuku = judulbuku;
    }
    
    public String getPengarang(){
        return pengarang;
    }
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }
    
    public String getPenerbit(){
        return penerbit;
    }
    public void setPenerbit(String penerbit){
        this.penerbit = penerbit;
    }
    public String getThnTerbit(){
        return thnterbit;
    }
    public void setThnTerbit(String thnterbit){
        this.thnterbit = thnterbit;
    }
}
