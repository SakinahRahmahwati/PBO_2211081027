/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SakinahR.dao;
import SakinahR.model.Buku;
import java.util.List;
/**
 *
 * @author HP-PC
 */
public interface BukuDao{
    void insert (Buku buku)throws Exception;
    void update(Buku buku)throws Exception;
    void delete (Buku buku)throws Exception;
    Buku getBuku(String kodebuku)throws Exception;
    List<Buku> getAll()throws Exception;
}


