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
    FormPeminjaman form;
    Peminjaman pinjam;
    PeminjamanDao pinjamDao;
    AnggotaDao agtDao;
    BukuDao bkDao;
    
    public PeminjamanController(FormPeminjaman form){
        try {
            this.form = form;
            pinjamDao = new PeminjamanDaoImpl(DbHelper.getConnection());
            agtDao = new AnggotaDaoImpl(DbHelper.getConnection());
            bkDao = new BukuDaoImpl(DbHelper.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void bersihform(){
        form.getTxtTglPinjam().setText(" ");
        form.getTxtTglKembali().setText(" ");
    }
    
    public void isiComboAnggota(){
        try {
            form.getCboKodeAnggota().removeAllItems();
            List<Anggota> list = agtDao.getAll();
            for(Anggota agt : list){
                form.getCboKodeAnggota().addItem(agt.getKodeanggota()+"-"+agt.getNamaanggota());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiComboBuku(){
        try {
            form.getCboKodeBuku().removeAllItems();
            List<Buku> list = bkDao.getAll();
            for(Buku bk: list){
                form.getCboKodeBuku().addItem(bk.getKodeBuku()+"-"+bk.getJudulBuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            pinjam = new Peminjaman();
            Anggota agt = agtDao.getAnggota(form.getCboKodeAnggota().getSelectedItem().toString().split("-")[0]);
            pinjam.setAnggota(agt);
            Buku bk = bkDao.getBuku(form.getCboKodeBuku().getSelectedItem().toString().split("-")[0]);
            pinjam.setBuku(bk);
            pinjam.setTglpinjam(form.getTxtTglPinjam().getText());
            pinjam.setTglkembali(form.getTxtTglKembali().getText());
            pinjamDao.insert(pinjam);
            JOptionPane.showMessageDialog(form, "Entri data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            pinjam.setAnggota( agtDao.getAnggota(form.getCboKodeAnggota().getSelectedItem().toString().split("-")[0]));
            pinjam.setBuku(bkDao.getBuku(form.getCboKodeBuku().getSelectedItem().toString().split("-")[0]));
            pinjam.setTglpinjam(form.getTxtTglPinjam().getText());
            pinjam.setTglkembali(form.getTxtTglKembali().getText());
            pinjamDao.update(pinjam);
            JOptionPane.showMessageDialog(form, "Update data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void delete(){
        try {
            pinjamDao.delete(pinjam);
            JOptionPane.showMessageDialog(form, "Delete OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPeminjaman(){
        try {
            String kodeanggota = form.getTblPeminjaman()
                    .getValueAt(form.getTblPeminjaman().getSelectedRow(), 0).toString();
            String kodebuku = form.getTblPeminjaman()
                    .getValueAt(form.getTblPeminjaman().getSelectedRow(), 2).toString();
            String tglpinjam = form.getTblPeminjaman()
                    .getValueAt(form.getTblPeminjaman().getSelectedRow(), 4).toString();
            
            pinjam = pinjamDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            Anggota agt= agtDao.getAnggota(pinjam.getAnggota().getKodeanggota());
            form.getCboKodeAnggota().setSelectedItem(agt.getKodeanggota()+"-"+agt.getNamaanggota());
            Buku bk= bkDao.getBuku(pinjam.getBuku().getKodeBuku());
            form.getCboKodeBuku().setSelectedItem(bk.getKodeBuku()+"-"+bk.getJudulBuku());
            form.getTxtTglPinjam().setText(pinjam.getTglpinjam());
            form.getTxtTglKembali().setText(pinjam.getTglkembali());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tableModel =(DefaultTableModel) form.getTblPeminjaman().getModel();
            tableModel.setRowCount(0);
            List<Peminjaman> list = pinjamDao.getAll();
            for(Peminjaman pinjam: list){
                Anggota agt= agtDao.getAnggota(pinjam.getAnggota().getKodeanggota());
                Buku bk = bkDao.getBuku(pinjam.getBuku().getKodeBuku());
                Object[] row = {
                    agt.getKodeanggota(),
                    agt.getNamaanggota(),
                    bk.getKodeBuku(),
                    bk.getJudulBuku(),
                    pinjam.getTglpinjam(),
                    pinjam.getTglkembali()
                        
                        
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
