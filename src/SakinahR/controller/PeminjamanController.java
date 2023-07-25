/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import SakinahR.db.DbHelper;
import SakinahR.model.*;
import SakinahR.dao.*;
import SakinahR.view.FormPeminjaman;

/**
 *
 * @author HP-PC
 */
public class PeminjamanController {
    FormPeminjaman formPeminjaman;
    Peminjaman peminjaman;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        try {
            this.formPeminjaman = formPeminjaman;
            peminjamanDao = new PeminjamanDaoImpl(DbHelper.getConnection());
            anggotaDao = new AnggotaDaoImpl(DbHelper.getConnection());
            bukuDao = new BukuDaoImpl(DbHelper.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    public void clearForm(){
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }
    
    public void isiComboAnggota(){
        try {
            formPeminjaman.getCboKodeAnggota().removeAllItems();
            List<Anggota> list = anggotaDao.getAll();
            for(Anggota anggota : list){
                formPeminjaman.getCboKodeAnggota()
                        .addItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiComboBuku(){
        try {
            formPeminjaman.getCboKodeBuku().removeAllItems();
            List<Buku> list = bukuDao.getAll();
            for(Buku buku : list){
                formPeminjaman.getCboKodeBuku()
                        .addItem(buku.getKodeBuku()+"-"+buku.getJudulBuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            peminjaman = new Peminjaman();
            Anggota anggota = anggotaDao.getAnggota(formPeminjaman.getCboKodeAnggota()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setAnggota(anggota);
            Buku buku = bukuDao.getBuku(formPeminjaman.getCboKodeBuku()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.insert(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Entri OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            peminjaman.setAnggota(
                    anggotaDao.getAnggota(formPeminjaman.getCboKodeAnggota().getSelectedItem().toString().split("-")[0]));
            peminjaman.setBuku(
                    bukuDao.getBuku(formPeminjaman.getCboKodeBuku().getSelectedItem().toString().split("-")[0]));
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.update(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Update OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            peminjamanDao.delete(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Delete OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPeminjaman(){
        try {
            String kodeanggota = formPeminjaman.getTblPeminjaman()
                    .getValueAt(formPeminjaman.getTblPeminjaman()
                            .getSelectedRow(), 0).toString();
            String kodebuku = formPeminjaman.getTblPeminjaman()
                    .getValueAt(formPeminjaman.getTblPeminjaman()
                            .getSelectedRow(), 2).toString();
            String tglpinjam = formPeminjaman.getTblPeminjaman()
                    .getValueAt(formPeminjaman.getTblPeminjaman()
                            .getSelectedRow(), 4).toString();
            
            peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            Anggota anggota = anggotaDao.getAnggota(peminjaman.getAnggota().getKodeanggota());
            formPeminjaman.getCboKodeAnggota()
                    .setSelectedItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
            
            Buku buku = bukuDao.getBuku(peminjaman.getBuku().getKodeBuku());
            formPeminjaman.getCboKodeBuku()
                    .setSelectedItem(buku.getKodeBuku()+"-"+buku.getJudulBuku());
            
            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tampil(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
            tabelModel.setRowCount(0);
            List<Peminjaman> list = peminjamanDao.getAll();
            for(Peminjaman p : list){
                Anggota anggota = anggotaDao.getAnggota(p.getAnggota().getKodeanggota());
                Buku buku = bukuDao.getBuku(p.getBuku().getKodeBuku());
                Object[] data = {
                    anggota.getKodeanggota(),
                    anggota.getNamaanggota(),
                    buku.getKodeBuku(),
                    buku.getJudulBuku(),
                    p.getTglpinjam(),
                    p.getTglkembali()
                };
                tabelModel.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
