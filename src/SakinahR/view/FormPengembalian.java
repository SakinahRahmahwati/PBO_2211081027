/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SakinahR.view;

import SakinahR.controller.PengembalianController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP-PC
 */
public class FormPengembalian extends javax.swing.JFrame {

    /**
     * Creates new form FormPengembalian
     */
    private PengembalianController con;
    public FormPengembalian() throws Exception{ 
        initComponents();
        con = new PengembalianController(this);
        con.bersih();
        con.tampil();
    }

    public JButton getBtnKembalikan() {
        return btnKembalikan;
    }

    public JComboBox<String> getCboKodeAnggota() {
        return cboKodeAnggota;
    }

    public JComboBox<String> getCboKodeBuku() {
        return cboKodeBuku;
    }

    public JComboBox<String> getCboPilih() {
        return cboPilih;
    }

    public JTable getTblPengembalian() {
        return tblPengembalian;
    }

    public JTextField getTxtCari() {
        return txtCari;
    }

    public JTextField getTxtDenda() {
        return txtDenda;
    }

    public JTextField getTxtTerlambat() {
        return txtTerlambat;
    }

    public JTextField getTxtTglKembali() {
        return txtTglKembali;
    }

    public JTextField getTxtTglPinjam() {
        return txtTglPinjam;
    }

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        txtTglKembali = new javax.swing.JTextField();
        txtTerlambat = new javax.swing.JTextField();
        txtDenda = new javax.swing.JTextField();
        cboKodeAnggota = new javax.swing.JComboBox<>();
        cboKodeBuku = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengembalian = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        cboPilih = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        btnKembalikan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Kode Anggota");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 100, 16);

        jLabel2.setText("Kode Buku");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 50, 100, 16);

        jLabel3.setText("Tgl Pinjam");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 80, 100, 16);

        jLabel4.setText("Tgl Kembali");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 110, 100, 16);

        jLabel5.setText("Terlambat");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 140, 100, 16);

        jLabel6.setText("Denda");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 170, 100, 16);

        txtTglPinjam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTglPinjamFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTglPinjamFocusLost(evt);
            }
        });
        getContentPane().add(txtTglPinjam);
        txtTglPinjam.setBounds(130, 80, 250, 22);

        txtTglKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglKembaliActionPerformed(evt);
            }
        });
        txtTglKembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTglKembaliKeyReleased(evt);
            }
        });
        getContentPane().add(txtTglKembali);
        txtTglKembali.setBounds(130, 110, 250, 22);
        getContentPane().add(txtTerlambat);
        txtTerlambat.setBounds(130, 140, 250, 22);
        getContentPane().add(txtDenda);
        txtDenda.setBounds(130, 170, 250, 22);

        cboKodeAnggota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cboKodeAnggota);
        cboKodeAnggota.setBounds(130, 20, 250, 22);

        cboKodeBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cboKodeBuku);
        cboKodeBuku.setBounds(130, 50, 250, 22);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(130, 210, 72, 23);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(220, 210, 72, 23);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(310, 210, 72, 23);

        tblPengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Anggota", "Nama Anggota", "Kode buku", "Judul buku", "Tgl Pinjam", "Tgl Kembali", "Dikembalikan", "Terlambat", "Denda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPengembalian.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengembalianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPengembalian);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(400, 60, 830, 350);

        txtCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCariFocusLost(evt);
            }
        });
        getContentPane().add(txtCari);
        txtCari.setBounds(560, 20, 340, 30);

        cboPilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPilihActionPerformed(evt);
            }
        });
        getContentPane().add(cboPilih);
        cboPilih.setBounds(400, 20, 150, 30);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(910, 20, 72, 30);

        btnKembalikan.setText("Kembalikan");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembalikan);
        btnKembalikan.setBounds(400, 420, 100, 30);

        setSize(new java.awt.Dimension(1266, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPilihActionPerformed

    private void txtCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusGained
        // TODO add your handling code here:
        if(txtCari.getText().equals("masukkan kode anggota")){
            txtCari.setText("");
        }
    }//GEN-LAST:event_txtCariFocusGained

    private void txtCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusLost
        // TODO add your handling code here:
        if(txtCari.getText().equals("")){
            txtCari.setText("masukkan kode anggota");
        }
    }//GEN-LAST:event_txtCariFocusLost

    private void txtTglKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglKembaliActionPerformed

    private void txtTglKembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTglKembaliKeyReleased
        try {
            // TODO add your handling code here:
            con.tanggalDikembalikan();
        } catch (Exception ex) {
            Logger.getLogger(FormPengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTglKembaliKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        con.update();
        con.bersih();
        con.tampil();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        con.delete();
        con.bersih();
        con.tampil();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        con.bersih();
        con.tampil();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        con.Cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
        // TODO add your handling code here:
        con.insert();
        con.bersih();
        con.tampil();
    }//GEN-LAST:event_btnKembalikanActionPerformed

    private void tblPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengembalianMouseClicked
        // TODO add your handling code here:
        con.getPengembalian();
    }//GEN-LAST:event_tblPengembalianMouseClicked

    private void txtTglPinjamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTglPinjamFocusGained
        // TODO add your handling code here:
        if(txtTglPinjam.getText().equals("yyyy-mm-dd")){
            txtTglPinjam.setText("");
        }
    }//GEN-LAST:event_txtTglPinjamFocusGained

    private void txtTglPinjamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTglPinjamFocusLost
        // TODO add your handling code here:
        if(txtTglPinjam.getText().equals("")){
            txtTglPinjam.setText("yyyy-mm-dd");
        }
    }//GEN-LAST:event_txtTglPinjamFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormPengembalian().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FormPengembalian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboKodeAnggota;
    private javax.swing.JComboBox<String> cboKodeBuku;
    private javax.swing.JComboBox<String> cboPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPengembalian;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtTerlambat;
    private javax.swing.JTextField txtTglKembali;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}
