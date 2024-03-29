/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FinalProject;
import FinalProject.ConnectionClass;
import FinalProject.ConnectionClass;
import FinalProject.ConnectionClass;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Veenadharini
 */
public class CurryAdminPage extends javax.swing.JFrame {

    /**
     * Creates new form CurryAdminPage
     */
    Connection con;
    public CurryAdminPage() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmng = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        txtpwd = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_PoptotalOrders = new javax.swing.JLabel();
        lblPopTotalRevenue = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BttnAddMng = new javax.swing.JButton();
        bttnUpdateMng = new javax.swing.JButton();
        BttnClear = new javax.swing.JButton();
        BttnDelMng = new javax.swing.JButton();
        txtvendor_Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblmng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vendor ID", "Username", "Password", "First Name", "Last Name", "Phone no.", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblmng.setSelectionBackground(new java.awt.Color(133, 0, 0));
        tblmng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmngMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmng);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 880, 402));

        jLabel2.setText("Vendor ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 410, 60, -1));

        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 460, -1, -1));

        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 510, -1, 20));

        jLabel5.setText("First Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, -1, -1));

        jLabel6.setText("Last Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 610, -1, -1));

        jLabel7.setText("Phone no:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 670, -1, -1));

        jLabel8.setText("Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 730, -1, -1));

        txtemail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 720, 240, -1));
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 460, 240, -1));
        jPanel1.add(txtpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 510, 240, -1));
        jPanel1.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 560, 240, -1));
        jPanel1.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 610, 240, -1));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 670, 240, -1));

        jPanel2.setBackground(new java.awt.Color(133, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CURRY ADMIN PAGE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 5, 400, 120));

        jButton13.setText("Logout");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 70, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 130));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(133, 0, 0), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Restaurant's Statistics:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel10.setText("Total No. of Orders:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        jLabel11.setText("Total Revenue:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        lbl_PoptotalOrders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_PoptotalOrders.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbl_PoptotalOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 120, 30));

        lblPopTotalRevenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPopTotalRevenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblPopTotalRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 120, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Popeye's");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 130, 480, 950));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BttnAddMng.setBackground(new java.awt.Color(133, 0, 0));
        BttnAddMng.setForeground(new java.awt.Color(255, 255, 255));
        BttnAddMng.setText("Add Manager");
        BttnAddMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnAddMngActionPerformed(evt);
            }
        });
        jPanel4.add(BttnAddMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 130, 60));

        bttnUpdateMng.setBackground(new java.awt.Color(133, 0, 0));
        bttnUpdateMng.setForeground(new java.awt.Color(255, 255, 255));
        bttnUpdateMng.setText("Update Manager");
        bttnUpdateMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnUpdateMngActionPerformed(evt);
            }
        });
        jPanel4.add(bttnUpdateMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 130, 60));

        BttnClear.setBackground(new java.awt.Color(133, 0, 0));
        BttnClear.setForeground(new java.awt.Color(255, 255, 255));
        BttnClear.setText("Clear all");
        BttnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnClearActionPerformed(evt);
            }
        });
        jPanel4.add(BttnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 130, 60));

        BttnDelMng.setBackground(new java.awt.Color(133, 0, 0));
        BttnDelMng.setForeground(new java.awt.Color(255, 255, 255));
        BttnDelMng.setText("Delete Manager");
        BttnDelMng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnDelMngActionPerformed(evt);
            }
        });
        jPanel4.add(BttnDelMng, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 980, 1440, 100));

        txtvendor_Id.setText("Popeye");
        jPanel1.add(txtvendor_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 400, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void init() {
        String pope = "popeye";
        int poptot;
        try{
            con = ConnectionClass.getConnection();
            String sql = "Select * FROM restaurant_manager";
            String sql1 ="Select * from orders where Vender_ID ='"+pope+"' ";
            String sql2 ="Select sum(total) as poprev from orders where Vender_ID ='"+pope+"'";
            
            
            
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst1 = con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            ResultSet rs =pst.executeQuery();           
            ResultSet rs1 =pst1.executeQuery();
            ResultSet rs2 =pst2.executeQuery();
            
            

            DefaultTableModel tbl1 = (DefaultTableModel) tblmng.getModel();
            tbl1.setRowCount(0);

            while(rs.next()){
                Object o1[] = {rs.getString("vendor_id"), rs.getString("username"),rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("phone_no"),rs.getString("email")};
                tbl1.addRow(o1);
           
            }
            rs1.last();
            poptot = rs1.getRow();
            String value = String.valueOf(poptot);
           
            
            lbl_PoptotalOrders.setText(value);
            
            if(rs2.next()){
                              String rev = rs2.getString("poprev");
                              DecimalFormat df = new DecimalFormat("#.##");
                              float frev = Float.valueOf(rev);
                              String srev = df.format(frev);
                              lblPopTotalRevenue.setText(srev);
            }
            
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    
    }
    
    private void tblmngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmngMouseClicked
       int selectedRowIndex = tblmng.getSelectedRow();
        
        if (selectedRowIndex<0){
            
            JOptionPane.showMessageDialog(this, "Please select a manager to update");
            return;            
        }
        
        DefaultTableModel model = (DefaultTableModel)tblmng.getModel();
        
        txtvendor_Id.setText((String)tblmng.getValueAt(selectedRowIndex, 0));
        txtuser.setText((String)tblmng.getValueAt(selectedRowIndex, 1));
        txtpwd.setText((String)tblmng.getValueAt(selectedRowIndex,2));
        txtfname.setText((String)tblmng.getValueAt(selectedRowIndex,3));
        txtlname.setText((String)tblmng.getValueAt(selectedRowIndex,4));
        txtPhone.setText((String)tblmng.getValueAt(selectedRowIndex,5));
        txtemail.setText((String)tblmng.getValueAt(selectedRowIndex,6));
    }//GEN-LAST:event_tblmngMouseClicked

    private void bttnUpdateMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnUpdateMngActionPerformed
        //validations
        
        String match = "";
        String match1 = "";
        String match2 = "";
        String match3 = "";
        String hosp =  "1";    
        try{
           con = ConnectionClass.getConnection();          
            String DocSql = ("select username from curry_admin where username = '"+txtuser.getText()+"' ");
            PreparedStatement DocPreparedStatement = con.prepareStatement(DocSql);            
            ResultSet commResultSet = DocPreparedStatement.executeQuery();
            while(commResultSet.next())
            {
            hosp = commResultSet.getString("username");
            }
 
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
       
        
        
       
        if(txtpwd.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Password Required");
        txtpwd.requestFocus();
        return;
        }
         else if(txtpwd.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"First Name Required");
        txtpwd.requestFocus();
        return;
        }
        
        else if(Pattern.matches("[a-zA-Z ]+", txtfname.getText())){
        match = "1";        
        }
           
        else if(match.equals("")){
        JOptionPane.showMessageDialog(null,"First Name Only In Alphabets");
        txtfname.requestFocus();
        return;
        }
        
        if(txtlname.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Last Name Required");
        txtlname.requestFocus();
        return;
        }
        
        if(Pattern.matches("[a-zA-Z ]+", txtlname.getText())){
        match3 = "1";        
        }
           
        if(match3.equals("")){
        JOptionPane.showMessageDialog(null,"Last Name Only In Alphabets");
        txtlname.requestFocus();
        return;
        }
        
        if(Pattern.matches("[0-9]{10}+", txtPhone.getText())){
        match2 = "1";        
        }      
        
        if(match2.equals("")){
        JOptionPane.showMessageDialog(null,"Make sure to enter valid number");
        txtPhone.requestFocus();
        return;
        }
        
        if (!(txtemail.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))) {
        JOptionPane.showMessageDialog(this, "Please enter valid Email");
        txtemail.requestFocus();
        return;
            }
        
        
        
        
        //----------------------------------------------------------------------
        
        
        
        String vendorid = txtvendor_Id.getText();
        String user = txtuser.getText();
        String pwd = txtpwd.getText();
        String fname = txtfname.getText();
        String lname = txtlname.getText();
        String phone = txtPhone.getText();
        String email = txtemail.getText();
                
        
        
        try{
            int selectedRowIndex = tblmng.getSelectedRow();
            if (selectedRowIndex<0){
            
            JOptionPane.showMessageDialog(this, "Please select a manager to update");
            return;            
        }
            else
            con = ConnectionClass.getConnection();
            String sql = "Update restaurant_manager SET username='"+user+"', password='"+pwd+"',first_name='"+fname+"',last_name='"+lname+"',phone_no='"+phone+"', email='"+email+"' WHERE username='"+user+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Manager has been updated successfully");
            txtuser.setText("");
            txtpwd.setText("");
            txtfname.setText("");
            txtlname.setText("");
            txtPhone.setText("");
            txtemail.setText("");
            txtvendor_Id.setText("");
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_bttnUpdateMngActionPerformed

    private void BttnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnClearActionPerformed
            txtuser.setText("");
            txtpwd.setText("");
            txtfname.setText("");
            txtlname.setText("");
            txtPhone.setText("");
            txtemail.setText("");
            txtvendor_Id.setText("");
    }//GEN-LAST:event_BttnClearActionPerformed

    private void BttnDelMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnDelMngActionPerformed
        String vendorid = txtvendor_Id.getText();
        String user = txtuser.getText();
        String pwd = txtpwd.getText();
        String fname = txtfname.getText();
        String lname = txtlname.getText();
        String phone = txtPhone.getText();
        String email = txtemail.getText();
                
        
        
        try{
            int selectedRowIndex = tblmng.getSelectedRow();
            if (selectedRowIndex<0){
            
            JOptionPane.showMessageDialog(this, "Please select a manager to delete");
            return;            
        }
            else
            con = ConnectionClass.getConnection();
            String sql = "DELETE FROM restaurant_manager where username = '"+user+"'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Manager has been deleted successfully");
            txtuser.setText("");
            txtpwd.setText("");
            txtfname.setText("");
            txtlname.setText("");
            txtPhone.setText("");
            txtemail.setText("");
            txtvendor_Id.setText("");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_BttnDelMngActionPerformed

    private void BttnAddMngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnAddMngActionPerformed
        //validations
        
        String match = "";
        String match1 = "";
        String match2 = "";
        String match3 = "";
        String hosp =  "1";    
        try{
           con = ConnectionClass.getConnection();          
            String DocSql = ("select username from curry_admin where username = '"+txtuser.getText()+"' ");
            PreparedStatement DocPreparedStatement = con.prepareStatement(DocSql);            
            ResultSet commResultSet = DocPreparedStatement.executeQuery();
            while(commResultSet.next())
            {
            hosp = commResultSet.getString("username");
            }
 
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
       
        if(hosp != "1" || txtuser.getText().equals(""))  {
        JOptionPane.showMessageDialog(null,"Exists in system or is blank, try another ID");
        txtuser.requestFocus();
        return;
        }
        
       
        else if(txtpwd.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Password Required");
        txtpwd.requestFocus();
        return;
        }
         else if(txtpwd.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"First Name Required");
        txtpwd.requestFocus();
        return;
        }
        
        else if(Pattern.matches("[a-zA-Z ]+", txtfname.getText())){
        match = "1";        
        }
           
        else if(match.equals("")){
        JOptionPane.showMessageDialog(null,"First Name Only In Alphabets");
        txtfname.requestFocus();
        return;
        }
        
        if(txtlname.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Last Name Required");
        txtlname.requestFocus();
        return;
        }
        
        if(Pattern.matches("[a-zA-Z ]+", txtlname.getText())){
        match3 = "1";        
        }
           
        if(match3.equals("")){
        JOptionPane.showMessageDialog(null,"Last Name Only In Alphabets");
        txtlname.requestFocus();
        return;
        }
        
        if(Pattern.matches("[0-9]{10}+", txtPhone.getText())){
        match2 = "1";        
        }      
        
        if(match2.equals("")){
        JOptionPane.showMessageDialog(null,"Make sure to enter valid number");
        txtPhone.requestFocus();
        return;
        }
        
        if (!(txtemail.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))) {
        JOptionPane.showMessageDialog(this, "Please enter valid Email");
        txtemail.requestFocus();
        return;
            }
        
        
        
        
        //----------------------------------------------------------------------
        String vendorid = txtvendor_Id.getText();
        String user = txtuser.getText();
        String pwd = txtpwd.getText();
        String fname = txtfname.getText();
        String lname = txtlname.getText();
        String phone = txtPhone.getText();
        String email = txtemail.getText();
                
        
        
        try{
            
            
            con = ConnectionClass.getConnection();
            String sql = "Insert into restaurant_manager values(?,?,?,?,?,?,?)";//7
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vendorid);
            pst.setString(2, user);
            pst.setString(3, pwd);
            pst.setString(4, fname);
            pst.setString(5, lname);
            pst.setString(6, phone);
            pst.setString(7, email);
            
            pst.execute();
            init();
            JOptionPane.showMessageDialog(null,"The Manager has been added successfully");
            txtuser.setText("");
            txtpwd.setText("");
            txtfname.setText("");
            txtlname.setText("");
            txtPhone.setText("");
            txtemail.setText("");
            //comboVendor.setSelectedIndex(0);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_BttnAddMngActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        new NEUHomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(CurryAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurryAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurryAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurryAdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurryAdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnAddMng;
    private javax.swing.JButton BttnClear;
    private javax.swing.JButton BttnDelMng;
    private javax.swing.JButton bttnUpdateMng;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPopTotalRevenue;
    private javax.swing.JLabel lbl_PoptotalOrders;
    private javax.swing.JTable tblmng;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpwd;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtvendor_Id;
    // End of variables declaration//GEN-END:variables

    
}
