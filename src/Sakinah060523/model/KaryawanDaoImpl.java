/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah060523.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP-PC
 */
public class KaryawanDaoImpl implements KaryawanDao{
    List <Karyawan> data = new ArrayList<>();
    
    public KaryawanDaoImpl() {
        data.add(new Karyawan("Sakinah", "Padang", "belum nikah","111","I","manager"));
        data.add(new Karyawan("Rahmah", "Pariaman", "nikah","112","II","Karyawan"));
        data.add(new Karyawan("Wati", "Bukittinggi", "belim menikah","113","II","Karyawan"));
    }
    
    public void save(Karyawan karyawan){
        data.add(karyawan);
    }
    public void update(int index, Karyawan karyawan){
        data.set(index, karyawan);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Karyawan getKaryawan(int index){
        return data.get(index);
    }
    
    public List<Karyawan> getAll(){
        return data;
    }
}
