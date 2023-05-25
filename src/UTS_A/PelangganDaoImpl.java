/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_A;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP-PC
 */
public class PelangganDaoImpl implements PelangganDao{
    List<Pelanggan> data = new ArrayList<>();
    PelangganDaoImpl data1 = new PelangganDaoImpl();
    
    public PelangganDaoImpl(){
       PelangganDaoImpl data1 = new PelangganDaoImpl();
    }
    
    public void save (Pelanggan pelanggan){
        data.add(pelanggan);
    }
    
    public void update (int idx, Pelanggan pelanggan){
        data.set(idx, pelanggan);
    }
    
    public void delete(int idx){
        data.remove(idx);
    }
    
    public Pelanggan getPelanggan(int idx){
        return data.get(idx);
    }
    
    public List <Pelanggan> getAll(){
        return data;
    }  
}



