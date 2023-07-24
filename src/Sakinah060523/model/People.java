/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah060523.model;

/**
 *
 * @author HP-PC
 */
public class People {
    protected String nama;
    protected String alamat;
    protected String statusNikah;
    
    public People(){
        
    }
    
    public People(String nama, String alamat, String statusNikah){
        this.nama = nama;
        this.alamat = alamat;
        this.statusNikah = statusNikah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatusNikah() {
        return statusNikah;
    }

    public void setStatusNikah(String statusNikah) {
        this.statusNikah = statusNikah;
    }
    
    
}
