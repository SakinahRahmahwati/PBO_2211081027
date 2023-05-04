/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sakinah.model;
import java.util.List;
/**
 *
 * @author HP-PC
 */
public interface BukuDao {
    void save (Buku buku);
    void update(int index, Buku buku);
    void delete (int index);
    Buku getBuku(int index);
    List <Buku> getAll();
}
