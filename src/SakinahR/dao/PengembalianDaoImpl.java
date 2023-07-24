/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.dao;

import SakinahR.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP-PC
 */
public class PengembalianDaoImpl implements PengembalianDao{
    
    Connection connection;
    Pengembalian pengembalian; 
    
    public PengembalianDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert (Pengembalian pengembalian) throws Exception{
        String sql = "insert into pengembalian values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getKodeanggota());
        ps.setString(2, pengembalian.getKodebuku());
        ps.setString(3, pengembalian.getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
        ps.setDouble(6, pengembalian.getDenda());
        ps.executeUpdate();
        ps.close();
    }
    
    public void update (Pengembalian pengembalian) throws Exception {
        String sql = "UPDATE pengembalian SET tglkembali=? and terlambat=? and denda=?"
                + "WHERE kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getTgldikembalikan());
        ps.setDouble(2, pengembalian.getTerlambat());
        ps.setInt(3, pengembalian.getTerlambat());
        ps.setString(4, pengembalian.getKodeanggota());
        ps.setString(5, pengembalian.getKodebuku());
        ps.setString(6, pengembalian.getTglpinjam());
        ps.executeUpdate();
    }
    
    public void delete(Pengembalian pengembalian) throws Exception{
        String sql = "DELETE FROM pengembalian WHERE kodeanggota =? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getKodeanggota());
        ps.setString(2, pengembalian.getKodebuku());
        ps.setString(3, pengembalian.getTglpinjam());
        ps.executeUpdate();
        ps.close();
    }
    
    public Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception{
        String sql = "Select * FROM pengembalian "
                + "WHERE kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        if(rs.next()){
            pengembalian = new Pengembalian();
            pengembalian.setKodeanggota(rs.getString("kodeanggota"));
            pengembalian.setKodebuku(rs.getString("kodebuku"));
            pengembalian.setTglpinjam(rs.getString("tglpinjam"));
            pengembalian.setTgldikembalikan(rs.getString("tglkembali"));
            pengembalian.setTerlambat(rs.getInt("terlambat"));
            pengembalian.setDenda(rs.getDouble("denda"));
        }
        return pengembalian;
    }
    
    public List<Pengembalian> getAll() throws Exception {
        String sql = "SELECT 'anggota'.'kodeanggota', 'anggota'.'namaanggota', 'buku'.'kodebuku',"
                + "'buku'.'judulbuku'" + "'peminjaman'.'tglpinjam', 'peminjaman'.'tglkembali', 'pengembalian'.'tgldikembalikan'"
                + "'pengembalian'.'terlambat', 'pengembalian'.'denda'"
                + "FROM 'peminjaman' INNER JOIN 'anggota' ON 'peminjaman'.'kodeanggota' = 'anggota'.'kodeanggota'"
                + "INNER JOIN 'buku' ON 'peminjaman'.kodebuku' = 'buku'.'kodebuku'"
                + "LEFT JOIN 'pengembalian' ON ('peminjaman'.'kodeanggota' = 'pengembalian'.'kodeanggota'"
                + "AND 'peminjaman'.'kodebuku' = 'pengembalian'.'kodebuku'"
                + "AND 'peminjaman'.'tglpinjam' = 'pengembalian'.'tglpinjam')";
        PreparedStatement ps = connection.prepareStatement(sql);
        Pengembalian pengembalian;
        ResultSet rs = ps.executeQuery();
        List<Pengembalian> list = new ArrayList<>();
        while(rs.next()){
            pengembalian = new Pengembalian();
            pengembalian.setKodeanggota(rs.getString("kodeanggota"));
            pengembalian.setKodebuku(rs.getString("kodebuku"));
            pengembalian.setTglpinjam(rs.getString("tglpinjam"));
            pengembalian.setTgldikembalikan(rs.getString("tgldikembalikan"));
            pengembalian.setTerlambat(rs.getInt("terlambat"));
            pengembalian.setDenda(rs.getDouble("denda"));
            list.add(pengembalian);
        }
        return list;
    }

    public int selisihTgl(String tgl1, String tgl2) throws Exception {
        int selisih = 0;
        String sql = "SELECT DATEDIFF(?,?) AS selisih";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            selisih = rs.getInt(1);
        }
        return selisih;
    }

    @Override
    public int selisihtgl(String tgl1, String tgl2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

