/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.dao;

import SakinahR.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP-PC
 */
public class PeminjamanDaoImpl implements PeminjamanDao {
    private Connection connection;
    
    public PeminjamanDaoImpl(Connection connection){
        this.connection = connection; 
    }
    
    public void insert (Peminjaman peminjaman)throws Exception{
        String sql = "INSERT INTO Peminjaman VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, peminjaman.getTglkembali());
        ps.executeUpdate();
        ps.close();
    }
    
    public void update (Peminjaman peminjaman) throws Exception{
        String sql = "UPDATE Peminjaman SET tglkembali = ? "
                +"WHERE kodeanggota = ? AND kodebuku = ? AND tglpinjam = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglkembali());
        ps.setString(2, peminjaman.getAnggota().getKodeanggota());
        ps.setString(3, peminjaman.getBuku().getKodeBuku());
        ps.setString(4, peminjaman.getTglpinjam());
        ps.executeUpdate();
    }
    
    public void delete (Peminjaman peminjaman) throws Exception{
        String sql = "DELETE FROM Peminjaman WHERE kodeanggota = ? AND kodebuku = ? AND tglpinjam = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.executeUpdate();
    }
    
    public Peminjaman getPeminjaman (String kodeanggota, String kodebuku, String tglpinjam) throws Exception{
        String sql = "SELECT * FROM Peminjaman" 
                + "WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
       Peminjaman peminjaman = null;
       if(rs.next()){
           peminjaman = new Peminjaman();
           AnggotaDao anggotadao = new AnggotaDaoImpl(connection);
           Anggota anggota = anggotadao.getAnggota(kodeanggota);
           peminjaman.setAnggota(anggota);
           BukuDao bukuDao = new BukuDaoImpl(connection);
           Buku buku = bukuDao.getBuku(kodebuku);
           peminjaman.setBuku(buku);
           peminjaman.setTglpinjam(rs.getString(3));
           peminjaman.setTglkembali(rs.getString(4));
       }
       return peminjaman;
    }
    
    public List<Peminjaman> getAll() throws Exception{
        String sql = "SELECT * FROM Peminjaman";
        PreparedStatement ps = connection.prepareStatement(sql);
        Peminjaman peminjaman;
        ResultSet rs = ps.executeQuery();
        List <Peminjaman> list = new ArrayList<>();
        while(rs.next()){
            peminjaman = new Peminjaman();
            AnggotaDao anggotadao = new AnggotaDaoImpl(connection);
            Anggota anggota = anggotadao.getAnggota(rs.getString(1));
            peminjaman.setAnggota(anggota);
            BukuDao bukuDao = new BukuDaoImpl(connection);
            Buku buku = bukuDao.getBuku(rs.getString(2));
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
            list.add(peminjaman);
        }
        return list;
    }
}
