/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_A;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import UTS_A.Pelanggan;

/**
 *
 * @author HP-PC
 */
public class Warnet {
    private int TglMasuk;
    private int JamMasuk;
    private int JamKeluar;
    private double tarif;
    
    public Warnet(){
        
    }
    
    public Warnet(int TglMasuk, int JamMasuk, int JamKeluar, double tarif){
        this.JamKeluar = JamKeluar;
        this.JamMasuk = JamMasuk;
        this.TglMasuk = TglMasuk;
        this.tarif = tarif;
    }
    
    public String getTglMasuk(){
        this.TglMasuk = TglMasuk;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate deadline = LocalDate.parse();
        }catch(Exception e){
            
        }   
    }
    
    public void setTarif( JamMasuk > 2 ){
        if (Pelanggan.JenisPelanggan = VIP){
            diskon 2%;
            
        }else if(Pelanggan.JenisPelanggan = GOLD){
            diskon 5%;
        }
    }
}
