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
public class PeminjamanDaoImpl implements PeminjamanDao{
    List<Peminjaman> data = new ArrayList<>();
    
    public PeminjamanDaoImpl(){
        AnggotaDao anggotaDao = new AnggotaDaoImpl();
        BukuDao bukuDao = new BukuDaoImpl();
        data.add(new Peminjaman(anggotaDao.getAnggota(0), bukuDao.getBuku(0),"12/03/2023","13/03/2023"));
        data.add(new Peminjaman(anggotaDao.getAnggota(0), bukuDao.getBuku(1),"12/03/2023","13/03/2023"));
    }
    
    public void save(Peminjaman peminjaman){
        data.add(peminjaman);
    }
    
    public void update(int index, Peminjaman peminjaman){
        data.set(index, peminjaman);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Peminjaman getPeminjaman(int index){
        return data.get(index);
    }
    
    public List<Peminjaman> getAll(){
        return data;
    }
}
