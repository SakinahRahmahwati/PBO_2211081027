/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import SakinahR.model.Anggota;
import SakinahR.model.Buku;
import SakinahR.model.Peminjaman;

/**
 *
 * @author HP-PC
 */
public class PeminjamanDaoImpl implements PeminjamanDao {
    Connection connection;
    
    public PeminjamanDaoImpl(Connection connection){
        this.connection = connection; 
    }
    
    @Override
    public void insert (Peminjaman peminjaman)throws Exception{
        String sql = "insert into peminjaman values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, peminjaman.getTglkembali());
        ps.executeUpdate();
        ps.close();
    }
    
    @Override
    public void update (Peminjaman peminjaman) throws Exception{
        String sql = "UPDATE peminjaman SET tglkembali=? "
                +"WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglkembali());
        ps.setString(2, peminjaman.getAnggota().getKodeanggota());
        ps.setString(3, peminjaman.getBuku().getKodeBuku());
        ps.setString(4, peminjaman.getTglpinjam());
        ps.executeUpdate();
    }
    
    @Override
    public void delete (Peminjaman peminjaman) throws Exception{
        String sql = "DELETE FROM Peminjaman WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodeBuku());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.executeUpdate();
        ps.close();
    }
    
    @Override
    public Peminjaman getPeminjaman (String kodeanggota, String kodebuku, String tglpinjam) throws Exception{
        String sql = "SELECT * FROM peminjaman " 
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
