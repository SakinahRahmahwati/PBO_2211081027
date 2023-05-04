/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP-PC
 */
public class BukuDaoImpl implements BukuDao {
    List<Buku> data = new ArrayList<>();
    
    public BukuDaoImpl(){
        data.add(new Buku("11111", "Laskar Pelangi", "Andrea Hirata", "Bentang Pustaka", "2005"));
        data.add(new Buku("11112", "Spider-Man", "Stan Lee", "Marvel comic", "1962"));
        data.add(new Buku("11113", "Perjuangan", "Ali", "Perpustakaan", "2008"));
    }
    
    public void save(Buku buku){
        data.add(buku);
    }
    public void update(int index, Buku buku){
        data.set(index, buku);
    }
    public void delete(int index){
        data.remove(index);
    }
    public Buku getBuku(int index){
        return data.get(index);
    }
    public List<Buku> getAll(){
        return data;
    }
}
