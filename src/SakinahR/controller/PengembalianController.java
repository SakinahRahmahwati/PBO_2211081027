/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.controller;

import SakinahR.dao.*;
import SakinahR.db.DbHelper;
import SakinahR.model.*;
import SakinahR.view.FormPengembalian;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP-PC
 */
public class PengembalianController {
   private FormPengembalian view;
   private AnggotaDao Adao;
   private BukuDao Bdao;
   private PengembalianDao pengembalianDao;
   private Pengembalian kembali;
   private Connection con;

    public PengembalianController (FormPengembalian view) throws Exception {
        this.view = view;
        con = DbHelper.getConnection();
        Adao = new AnggotaDaoImpl(con);
        Bdao = new BukuDaoImpl(con);
        pengembalianDao = new PengembalianDaoImpl(con);
        kembali = new Pengembalian();
    }
    
    public void bersih() {
        
       try {
           view.getBtnKembalikan().setEnabled(false);
           List<Anggota> alist = Adao.getAll();
           view.getCboKodeAnggota().removeAllItems();
           for(Anggota anggota : alist){
               view.getCboKodeAnggota().addItem(anggota.getKodeanggota());
           }
           view.getCboKodeAnggota().setSelectedIndex(0);
           
           List<Buku> blist = Bdao.getAll();
           view.getCboKodeBuku().removeAllItems();
           for(Buku buku  : blist){
               view.getCboKodeBuku().addItem(buku.getKodeBuku());
           }
           view.getCboKodeAnggota().setSelectedIndex(0);

           view.getTxtTglPinjam().setText("");
           view.getTxtTglKembali().setText("");
           view.getTxtCari().setText("");
           view.getTxtTerlambat().setText("");
           view.getTxtDenda().setText("");
       } catch (Exception ex) {
           Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
     public void insert() {
        try {
            kembali.setKodeAnggota(view.getCboKodeAnggota().getSelectedItem().toString());
            kembali.setKodebuku(view.getCboKodeBuku().getSelectedItem().toString());
            kembali.setTglpinjam(view.getTxtTglKembali().getText());
            kembali.setTglkembali(view.getTxtTglKembali().getText());
            kembali.setTerlambat(Integer.parseInt(view.getTxtTerlambat().getText()));
            kembali.setDenda(Double.parseDouble(view.getTxtDenda().getText()));
            pengembalianDao.insert(kembali);
            JOptionPane.showMessageDialog(view, "Berhasil Kembalikan Buku.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Tidak bisa melakukan pengembalian!", null, 0);
        }
    }
    
    public void update() {  
        try {
            kembali.setKodeAnggota(view.getCboKodeAnggota().getSelectedItem().toString());
            kembali.setKodebuku(view.getCboKodeBuku().getSelectedItem().toString());
            kembali.setTglpinjam(view.getTxtTglKembali().getText());
            kembali.setTglkembali(view.getTxtTglKembali().getText());
            kembali.setTerlambat(Integer.parseInt(view.getTxtTerlambat().getText()));
            kembali.setDenda(Double.parseDouble(view.getTxtDenda().getText()));
            pengembalianDao.insert(kembali);
            JOptionPane.showMessageDialog(view, "Berhasil Update Buku.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Tidak bisa melakukan pengembalian!", null, 0);
        }
    }
     public void delete() {
        try {
            kembali.setKodeAnggota(view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 0)
                    .toString());
            kembali.setKodebuku(view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 2)
                    .toString());
            kembali.setTglpinjam(view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 4)
                    .toString());
            pengembalianDao.delete(kembali);
            JOptionPane.showMessageDialog(view, "Data pengembalian dihapus!", null, 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
     public void get() {
        try {
            view.getBtnKembalikan().setEnabled(true);
            String tglPinjam = view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 4)
                    .toString();
            String tglkembali = view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 5)
                    .toString();
            view.getCboKodeAnggota()
                    .setSelectedItem(view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 0)
                            .toString());
            view.getCboKodeBuku()
                    .setSelectedItem(view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 2)
                            .toString());
            view.getTxtTglPinjam()
                    .setText(tglPinjam);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tglDikembalikan = format.format(new java.util.Date());
            view.getTxtTglKembali().setText(tglDikembalikan);
            int terlambat = pengembalianDao.selisihtgl(tglDikembalikan, tglkembali);
            kembali.setTerlambat(terlambat);
            view.getTxtTerlambat().setText("" + terlambat);
            view.getTxtDenda().setText((String.valueOf(kembali.getDenda())));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e, null, 0);
        }
    }
    
     public void tampil() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblPengembalian().getModel();
            tableModel.setRowCount(0);
            List<Pengembalian> List = pengembalianDao.getAll();
            for (Pengembalian kembali : List) {
                Object[] data = {
                        kembali.getKodeAnggota(),
                        kembali.getNamaAnggota(),
                        kembali.getKodebuku(),
                        kembali.getJudulBuku(),
                        kembali.getTglpinjam(),
                        kembali.getTglkembali(),
                        kembali.getDikembalikan(),
                        kembali.getTerlambat(),
                        kembali.getDenda()
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            // DO: handle exception
            JOptionPane.showMessageDialog(view, e);
        }
    }

    public void Cari() {
        try {
            String kode = view.getCboPilih().getSelectedItem().toString();
            String cari = view.getTxtCari().getText();
            DefaultTableModel tableModel = (DefaultTableModel) view.getTblPengembalian().getModel();
            tableModel.setRowCount(0);
            if(kode == "KodeAnggota" ){
                kode = "anggota.kodeAnggota";
            }else if (kode == "Kodebuku"){
                kode = "buku.Kodebuku";
            }else{
                kode = "anggota.namaAnggota";
            }
            List<Pengembalian> List = pengembalianDao.cari(kode, cari);
            if (List.isEmpty()) {
                if(kode == "anggota.kodeAnnggota"){
                JOptionPane.showMessageDialog(view, "Kode Anggota '" + cari + "' Tidak dapat ditemukan"); 
                }else if (kode == "buku.Kodebuku"){
                JOptionPane.showMessageDialog(view, "Kode Buku '" + cari + "' Tidak dapat ditemukan");   
                }else{
                JOptionPane.showMessageDialog(view, "Nama '" + cari + "' Tidak dapat ditemukan");   
                    
                }
            } else {
                for (Pengembalian kembali : List) {
                    Object[] data = {
                        kembali.getKodeAnggota(),
                        kembali.getNamaAnggota(),
                        kembali.getKodebuku(),
                        kembali.getJudulBuku(),
                        kembali.getTglpinjam(),
                        kembali.getTglkembali(),
                        kembali.getDikembalikan(),
                        kembali.getTerlambat(),
                        kembali.getDenda()
                    };
                    tableModel.addRow(data);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e, null, 0);
        }
    }

    public int tanggalDikembalikan() throws Exception {
        String tglDikembalikan = view.getTxtTglKembali().getText();
        String Tglkembali = view.getTblPengembalian().getValueAt(view.getTblPengembalian().getSelectedRow(), 5)
                .toString();
        int terlambat = pengembalianDao.selisihtgl(tglDikembalikan, Tglkembali);
        if(terlambat <= 0){
            terlambat = 0;
        }
        view.getTxtTerlambat().setText("" + terlambat);
        view.getTxtTglKembali().setText(tglDikembalikan);
        view.getTxtDenda().setText((String.valueOf(terlambat * 2000)));
        return terlambat;
    }
}
