/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FinalProject;
import FinalProject.ConnectionClass;
import FinalProject.ConnectionClass;
import FinalProject.NEUHomePage;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Veenadharini
 */
public class CurryMarketingHead extends javax.swing.JFrame {

    /**
     * Creates new form CurryMarketingHead
     */
    Connection con;
    public CurryMarketingHead() {
        initComponents();
        init();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void init() {
        try{
            con = ConnectionClass.getConnection();
            String sql = "Select * FROM coupon_table";
                       
            
            
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =pst.executeQuery();           
                    
            

            DefaultTableModel tbl1 = (DefaultTableModel) tblCoupon.getModel();
            tbl1.setRowCount(0);

            while(rs.next()){
                Object o1[] = {rs.getString("offer_name"), rs.getString("coupon_code"),rs.getString("flat_off"),rs.getString("min_amt"),rs.getString("offer_status")};
                tbl1.addRow(o1);
           
            }            
            
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        bttnCreateOffer = new javax.swing.JButton();
        bttnEnableOffer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BttnClear = new javax.swing.JButton();
        BttnDelMng = new javax.swing.JButton();
        bttnUpdateMng = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combMinAmt = new javax.swing.JComboBox<>();
        txtTitle = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        ComboStatus = new javax.swing.JComboBox<>();
        comboFlatoff = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCoupon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(133, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CURRY MARKETING");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 5, 400, 120));

        jButton13.setText("Logout");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 130));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttnCreateOffer.setBackground(new java.awt.Color(133, 0, 0));
        bttnCreateOffer.setForeground(new java.awt.Color(255, 255, 255));
        bttnCreateOffer.setText("Create an Offer");
        bttnCreateOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCreateOfferActionPerformed(evt);
            }
        });
        jPanel4.add(bttnCreateOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 180, 70));

        bttnEnableOffer.setBackground(new java.awt.Color(133, 0, 0));
        bttnEnableOffer.setForeground(new java.awt.Color(255, 255, 255));
        bttnEnableOffer.setText("Enable Offer");
        bttnEnableOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEnableOfferActionPerformed(evt);
            }
        });
        jPanel4.add(bttnEnableOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 180, 70));

        jButton1.setBackground(new java.awt.Color(133, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Disable Offer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 180, 70));

        BttnClear.setBackground(new java.awt.Color(133, 0, 0));
        BttnClear.setForeground(new java.awt.Color(255, 255, 255));
        BttnClear.setText("Clear all");
        BttnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnClearActionPerformed(evt);
            }
        });
        jPanel4.add(BttnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 20, 180, 70));

        BttnDelMng.setBackground(new java.awt.Color(133, 0, 0));
        BttnDelMng.setForeground(new java.awt.Color(255, 255, 255));
        BttnDelMng.setText("Delete Offer");
        BttnDelMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnDelMngActionPerformed(evt);
            }
        });
        jPanel4.add(BttnDelMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 20, 190, 70));

        bttnUpdateMng.setBackground(new java.awt.Color(133, 0, 0));
        bttnUpdateMng.setForeground(new java.awt.Color(255, 255, 255));
        bttnUpdateMng.setText("Update Offer");
        bttnUpdateMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnUpdateMngActionPerformed(evt);
            }
        });
        jPanel4.add(bttnUpdateMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 200, 70));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 960, 1920, 120));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Coupon Code:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Minimum Order amount:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Title for the Offer:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Offer Status:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Flat off amount:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        combMinAmt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Amount in $..", "10", "30", "50", "75", "100", " ", " " }));
        jPanel1.add(combMinAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 230, 30));
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 230, 30));
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 230, 30));

        ComboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status..", "Enabled", "Disabled" }));
        jPanel1.add(ComboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 230, 30));

        comboFlatoff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Amount in $..", "5", "10", "15", "20", "25", " " }));
        jPanel1.add(comboFlatoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 230, 30));

        tblCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Offer Title", "Coupon Code", "Flat off Amount", "Min Order Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCoupon.setGridColor(new java.awt.Color(133, 0, 0));
        tblCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCouponMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCoupon);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 270, 940, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        new NEUHomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String offertitle = txtTitle.getText();
        String coupon = txtCode.getText();
        int flatoff = Integer.parseInt(comboFlatoff.getSelectedItem().toString());
        int minamt = Integer.parseInt(combMinAmt.getSelectedItem().toString());
        String status = "Disabled";

        try{
            int selectedRowIndex = tblCoupon.getSelectedRow();
            if (selectedRowIndex<0){

                JOptionPane.showMessageDialog(this, "Please select a offer to disable");
                return;
            }
            else
            con = ConnectionClass.getConnection();
            String sql = "Update coupon_table SET offer_status='"+status+"' WHERE coupon_code='"+coupon+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Offer has been Disabled and is taken off from the Website");
            txtTitle.setText("");
            txtCode.setText("");
            comboFlatoff.setSelectedIndex(0);
            combMinAmt.setSelectedIndex(0);
            ComboStatus.setSelectedIndex(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bttnEnableOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEnableOfferActionPerformed
        String offertitle = txtTitle.getText();
        String coupon = txtCode.getText();
        int flatoff = Integer.parseInt(comboFlatoff.getSelectedItem().toString());
        int minamt = Integer.parseInt(combMinAmt.getSelectedItem().toString());
        String status = "Enabled";

        try{
            int selectedRowIndex = tblCoupon.getSelectedRow();
            if (selectedRowIndex<0){

                JOptionPane.showMessageDialog(this, "Please select a offer to enable");
                return;
            }
            else
            con = ConnectionClass.getConnection();
            String sql = "Update coupon_table SET offer_status='"+status+"' WHERE coupon_code='"+coupon+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Offer has been Enabled and is live on the Website");
            txtTitle.setText("");
            txtCode.setText("");
            comboFlatoff.setSelectedIndex(0);
            combMinAmt.setSelectedIndex(0);
            ComboStatus.setSelectedIndex(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_bttnEnableOfferActionPerformed

    private void bttnCreateOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCreateOfferActionPerformed
        String offertitle = txtTitle.getText();
        String coupon = txtCode.getText();
        int flatoff = Integer.parseInt(comboFlatoff.getSelectedItem().toString());
        int minamt = Integer.parseInt(combMinAmt.getSelectedItem().toString());
        String status = ComboStatus.getSelectedItem().toString();    
        
        try{
            
            
            con = ConnectionClass.getConnection();
            String sql = "Insert into coupon_table values(?,?,?,?,?)";//5
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, offertitle);
            pst.setString(2, coupon);
            pst.setInt(3, flatoff);
            pst.setInt(4, minamt);
            pst.setString(5, status);
            
            
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Coupon Code has been added successfully");
            txtTitle.setText("");
            txtCode.setText("");
            comboFlatoff.setSelectedIndex(0);
            combMinAmt.setSelectedIndex(0);
            ComboStatus.setSelectedIndex(0);
       
            //comboVendor.setSelectedIndex(0);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
                                          
    }//GEN-LAST:event_bttnCreateOfferActionPerformed

    private void tblCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCouponMouseClicked
       
        int selectedRowIndex = tblCoupon.getSelectedRow();
        
        if (selectedRowIndex<0){
            
            JOptionPane.showMessageDialog(this, "Please select a coupon to update");
            return;            
        }
        
        DefaultTableModel model = (DefaultTableModel)tblCoupon.getModel();
        
        txtTitle.setText((String)tblCoupon.getValueAt(selectedRowIndex, 0));
        txtCode.setText((String)tblCoupon.getValueAt(selectedRowIndex, 1));
        comboFlatoff.setSelectedItem(tblCoupon.getValueAt(selectedRowIndex, 2));
        combMinAmt.setSelectedItem(tblCoupon.getValueAt(selectedRowIndex, 3));
        ComboStatus.setSelectedItem(tblCoupon.getValueAt(selectedRowIndex, 4));
        
        
    }//GEN-LAST:event_tblCouponMouseClicked

    private void BttnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnClearActionPerformed
        txtTitle.setText("");
        txtCode.setText("");
        comboFlatoff.setSelectedIndex(0);
        combMinAmt.setSelectedIndex(0);
        ComboStatus.setSelectedIndex(0);       
    }//GEN-LAST:event_BttnClearActionPerformed

    private void BttnDelMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnDelMngActionPerformed
        String offertitle = txtTitle.getText();
        String coupon = txtCode.getText();
        int flatoff = Integer.parseInt(comboFlatoff.getSelectedItem().toString());
        int minamt = Integer.parseInt(combMinAmt.getSelectedItem().toString());
        String status = ComboStatus.getSelectedItem().toString();

        try{
            int selectedRowIndex = tblCoupon.getSelectedRow();
            if (selectedRowIndex<0){

                JOptionPane.showMessageDialog(this, "Please select an offer to delete");
                return;
            }
            else
            con = ConnectionClass.getConnection();
            String sql = "DELETE FROM coupon_table where coupon_code = '"+coupon+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Manager has been deleted successfully");
             txtTitle.setText("");
            txtCode.setText("");
            comboFlatoff.setSelectedIndex(0);
            combMinAmt.setSelectedIndex(0);
            ComboStatus.setSelectedIndex(0);

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_BttnDelMngActionPerformed

    private void bttnUpdateMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnUpdateMngActionPerformed
        String offertitle = txtTitle.getText();
        String coupon = txtCode.getText();
        int flatoff = Integer.parseInt(comboFlatoff.getSelectedItem().toString());
        int minamt = Integer.parseInt(combMinAmt.getSelectedItem().toString());
        String status = ComboStatus.getSelectedItem().toString();

        try{
            int selectedRowIndex = tblCoupon.getSelectedRow();
            if (selectedRowIndex<0){

                JOptionPane.showMessageDialog(this, "Please select a offer to update");
                return;
            }
            else
            con = ConnectionClass.getConnection();
            String sql = "Update coupon_table SET offer_name='"+offertitle+"', coupon_code='"+coupon+"',flat_off='"+flatoff+"',min_amt='"+minamt+"',offer_status='"+status+"' WHERE coupon_code='"+coupon+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Offer has been updated successfully");
            txtTitle.setText("");
            txtCode.setText("");
            comboFlatoff.setSelectedIndex(0);
            combMinAmt.setSelectedIndex(0);
            ComboStatus.setSelectedIndex(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_bttnUpdateMngActionPerformed

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
            java.util.logging.Logger.getLogger(CurryMarketingHead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurryMarketingHead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurryMarketingHead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurryMarketingHead.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurryMarketingHead().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnClear;
    private javax.swing.JButton BttnDelMng;
    private javax.swing.JComboBox<String> ComboStatus;
    private javax.swing.JButton bttnCreateOffer;
    private javax.swing.JButton bttnEnableOffer;
    private javax.swing.JButton bttnUpdateMng;
    private javax.swing.JComboBox<String> combMinAmt;
    private javax.swing.JComboBox<String> comboFlatoff;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCoupon;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    
}
