/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SakinahR.dao;

import SakinahR.model.Peminjaman;
import java.util.List;
/**
 *
 * @author HP-PC
 */
public interface PeminjamanDao {
    void insert (Peminjaman peminjaman) throws Exception;
    void update (Peminjaman peminjaman)throws Exception;
    void delete (Peminjaman peminjaman) throws Exception;
    Peminjaman getPeminjaman(String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    List <Peminjaman> getAll() throws Exception;
}
