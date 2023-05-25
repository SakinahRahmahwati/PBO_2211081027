/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_A;

/**
 *
 * @author HP-PC
 */
public class Pelanggan {
    private String KodePelanggan;
    private String NamaPelanggan;
    private String Jenis;
    
    public Pelanggan(){
        
    }
    
    public Pelanggan(String KodePelanggan, String NamaPelanggan, String Jenis){
        this.KodePelanggan = KodePelanggan;
        this.NamaPelanggan = NamaPelanggan;
        this.Jenis = Jenis;
    }
    
    public String getKodePelanggan(){
        return KodePelanggan;
    }
    
    public void setKodePelanggan(){
        this.KodePelanggan = KodePelanggan;
    }
    
    public String getNamaPelanggan(){
        return NamaPelanggan;
    }
    
    public void setNamaPelanggan(){
        this.NamaPelanggan = NamaPelanggan;
    }
    
    public String getJenis(){
        return Jenis;
    }
    
    public void setJenis(){
        this.Jenis = Jenis;
    }
}
