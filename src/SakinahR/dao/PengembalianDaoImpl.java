/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.dao;

import SakinahR.model.*;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP-PC
 */
public class PengembalianDaoImpl implements PengembalianDao {
    private Connection con;
    private Pengembalian p;
    
    public PengembalianDaoImpl(Connection con)throws Exception{
        this.con = con;
    }
    
    @Override
    public void insert (Pengembalian p) throws Exception{
        String insert = "insert into pengembalian values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, p.getKodeAnggota());
        ps.setString(2, p.getKodebuku());
        ps.setString(3, p.getTglpinjam());
        ps.setString(4, p.getTglkembali());
        ps.setInt(5, p.getTerlambat());
        ps.setDouble(6, p.getDenda());
        ps.executeUpdate();
    }
    
    @Override
    public void update (Pengembalian p) throws Exception{
        String update =  "UPDATE `pengembalian` SET `Tglkembali` = ?, `Terlambat` = ?, `Denda` = ? WHERE `pengembalian`.`kodeAnggota` = ? AND `pengembalian`.`Kodebuku` = ? AND `pengembalian`.`TglPinjam` = ?";
        PreparedStatement ps = con.prepareStatement(update);
        ps.setString(1, p.getTglkembali());
        ps.setInt(2, p.getTerlambat());
        ps.setDouble(3, p.getDenda());
        ps.setString(4, p.getKodeAnggota());
        ps.setString(5, p.getKodebuku());
        ps.setString(6, p.getTglpinjam());
        ps.executeUpdate();
    }
    
     @Override
    public void delete(Pengembalian p)throws SQLException{
        String delete = "DELETE FROM pengembalian WHERE kodeAnggota = ? and Kodebuku = ? and Tglpinjam = ?";
        PreparedStatement ps = con.prepareStatement(delete);
        ps.setString(1, p.getKodeAnggota());
        ps.setString(2, p.getKodebuku());
        ps.setString(3, p.getTglpinjam());
        ps.executeUpdate();
    }
    
    @Override
    public int selisihtgl(String tgl1, String tgl2) throws Exception{
        int selisih = 0;
        String terlambat = "select datediff(?,?)as selisih";
        PreparedStatement ps = con.prepareStatement(terlambat);
        ps.setString(1,tgl1);
        ps.setString(2,tgl2);
        ResultSet rs = ps.executeQuery();
           if(rs.next()){
            selisih = rs.getInt(1);
        }
        return selisih;
    }
   
    @Override
    public Pengembalian getPengembalian (String kodeAnggota, String Kodebuku, String Tglkembali)throws SQLException, Exception {
        String sql = "select * from peminjaman where kodeAnggota= ? and Kodebuku= ? and Tglkembali= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeAnggota);
        ps.setString(2, Kodebuku);
        ps.setString(3, Tglkembali);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            p = new Pengembalian();
            p.setKodeAnggota(rs.getString(1));
            p.setKodebuku(rs.getString(2));
            p.setTglpinjam(rs.getString(3));
            p.setTglkembali(rs.getString(4));
        }
        return p;
    }
    
    @Override
    public List<Pengembalian> getAll()throws SQLException{
        String sql =  "SELECT anggota.kodeAnggota, anggota.namaAnggota, buku.Kodebuku, buku.Judulbuku, peminjaman.TglPinjam, peminjaman.Tglkembali, pengembalian.Tglkembali, pengembalian.Terlambat, pengembalian.Denda "
                +"FROM peminjaman JOIN anggota ON peminjaman.kodeAnggota = anggota.kodeAnggota JOIN buku ON peminjaman.Kodebuku = buku.Kodebuku "
                +"LEFT JOIN pengembalian ON (peminjaman.kodeAnggota = pengembalian.KodeAnggota AND peminjaman.Kodebuku = pengembalian.Kodebuku AND CAST(peminjaman.TglPinjam AS DATE) = CAST(pengembalian.TglPinjam AS DATE))";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pengembalian> list = new ArrayList<>();
        while(rs.next()){
            p = new Pengembalian();
            p.setKodeAnggota(rs.getString(1));
            p.setNamaAnggota(rs.getString(2));
            p.setKodebuku(rs.getString(3));
            p.setJudulBuku(rs.getString(4));
            p.setTglpinjam(rs.getString(5));
            p.setTglkembali(rs.getString(6));
            p.setDikembalikan(rs.getString(7));
            p.setTerlambat(rs.getInt(8));
            p.setDenda(rs.getDouble(9));
            list.add(p);
        }
        return list;
    }
    
    @Override
    public List<Pengembalian> cari(String kode, String cari)throws Exception{
        String sql = "SELECT anggota.kodeAnggota, anggota.namaAnggota, buku.Kodebuku, buku.Judulbuku, peminjaman.Tglpinjam, peminjaman.Tglkembali, pengembalian.Tglkembali, pengembalian.Terlambat, pengembalian.Denda\n" +
                    "FROM peminjaman\n" +
                    "JOIN anggota ON peminjaman.kodeAnggota = anggota.kodeAnggota\n" +
                    "JOIN buku ON peminjaman.Kodebuku = buku.Kodebuku\n" +
                    "LEFT JOIN pengembalian ON (peminjaman.kodeAnggota = pengembalian.kodeAnggota AND peminjaman.Kodebuku = pengembalian.Kodebuku AND CAST(peminjaman.Tglpinjam AS DATE) = CAST(pengembalian.Tglpinjam AS DATE))\n" +
                    "WHERE "+kode+" like '%"+cari+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
//      ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        List<Pengembalian> list = new ArrayList<>();
        while(rs.next()){
            p = new Pengembalian();
            p.setKodeAnggota(rs.getString(1));
            p.setNamaAnggota(rs.getString(2));
            p.setKodebuku(rs.getString(3));
            p.setJudulBuku(rs.getString(4));
            p.setTglpinjam(rs.getString(5));
            p.setTglkembali(rs.getString(6));
            p.setDikembalikan(rs.getString(7));
            p.setTerlambat(rs.getInt(8));
            p.setDenda(rs.getDouble(9));
            list.add(p);
        }
        return list;
    }    
}
