/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah060523.model;

/**
 *
 * @author HP-PC
 */
public class Karyawan extends People{
    private String nip;
    private String golongan;
    private String jabatan;
    
    public String getNip(){
        return nip;  
    }
    
    public String getGolongan(){
        return golongan;   
    }
    
    public String getJabatan(){
        return jabatan;
    }
    
    
    public void setNip(){
        this.nip = nip;
    }
    
    public void setGolongan(){
        this.golongan = golongan;
    }
    
    public void setJabatan(){
        this.jabatan = jabatan;
    }
    
}
