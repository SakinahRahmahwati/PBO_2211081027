/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SakinahR.controller;
import SakinahR.model.*;
import SakinahR.view.*;
import SakinahR.dao.*;
import SakinahR.db.DbHelper;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP-PC
 */
public class AnggotaController {
    FormAnggota view;
    Anggota anggota;
    AnggotaDao dao;
    Connection connection; 
    
    public AnggotaController (FormAnggota view){
        try {
            this.view = view;
            Connection connection = DbHelper.getConnection();
            dao = new AnggotaDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        view.getTxtKodeAnggota().setText("");
        view.getTxtNamaAnggota().setText("");
        view.getTxtAlamat().setText("");
        view.getCboJenisKelamin().removeAllItems();
        view.getCboJenisKelamin().addItem("L");
        view.getCboJenisKelamin().addItem("P");
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabelModel  =(DefaultTableModel) 
                    view.getTabelAnggota().getModel();
            tabelModel.setRowCount(0);
            List<Anggota> list = dao.getAll();
            for(Anggota a : list){
                Object[] row = {
                    a.getKodeanggota(),
                    a.getNamaanggota(),
                    a.getAlamat(),
                    a.getJeniskelamin()
                };
                tabelModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void insert(){  
        try {
            anggota = new Anggota();
            anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(view.getTxtNamaAnggota().getText());
            anggota.setAlamat(view.getTxtAlamat().getText());
            anggota.setJeniskelamin(view.getCboJenisKelamin().getSelectedItem().toString());
            dao.insert(anggota);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(anggota);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tabelKlik(){
        try {
            String kodeanggota = view.getTabelAnggota()
                    .getValueAt(view.getTabelAnggota().getSelectedRow(), 0).toString();
            anggota = dao.getAnggota(kodeanggota);
            view.getTxtKodeAnggota().setText(anggota.getKodeanggota());
            view.getTxtNamaAnggota().setText(anggota.getNamaanggota());
            view.getTxtAlamat().setText(anggota.getAlamat());
            view.getCboJenisKelamin().setSelectedItem(anggota.getJeniskelamin());
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){  
        try {
            anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(view.getTxtNamaAnggota().getText());
            anggota.setAlamat(view.getTxtAlamat().getText());
            anggota.setJeniskelamin(view.getCboJenisKelamin().getSelectedItem().toString());
            dao.update(anggota);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
