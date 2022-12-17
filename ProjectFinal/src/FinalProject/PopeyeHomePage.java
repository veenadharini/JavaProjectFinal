/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FinalProject;

import FinalProject.ConnectionClass;
import FinalProject.ConnectionClass;
import FinalProject.ConnectionClass;
import FinalProject.FacultyHomePage;
import FinalProject.NEUHomePage;
import FinalProject.StudentHomePage;
import FinalProject.StudentLoginPage;
import FinalProject.StudentOrderPaymentPage;
import FinalProject.StudentOrdersPage;
import FinalProject.StudentProfilePage;
import java.awt.Image;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Veenadharini
 */
public class PopeyeHomePage extends javax.swing.JFrame {

    /**
     * Creates new form PopeyeHomePage
     */
    Connection con;
    public PopeyeHomePage() {
        initComponents();
        init();
        
        
    }
    public void init(){
        setTime();  
        
        String status="";
        String offer ="Enabled";
        String title="";
        int flatoff = 0;
        int minamt =0;
        String code ="";
        try{
                con = ConnectionClass.getConnection();
                String sql = ("Select * from coupon_table where offer_status = '"+offer+"' ");
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet c = ps.executeQuery(); 
                while(c.next())
                 {
                    status = c.getString("offer_status");
                    title = c.getString("offer_name");
                    code = c.getString("coupon_code");
                    flatoff = c.getInt("flat_off");
                    minamt =c.getInt("min_amt");
                    
                    
                }
                
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        
        if(status.equals("Enabled")){
          lbl_couponshow.setVisible(true);
          lblOfferTitle.setText(title);
          lblFlatoff.setText(String.valueOf(flatoff));
          lblcouponcode.setText(code);
          lblmin.setVisible(false);
          lblmin.setText(String.valueOf(minamt));
          lblOfferTitle.setVisible(true);
          lblFlat.setVisible(true);
          lblFlatoff.setVisible(true);
          lblDollarsOff.setVisible(true);
          lblUseCode.setVisible(true);
          lblcouponcode.setVisible(true);
        }
        else if (status.equals("Disabled")|| status.equals("")){
          jPanel30.setVisible(false);
          jPanel31.setVisible(false);
          lbl_couponshow.setVisible(false);
          lblOfferTitle.setVisible(false);
          lblFlat.setVisible(false);
          lblFlatoff.setVisible(false);
          lblDollarsOff.setVisible(false);
          lblUseCode.setVisible(false);
          lblcouponcode.setVisible(false);
          lblmin.setVisible(false);
        }
    }
    
    
    public void getTotal()
    {
        float subtotal = 0;
        float tax = 0;
        float total = 0;
        float coupon = Float.parseFloat(lblFlatoff.getText().toString());
        //String sb;
        float sb1;
        float tx1;
        float tot1;
        for(int n = 0; n<tblDishTable.getRowCount(); n++)
        {
            subtotal = subtotal +Float.parseFloat(tblDishTable.getValueAt(n, 3).toString());
            
        }
       // sb = String.format("%.2f",subtotal);
        tax = 0.065f*subtotal;
        
        total = subtotal + tax;
        
        DecimalFormat df = new DecimalFormat("#.##");
        String sb = df.format(subtotal);
        String tx = df.format(tax);
        String tot = df.format(total);
        sb1 = Float.parseFloat(sb);
        tx1 = Float.parseFloat(tx);
        tot1 = Float.parseFloat(tot);
        //sb1 = String.(sb);
        txtSubTotal.setText("$"+Float.toString(sb1));
        
        txtTaxes.setText("$"+Float.toString(tx1));
        
        txtTotal.setText("$"+Float.toString(tot1));
        
        lbl_subt.setVisible(false);
        lbl_tax.setVisible(false);
        lbl_tot.setVisible(false);
        lbl_subt.setText(Float.toString(sb1));
        lbl_tax.setText(Float.toString(tx1));
        lbl_tot.setText(Float.toString(tot1));
        
        
        if (txtCoupon.getText().equals(lblcouponcode.getText())&& subtotal>Integer.parseInt((lblmin.getText()))){
          total = subtotal + tax - coupon;
          System.out.println(total);
          tot = df.format(total);
          tot1 = Float.parseFloat(tot);
          txtTotal.setText("$"+Float.toString(tot1));
          lbl_tot.setText(Float.toString(tot1));
        }
        else if(txtCoupon.getText().equals("")){
            
        }
        else if (txtCoupon.getText().equals(lblcouponcode.getText())&& subtotal<Integer.parseInt((lblmin.getText()))){
         JOptionPane.showMessageDialog(null,"Coupon cannot be applied for order total less than '"+lblmin.getText()+"'. Please add more items");
        }
        else {
            JOptionPane.showMessageDialog(null, "Coupon isn't valid");
        }
        
        
        
        
    }
    
   
    public void popeye(){
        
        
    }
    
    public void reset(){
        
        qty_1.setValue(1);
        qty_2.setValue(1);
        qty_4.setValue(1);
        qty_9.setValue(1);
        qty_3.setValue(1);
        qty_6.setValue(1);
        qty_5.setValue(1);
        qty_7.setValue(1);
        qty_8.setValue(1);
        qty_10.setValue(1);
        qty_13.setValue(1);
        qty_14.setValue(1);
        qty_15.setValue(1);
        qty_16.setValue(1);
        qty_17.setValue(1);
        qty_20.setValue(1);
        qty_21.setValue(1);
        qty_11.setValue(1);
        qty_12.setValue(1);
        qty_18.setValue(1);
        qty_19.setValue(1);
        txtSubTotal.setText("0.0");
        txtTotal.setText("0.0");
        txtTaxes.setText("0.0");
        txtCoupon.setText("");
        cb_9.setSelected(false);
        cb_7.setSelected(false);
        cb_8.setSelected(false);
        cb_10.setSelected(false);
        cb_13.setSelected(false);
        cb_14.setSelected(false);
        cb_15.setSelected(false);
        cb_16.setSelected(false);
        cb_17.setSelected(false);
        cb_20.setSelected(false);
        cb_21.setSelected(false);
        cb_11.setSelected(false);
        cb_12.setSelected(false);
        cb_18.setSelected(false);
        cb_19.setSelected(false);
        cb_1.setSelected(false);
        cb_2.setSelected(false);
        cb_3.setSelected(false);
        cb_4.setSelected(false);
        cb_5.setSelected(false);
        cb_6.setSelected(false);
        
        DefaultTableModel dm = (DefaultTableModel) tblDishTable.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
           dm.removeRow(i);
        }
               
        
        try{
              
            con = ConnectionClass.getConnection();            
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            String sql2 = "ALTER TABLE cart_table AUTO_INCREMENT = 1";
            String sql3 = "DELETE FROM cart_table";        
            st1.executeUpdate(sql3);
            st.execute(sql2);
            
          
            }       
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }         
    }
    
    public void setTime(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                while (true){
                    try{
                    Thread.sleep(250);
                    }
                    catch(InterruptedException ex){
                    }
                    java.util.Date date = new java.util.Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, MM-dd-yyyy");
                    String time = tf.format(date);
                    lblTime.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                    lblDate.setText(df.format(date));
                    
                }
            }
        }).start();
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
        jLabel1 = new javax.swing.JLabel();
        BackBttn = new javax.swing.JButton();
        navigate = new javax.swing.JComboBox<>();
        Popeye = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        qty_1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        cb_1 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        qty_4 = new javax.swing.JSpinner();
        jLabel155 = new javax.swing.JLabel();
        cb_4 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_name_2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_price_2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        qty_2 = new javax.swing.JSpinner();
        jLabel154 = new javax.swing.JLabel();
        cb_2 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        qty_5 = new javax.swing.JSpinner();
        lbl_5 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        cb_5 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        qty_3 = new javax.swing.JSpinner();
        jLabel153 = new javax.swing.JLabel();
        cb_3 = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        qty_6 = new javax.swing.JSpinner();
        jLabel156 = new javax.swing.JLabel();
        cb_6 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lbl_9 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        qty_9 = new javax.swing.JSpinner();
        cb_9 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lbl_7 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        qty_7 = new javax.swing.JSpinner();
        cb_7 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_8 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        qty_8 = new javax.swing.JSpinner();
        cb_8 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        lbl_10 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        qty_10 = new javax.swing.JSpinner();
        cb_10 = new javax.swing.JCheckBox();
        jPanel25 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        qty_11 = new javax.swing.JSpinner();
        lbl_11 = new javax.swing.JLabel();
        cb_11 = new javax.swing.JCheckBox();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        qty_12 = new javax.swing.JSpinner();
        cb_12 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lbl_13 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        qty_13 = new javax.swing.JSpinner();
        cb_13 = new javax.swing.JCheckBox();
        jLabel78 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lbl_14 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        qty_14 = new javax.swing.JSpinner();
        cb_14 = new javax.swing.JCheckBox();
        jLabel85 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        qty_15 = new javax.swing.JSpinner();
        cb_15 = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        lbl_16 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        qty_16 = new javax.swing.JSpinner();
        cb_16 = new javax.swing.JCheckBox();
        jLabel99 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        qty_17 = new javax.swing.JSpinner();
        cb_17 = new javax.swing.JCheckBox();
        jPanel27 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        qty_18 = new javax.swing.JSpinner();
        lbl_18 = new javax.swing.JLabel();
        cb_18 = new javax.swing.JCheckBox();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        lbl_19 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        qty_19 = new javax.swing.JSpinner();
        cb_19 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        lbl_20 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        qty_20 = new javax.swing.JSpinner();
        cb_20 = new javax.swing.JCheckBox();
        jLabel113 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        lbl_21 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        qty_21 = new javax.swing.JSpinner();
        cb_21 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtTaxes = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDishTable = new javax.swing.JTable();
        ResetBttn = new javax.swing.JButton();
        OrderBttn = new javax.swing.JButton();
        lbl_subt = new javax.swing.JLabel();
        lbl_tax = new javax.swing.JLabel();
        lbl_tot = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        lblOfferTitle = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        lblFlatoff = new javax.swing.JLabel();
        lblcouponcode = new javax.swing.JLabel();
        lblFlat = new javax.swing.JLabel();
        lblDollarsOff = new javax.swing.JLabel();
        lblUseCode = new javax.swing.JLabel();
        lbl_couponshow = new javax.swing.JLabel();
        txtCoupon = new javax.swing.JTextField();
        lblmin = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        AddCartBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popoyes.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 0, 360, 100));

        BackBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back button.jpeg"))); // NOI18N
        BackBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBttnActionPerformed(evt);
            }
        });
        jPanel1.add(BackBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 40));

        navigate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        navigate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Account", "Back To Home Page", "My Profile", "Order Page", "Logout" }));
        navigate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navigateMouseClicked(evt);
            }
        });
        navigate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateActionPerformed(evt);
            }
        });
        jPanel1.add(navigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 30, 160, 40));

        Popeye.setText("Popeye");
        Popeye.setMaximumSize(new java.awt.Dimension(0, 0));
        Popeye.setMinimumSize(new java.awt.Dimension(0, 0));
        Popeye.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.add(Popeye, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 100));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 153, 0));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel8.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel8.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel15.setText("2Pc Signature Chicken Combo");

        jLabel11.setText("Name:");

        jLabel12.setText("Price:");

        jLabel16.setText("$11.49");

        jLabel13.setText("Quantity:");

        qty_1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2Pc Signature Chicken Combo.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel152.setText("Purchase:");

        cb_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel152)
                        .addGap(18, 18, 18)
                        .addComponent(cb_1)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(qty_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel152)
                    .addComponent(cb_1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 300, 320));

        jPanel9.setBackground(new java.awt.Color(255, 153, 51));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 320));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3Pc Signature Chicken Combo.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_4.setText("3Pc Signature Chicken Combo");

        jLabel18.setText("Name:");

        jLabel19.setText("Price:");

        jLabel20.setText("$12.64");

        jLabel21.setText("Quantity:");

        qty_4.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel155.setText("Purchase:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_4))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel20))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addGap(18, 18, 18)
                        .addComponent(cb_4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(lbl_4))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(qty_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(cb_4))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 153, 0));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4Pc Signature Chicken Combo.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_name_2.setText("4Pc Signature Chicken Combo");

        jLabel24.setText("Name:");

        jLabel25.setText("Price:");

        lbl_price_2.setText("$13.79");

        jLabel27.setText("Quantity:");

        qty_2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel154.setText("Purchase:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_name_2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_price_2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel154)
                        .addGap(18, 18, 18)
                        .addComponent(cb_2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(lbl_name_2))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(lbl_price_2))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(qty_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel154)
                    .addComponent(cb_2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 290, 320));

        jPanel11.setBackground(new java.awt.Color(255, 153, 0));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Classic Chicken Sandwich Combo.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel51.setText("Quantity:");

        jLabel50.setText("$10.91");

        qty_5.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        lbl_5.setText("Classic Chicken Sandwich Combo");

        jLabel48.setText("Name:");

        jLabel49.setText("Price:");

        jLabel157.setText("Purchase:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel50))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel157)
                        .addGap(18, 18, 18)
                        .addComponent(cb_5))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_5)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(lbl_5))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(qty_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel157)
                    .addComponent(cb_5))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 290, 320));

        jPanel12.setBackground(new java.awt.Color(255, 153, 0));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spicy Chicken Sandwich Combo.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_3.setText("Spicy Chicken Sandwich Combo");

        jLabel36.setText("Name:");

        jLabel37.setText("Price:");

        jLabel38.setText("$10.91");

        jLabel39.setText("Quantity:");

        qty_3.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel153.setText("Purchase:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel38))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel153))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_3))
                            .addComponent(qty_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(lbl_3))
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addGap(6, 6, 6)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(qty_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153)
                    .addComponent(cb_3))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 290, 320));

        jPanel13.setBackground(new java.awt.Color(255, 153, 0));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/24Pc Nuggets.jpg"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_6.setText("24 piece Nugget Combo");

        jLabel42.setText("Name:");

        jLabel43.setText("Price:");

        jLabel44.setText("$14.94");

        jLabel45.setText("Quantity:");

        qty_6.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel156.setText("Purchase:");

        cb_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_6))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel156)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_6))
                            .addComponent(qty_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(lbl_6))
                .addGap(6, 6, 6)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(6, 6, 6)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel156))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(qty_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_6)))
                .addGap(50, 50, 50))
        );

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 490, 290, 320));

        jTabbedPane1.addTab("COMBOS", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 153, 0));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel14.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel14.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_9.setText("8Pc Nuggets");

        jLabel30.setText("Name:");

        jLabel31.setText("Price:");

        jLabel32.setText("$11.26");

        jLabel33.setText("Quantity:");

        jLabel34.setText("Purchase:");

        qty_9.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/8Pc Nuggets.jpg"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_9))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel32))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(11, 11, 11)
                        .addComponent(cb_9)))
                .addContainerGap(147, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(lbl_9))
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(qty_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(cb_9))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 290, 320));

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel15.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel15.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_7.setText("Cajun Fries");

        jLabel54.setText("Name:");

        jLabel55.setText("Price:");

        jLabel56.setText("$4.00");

        jLabel57.setText("Quantity:");

        jLabel58.setText("Purchase:");

        qty_7.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cajun Fries.jpg"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_7))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel56))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(11, 11, 11)
                        .addComponent(cb_7)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(lbl_7))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(qty_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(cb_7))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 300, 320));

        jPanel16.setBackground(new java.awt.Color(255, 153, 0));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Biscuits.jpg"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_8.setText("Biscuits");

        jLabel60.setText("Name:");

        jLabel61.setText("Price:");

        jLabel62.setText("$1.69");

        jLabel63.setText("Quantity:");

        jLabel64.setText("Purchase:");

        qty_8.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_8))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel62))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(11, 11, 11)
                        .addComponent(cb_8)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(lbl_8))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(qty_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(cb_8))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 290, 320));

        jPanel17.setBackground(new java.awt.Color(255, 153, 51));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel17.setPreferredSize(new java.awt.Dimension(300, 320));

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/12Pc Nuggets.jpg"))); // NOI18N
        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_10.setText("12Pc Nuggets");

        jLabel67.setText("Name:");

        jLabel68.setText("Price:");

        jLabel69.setText("$12.98");

        jLabel70.setText("Quantity:");

        jLabel71.setText("Purchase:");

        qty_10.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_10))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel69))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addGap(11, 11, 11)
                        .addComponent(cb_10)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(lbl_10))
                .addGap(6, 6, 6)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addGap(6, 6, 6)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(qty_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(cb_10))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jPanel25.setBackground(new java.awt.Color(255, 153, 0));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HomeStyle Mac&Cheese.jpg"))); // NOI18N
        jLabel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel122.setText("Quantity:");

        jLabel123.setText("Purchase:");

        jLabel124.setText("$4.50");

        qty_11.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        lbl_11.setText("HomeStyle Mac & Cheese");

        jLabel126.setText("Name:");

        jLabel127.setText("Price:");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_11))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel124))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addGap(11, 11, 11)
                        .addComponent(cb_11)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel126)
                    .addComponent(lbl_11))
                .addGap(6, 6, 6)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127)
                    .addComponent(jLabel124))
                .addGap(6, 6, 6)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122)
                    .addComponent(qty_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(cb_11))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 290, 320));

        jPanel26.setBackground(new java.awt.Color(255, 153, 0));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Coleslaw.jpg"))); // NOI18N
        jLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_12.setText("Coleslaw");

        jLabel130.setText("Name:");

        jLabel131.setText("Price:");

        jLabel132.setText("$4.00");

        jLabel133.setText("Quantity:");

        jLabel134.setText("Purchase:");

        qty_12.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_12))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addGap(11, 11, 11)
                        .addComponent(cb_12)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130)
                    .addComponent(lbl_12))
                .addGap(6, 6, 6)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel131)
                    .addComponent(jLabel132))
                .addGap(6, 6, 6)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133)
                    .addComponent(qty_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel134)
                    .addComponent(cb_12))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 290, 320));

        jTabbedPane1.addTab("SIDES", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(255, 153, 0));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel18.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel18.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_13.setText("Cinnamon Apple pie");

        jLabel73.setText("Name:");

        jLabel74.setText("Price:");

        jLabel75.setText("$1.95");

        jLabel76.setText("Quantity:");

        jLabel77.setText("Purchase:");

        qty_13.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cinnamon Apple Pie.jpg"))); // NOI18N
        jLabel78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_13))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel75))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(11, 11, 11)
                        .addComponent(cb_13)))
                .addContainerGap(105, Short.MAX_VALUE))
            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(lbl_13))
                .addGap(6, 6, 6)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(jLabel75))
                .addGap(6, 6, 6)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76)
                    .addComponent(qty_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(cb_13))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 300, 320));

        jTabbedPane1.addTab("DESSERTS", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 153, 0));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel19.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel19.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_14.setText("Coca Cola");

        jLabel80.setText("Name:");

        jLabel81.setText("Price:");

        jLabel82.setText("$2.86");

        jLabel83.setText("Quantity:");

        jLabel84.setText("Purchase:");

        qty_14.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Coca Cola.jpg"))); // NOI18N
        jLabel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_14))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel82))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addGap(11, 11, 11)
                        .addComponent(cb_14)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(lbl_14))
                .addGap(6, 6, 6)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addGap(6, 6, 6)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(qty_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84)
                    .addComponent(cb_14))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 300, 320));

        jPanel20.setBackground(new java.awt.Color(255, 153, 0));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diet Coke.jpg"))); // NOI18N
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_15.setText("Diet Coke");

        jLabel88.setText("Name:");

        jLabel89.setText("Price:");

        jLabel90.setText("$2.86");

        jLabel91.setText("Quantity:");

        jLabel92.setText("Purchase:");

        qty_15.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_15))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel90))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addGap(11, 11, 11)
                        .addComponent(cb_15)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88)
                    .addComponent(lbl_15))
                .addGap(6, 6, 6)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90))
                .addGap(6, 6, 6)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addComponent(qty_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(cb_15))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 290, 330));

        jPanel21.setBackground(new java.awt.Color(255, 153, 0));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel21.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel21.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_16.setText("Dr Pepper");

        jLabel94.setText("Name:");

        jLabel95.setText("Price:");

        jLabel96.setText("$2.86");

        jLabel97.setText("Quantity:");

        jLabel98.setText("Purchase:");

        qty_16.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dr Pepper.jpg"))); // NOI18N
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_16))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel96))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(11, 11, 11)
                        .addComponent(cb_16)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94)
                    .addComponent(lbl_16))
                .addGap(6, 6, 6)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jLabel96))
                .addGap(6, 6, 6)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97)
                    .addComponent(qty_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98)
                    .addComponent(cb_16))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 300, 320));

        jPanel22.setBackground(new java.awt.Color(255, 153, 51));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel22.setPreferredSize(new java.awt.Dimension(300, 320));

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fanta.jpg"))); // NOI18N
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_17.setText("Fanta Orange");

        jLabel102.setText("Name:");

        jLabel103.setText("Price:");

        jLabel104.setText("$2.86");

        jLabel105.setText("Quantity:");

        jLabel106.setText("Purchase:");

        qty_17.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_17))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel104))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addGap(11, 11, 11)
                        .addComponent(cb_17)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel102)
                    .addComponent(lbl_17))
                .addGap(6, 6, 6)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addComponent(jLabel104))
                .addGap(6, 6, 6)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105)
                    .addComponent(qty_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addComponent(cb_17))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jPanel27.setBackground(new java.awt.Color(255, 153, 0));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hawaiian Punch.jpg"))); // NOI18N
        jLabel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel136.setText("Quantity:");

        jLabel137.setText("Purchase:");

        jLabel138.setText("$2.86");

        qty_18.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        lbl_18.setText("Hawaiian Punch");

        jLabel140.setText("Name:");

        jLabel141.setText("Price:");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_18))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel138))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addGap(11, 11, 11)
                        .addComponent(cb_18)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140)
                    .addComponent(lbl_18))
                .addGap(6, 6, 6)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel141)
                    .addComponent(jLabel138))
                .addGap(6, 6, 6)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel136)
                    .addComponent(qty_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137)
                    .addComponent(cb_18))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 290, 320));

        jPanel28.setBackground(new java.awt.Color(255, 153, 0));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minute Maid Lemonade.jpg"))); // NOI18N
        jLabel142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_19.setText("Minute Maid Lemonade");

        jLabel144.setText("Name:");

        jLabel145.setText("Price:");

        jLabel146.setText("$2.86");

        jLabel147.setText("Quantity:");

        jLabel148.setText("Purchase:");

        qty_19.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_19))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addGap(11, 11, 11)
                        .addComponent(cb_19)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel144)
                    .addComponent(lbl_19))
                .addGap(6, 6, 6)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel145)
                    .addComponent(jLabel146))
                .addGap(6, 6, 6)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel147)
                    .addComponent(qty_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel148)
                    .addComponent(cb_19))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 290, 320));

        jTabbedPane1.addTab("BEVERAGES", jPanel7);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 153, 0));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel23.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel23.setMinimumSize(new java.awt.Dimension(300, 300));

        lbl_20.setText("Spicy Chicken Sandwich");

        jLabel108.setText("Name:");

        jLabel109.setText("Price:");

        jLabel110.setText("$5.19");

        jLabel111.setText("Quantity:");

        jLabel112.setText("Purchase:");

        qty_20.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Spicy Chicken Sandwich.jpg"))); // NOI18N
        jLabel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_20))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel110))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addGap(11, 11, 11)
                        .addComponent(cb_20)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel108)
                    .addComponent(lbl_20))
                .addGap(6, 6, 6)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel109)
                    .addComponent(jLabel110))
                .addGap(6, 6, 6)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addComponent(qty_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel112)
                    .addComponent(cb_20))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 300, 320));

        jPanel24.setBackground(new java.awt.Color(255, 153, 0));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Classic Chicken Sandwich.jpg"))); // NOI18N
        jLabel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_21.setText("Classic Chicken Sandwich");

        jLabel116.setText("Name:");

        jLabel117.setText("Price:");

        jLabel118.setText("$5.19");

        jLabel119.setText("Quantity:");

        jLabel120.setText("Purchase:");

        qty_21.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_21))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel118))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(qty_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel120)
                        .addGap(11, 11, 11)
                        .addComponent(cb_21)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel116)
                    .addComponent(lbl_21))
                .addGap(6, 6, 6)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel117)
                    .addComponent(jLabel118))
                .addGap(6, 6, 6)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel119)
                    .addComponent(qty_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addComponent(cb_21))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 290, 320));

        jTabbedPane1.addTab("SANDWICHES", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1340, 900));

        jPanel2.setBackground(new java.awt.Color(255, 197, 112));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0.0");
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 110, 30));

        txtSubTotal.setEditable(false);
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal.setText("0.0");
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });
        jPanel2.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 110, 30));

        txtTaxes.setEditable(false);
        txtTaxes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTaxes.setText("0.0");
        jPanel2.add(txtTaxes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 110, 30));

        jLabel149.setText("Taxes:");
        jPanel2.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel150.setText("SubTotal:");
        jPanel2.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        jLabel151.setText("Total:");
        jPanel2.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, -1, -1));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 200, 40));

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 120, 40));

        tblDishTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sr no.", "Dish", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDishTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 270));

        ResetBttn.setText("Empty Cart");
        ResetBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttnActionPerformed(evt);
            }
        });
        jPanel2.add(ResetBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 120, 40));

        OrderBttn.setText("ORDER");
        OrderBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderBttnActionPerformed(evt);
            }
        });
        jPanel2.add(OrderBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 120, 40));
        jPanel2.add(lbl_subt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, -1, -1));
        jPanel2.add(lbl_tax, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, -1, -1));
        jPanel2.add(lbl_tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 630, -1, -1));

        jLabel14.setText("Coupon:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jPanel30.setBackground(new java.awt.Color(255, 226, 198));

        lblOfferTitle.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        lblOfferTitle.setForeground(new java.awt.Color(153, 0, 51));
        lblOfferTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOfferTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOfferTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, 360, 70));

        jPanel31.setBackground(new java.awt.Color(255, 232, 209));

        lblFlatoff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFlatoff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblcouponcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblcouponcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblFlat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFlat.setText("FLAT");

        lblDollarsOff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDollarsOff.setText("DOLLARS OFF!!");

        lblUseCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUseCode.setText("USE CODE");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFlat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFlatoff, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDollarsOff)
                .addGap(127, 127, 127))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(lblUseCode)
                .addGap(18, 18, 18)
                .addComponent(lblcouponcode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDollarsOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFlatoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblFlat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcouponcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUseCode)))
        );

        jPanel2.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, 470, 60));

        lbl_couponshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/popeye_offer - Copy.png"))); // NOI18N
        lbl_couponshow.setText("Hello");
        jPanel2.add(lbl_couponshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 470, 280));

        txtCoupon.setEditable(false);
        txtCoupon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 110, 30));
        jPanel2.add(lblmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 940, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 100, 580, 980));

        jPanel29.setBackground(new java.awt.Color(255, 236, 209));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddCartBttn.setText("Add to cart");
        AddCartBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartBttnActionPerformed(evt);
            }
        });
        jPanel29.add(AddCartBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, 120, 40));

        getContentPane().add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1000, 1340, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBttnActionPerformed
       StudentOrdersPage ord = new StudentOrdersPage();
       ord.setVisible(true);
       dispose();
       reset();
    }//GEN-LAST:event_BackBttnActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void cb_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_6ActionPerformed

    private void ResetBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttnActionPerformed
        reset();
    }//GEN-LAST:event_ResetBttnActionPerformed

    private void cb_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_1ActionPerformed
        popeye();
    }//GEN-LAST:event_cb_1ActionPerformed

    private void AddCartBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartBttnActionPerformed
        int qty1 = Integer.parseInt(qty_1.getValue().toString());
        int qty2 = Integer.parseInt(qty_2.getValue().toString());
        int qty3 = Integer.parseInt(qty_3.getValue().toString());
        int qty4 = Integer.parseInt(qty_4.getValue().toString());
        int qty5 = Integer.parseInt(qty_5.getValue().toString());
        int qty6 = Integer.parseInt(qty_6.getValue().toString());
        int qty7= Integer.parseInt(qty_7.getValue().toString());
        int qty8 = Integer.parseInt(qty_8.getValue().toString());
        int qty9 = Integer.parseInt(qty_9.getValue().toString());
        int qty10 = Integer.parseInt(qty_10.getValue().toString());
        int qty11= Integer.parseInt(qty_11.getValue().toString());
        int qty12 = Integer.parseInt(qty_12.getValue().toString());
        int qty13 = Integer.parseInt(qty_13.getValue().toString());
        int qty14 = Integer.parseInt(qty_14.getValue().toString());
        int qty15 = Integer.parseInt(qty_15.getValue().toString());
        int qty16 = Integer.parseInt(qty_16.getValue().toString());
        int qty17 = Integer.parseInt(qty_17.getValue().toString());
        int qty18 = Integer.parseInt(qty_18.getValue().toString());
        int qty19 = Integer.parseInt(qty_19.getValue().toString());
        int qty20 = Integer.parseInt(qty_20.getValue().toString());
        int qty21 = Integer.parseInt(qty_21.getValue().toString());
        
        

        try{

            con = ConnectionClass.getConnection();
            if (cb_1.isSelected()){

                String sql = "insert into cart_table values(?,?,?,?)";//4            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setNull(1,Types.INTEGER);
                ps.setString(2,jLabel15.getText());
                ps.setInt(3,qty1);
                ps.setDouble(4, (11.49*qty1));

                ps.executeUpdate();
                
                qty_1.setValue(1);
                cb_1.setSelected(false);

            }
            if (cb_2.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_name_2.getText());
                ps22.setInt(3,qty2);
                ps22.setDouble(4, (13.79*qty2));

                ps22.executeUpdate();
                
                qty_2.setValue(1);
                cb_2.setSelected(false);

            }
            if (cb_3.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_3.getText());
                ps22.setInt(3,qty3);
                ps22.setDouble(4, (10.91*qty3));

                ps22.executeUpdate();
                
                qty_3.setValue(1);
                cb_3.setSelected(false);

            }
            if (cb_4.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_4.getText());
                ps22.setInt(3,qty4);
                ps22.setDouble(4, (12.64*qty4));

                ps22.executeUpdate();
                
                qty_4.setValue(1);
                cb_4.setSelected(false);

            }
            if (cb_5.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_5.getText());
                ps22.setInt(3,qty5);
                ps22.setDouble(4, (10.91*qty5));

                ps22.executeUpdate();
                
                qty_5.setValue(1);
                cb_5.setSelected(false);            
             
            }
            if (cb_6.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_6.getText());
                ps22.setInt(3,qty6);
                ps22.setDouble(4, (14.94*qty6));

                ps22.executeUpdate();
                
                qty_6.setValue(1);
                cb_6.setSelected(false);

            }
            if (cb_7.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_7.getText());
                ps22.setInt(3,qty7);
                ps22.setDouble(4, (4*qty7));

                ps22.executeUpdate();
                
                qty_7.setValue(1);
                cb_7.setSelected(false);

            }
            if (cb_8.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_8.getText());
                ps22.setInt(3,qty8);
                ps22.setDouble(4, (1.69*qty8));

                ps22.executeUpdate();
                
                qty_8.setValue(1);
                cb_8.setSelected(false);

            }
            if (cb_9.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_9.getText());
                ps22.setInt(3,qty9);
                ps22.setDouble(4, (11.26*qty9));

                ps22.executeUpdate();
                
                qty_9.setValue(1);
                cb_9.setSelected(false);

            }
            if (cb_10.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_10.getText());
                ps22.setInt(3,qty10);
                ps22.setDouble(4, (12.98*qty10));

                ps22.executeUpdate();
                
                qty_10.setValue(1);
                cb_10.setSelected(false);

            }
            if (cb_11.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_11.getText());
                ps22.setInt(3,qty11);
                ps22.setDouble(4, (4.50*qty11));

                ps22.executeUpdate();
                
                qty_11.setValue(1);
                cb_11.setSelected(false);

            }
            if (cb_12.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_12.getText());
                ps22.setInt(3,qty12);
                ps22.setDouble(4, (4*qty12));

                ps22.executeUpdate();
                
                qty_12.setValue(1);
                cb_12.setSelected(false);

            }
            if (cb_13.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_13.getText());
                ps22.setInt(3,qty13);
                ps22.setDouble(4, (1.95*qty13));

                ps22.executeUpdate();
                
                qty_13.setValue(1);
                cb_13.setSelected(false);

            }
            if (cb_14.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_14.getText());
                ps22.setInt(3,qty14);
                ps22.setDouble(4, (2.86*qty14));

                ps22.executeUpdate();
                
                qty_14.setValue(1);
                cb_14.setSelected(false);

            }
            if (cb_15.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_15.getText());
                ps22.setInt(3,qty15);
                ps22.setDouble(4, (2.86*qty15));

                ps22.executeUpdate();
                
                qty_15.setValue(1);
                cb_15.setSelected(false);

            }
            if (cb_16.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_16.getText());
                ps22.setInt(3,qty16);
                ps22.setDouble(4, (2.86*qty16));

                ps22.executeUpdate();
                
                qty_16.setValue(1);
                cb_16.setSelected(false);

            }
            if (cb_17.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_17.getText());
                ps22.setInt(3,qty17);
                ps22.setDouble(4, (2.86*qty17));

                ps22.executeUpdate();
                
                qty_17.setValue(1);
                cb_17.setSelected(false);

            }
            if (cb_18.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_18.getText());
                ps22.setInt(3,qty18);
                ps22.setDouble(4, (2.86*qty18));

                ps22.executeUpdate();
                
                qty_18.setValue(1);
                cb_18.setSelected(false);

            }
            if (cb_19.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_19.getText());
                ps22.setInt(3,qty19);
                ps22.setDouble(4, (2.86*qty19));

                ps22.executeUpdate();
                
                qty_19.setValue(1);
                cb_19.setSelected(false);

            }
            if (cb_20.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_20.getText());
                ps22.setInt(3,qty20);
                ps22.setDouble(4, (5.19*qty20));

                ps22.executeUpdate();
                
                qty_20.setValue(1);
                cb_20.setSelected(false);

            }
            if (cb_21.isSelected()){

                String sql22 = "insert into cart_table values(?,?,?,?)";//4                
                PreparedStatement ps22 = con.prepareStatement(sql22);
                ps22.setNull(1,Types.INTEGER);
                ps22.setString(2,lbl_21.getText());
                ps22.setInt(3,qty21);
                ps22.setDouble(4, (5.19*qty21));

                ps22.executeUpdate();
                
                qty_21.setValue(1);
                cb_21.setSelected(false);

            }
            var output = JOptionPane.showInputDialog("Do you wish to add coupon code?");
            txtCoupon.setText(output);
            //JOptionPane.showMessageDialog(null, output);

            JOptionPane.showMessageDialog(null, "Items added");

            String sql1 = "Select * from cart_table";
            PreparedStatement pst = con.prepareStatement(sql1);
            ResultSet rs =pst.executeQuery();

            DefaultTableModel tbl1 = (DefaultTableModel) tblDishTable.getModel();
            tbl1.setRowCount(0);

            while(rs.next()){
                Object o1[] = {rs.getString("Sr_no"), rs.getString("Dish"),rs.getString("Quantity"),rs.getString("Price")};
                tbl1.addRow(o1);
           
            }
            getTotal();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_AddCartBttnActionPerformed

    private void OrderBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderBttnActionPerformed
       StudentOrderPaymentPage sopp = new StudentOrderPaymentPage();
       sopp.setVisible(true);
       dispose();
       
       //String vendor = PopeyeHomePage.Popeye.getText();
       //String username = StudentLoginPage.usernameField.getText();//"usumaki";
       //String orderid = vendor+username+ (int)Math.floor(Math.random()*10000);
       //String status = "Order Placed, Awaiting Confirmation";
       //float subtotal = Float.parseFloat(lbl_subt.getText());
       //float taxes = Float.parseFloat(lbl_tax.getText());
       //float total = Float.parseFloat(lbl_tot.getText());
       //float huskyBal =0.0f;
       
       try
       {
            //int rows = tblDishTable.getRowCount();
            
            con = ConnectionClass.getConnection();
//            String sql = "insert into orders values(?,?,?,?,?,?,?)";//7
//            PreparedStatement ps = con.prepareStatement(sql);
//            
//            ps.setString(1,vendor);
//            ps.setString(2,orderid);
//            ps.setString(3, status);
//            ps.setString(4, username);
//            ps.setFloat(5,subtotal);
//            ps.setFloat(6, taxes);
//            ps.setFloat(7, total);
//            ps.executeUpdate();
            
//            String sql1 = "INSERT INTO `order_details`(`Sr_no`, `Order_ID`, `Dish`, `Quantity`, `Price`) values (?,?,?,?,?);";  //5
//            PreparedStatement ps1 = con.prepareStatement(sql1);
//            
//            for (int row = 0; row < rows; row++) {
// 
//                String dish = tblDishTable.getValueAt(row,1).toString();
//                int quantity = Integer.parseInt(tblDishTable.getValueAt(row,2).toString());
//                float price = Float.parseFloat(tblDishTable.getValueAt(row,3).toString());
//                //System.out.println(dish);
//                //System.out.println(price);
//                //System.out.println(quantity);
//                ps1.setNull(1,Types.INTEGER);
//                ps1.setString(2, orderid);
//                ps1.setString(3, dish);
//                ps1.setInt(4, quantity );
//                ps1.setFloat(5,price);
//            
//            
//                ps1.addBatch();
//            }     
//            
//            ps1.executeBatch();
            //ps1.executeUpdate();
            
           

       }
        catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
       }
    }//GEN-LAST:event_OrderBttnActionPerformed

    private void navigateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navigateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_navigateMouseClicked

    private void navigateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateActionPerformed
        // TODO add your handling code here:
        if(navigate.getSelectedItem().toString().equals("Back To Home Page")){
            String role = "";
            try{
                String slotSql = ("Select role from student_info where username = '"+StudentLoginPage.usernameField.getText()+"' ");
                PreparedStatement slotPreparedStatement = con.prepareStatement(slotSql);
                ResultSet c = slotPreparedStatement.executeQuery();
                while(c.next())
                {
                    role = c.getString("role");
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            if (role.equals("student")){
                new StudentHomePage().setVisible(true);
                dispose();
            }

            if (role.equals("faculty")){
                new FacultyHomePage().setVisible(true);
                dispose();
            }

        }
        if(navigate.getSelectedItem().toString().equals("My Profile")){
            new StudentProfilePage().setVisible(true);
            dispose();
        }
        if(navigate.getSelectedItem().toString().equals("Order Page")){
            new StudentOrdersPage().setVisible(true);
            dispose();
        }
        if(navigate.getSelectedItem().toString().equals("Logout")){
            new NEUHomePage().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_navigateActionPerformed

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
            java.util.logging.Logger.getLogger(PopeyeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopeyeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopeyeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopeyeHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopeyeHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCartBttn;
    private javax.swing.JButton BackBttn;
    private javax.swing.JButton OrderBttn;
    public static javax.swing.JTextField Popeye;
    private javax.swing.JButton ResetBttn;
    private javax.swing.JCheckBox cb_1;
    private javax.swing.JCheckBox cb_10;
    private javax.swing.JCheckBox cb_11;
    private javax.swing.JCheckBox cb_12;
    private javax.swing.JCheckBox cb_13;
    private javax.swing.JCheckBox cb_14;
    private javax.swing.JCheckBox cb_15;
    private javax.swing.JCheckBox cb_16;
    private javax.swing.JCheckBox cb_17;
    private javax.swing.JCheckBox cb_18;
    private javax.swing.JCheckBox cb_19;
    private javax.swing.JCheckBox cb_2;
    private javax.swing.JCheckBox cb_20;
    private javax.swing.JCheckBox cb_21;
    private javax.swing.JCheckBox cb_3;
    private javax.swing.JCheckBox cb_4;
    private javax.swing.JCheckBox cb_5;
    private javax.swing.JCheckBox cb_6;
    private javax.swing.JCheckBox cb_7;
    private javax.swing.JCheckBox cb_8;
    private javax.swing.JCheckBox cb_9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDollarsOff;
    private javax.swing.JLabel lblFlat;
    private javax.swing.JLabel lblFlatoff;
    private javax.swing.JLabel lblOfferTitle;
    public static javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUseCode;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_16;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_19;
    private javax.swing.JLabel lbl_20;
    private javax.swing.JLabel lbl_21;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    public static javax.swing.JLabel lbl_couponshow;
    private javax.swing.JLabel lbl_name_2;
    private javax.swing.JLabel lbl_price_2;
    public static javax.swing.JLabel lbl_subt;
    public static javax.swing.JLabel lbl_tax;
    public static javax.swing.JLabel lbl_tot;
    private javax.swing.JLabel lblcouponcode;
    private javax.swing.JLabel lblmin;
    private javax.swing.JComboBox<String> navigate;
    private javax.swing.JSpinner qty_1;
    private javax.swing.JSpinner qty_10;
    private javax.swing.JSpinner qty_11;
    private javax.swing.JSpinner qty_12;
    private javax.swing.JSpinner qty_13;
    private javax.swing.JSpinner qty_14;
    private javax.swing.JSpinner qty_15;
    private javax.swing.JSpinner qty_16;
    private javax.swing.JSpinner qty_17;
    private javax.swing.JSpinner qty_18;
    private javax.swing.JSpinner qty_19;
    private javax.swing.JSpinner qty_2;
    private javax.swing.JSpinner qty_20;
    private javax.swing.JSpinner qty_21;
    private javax.swing.JSpinner qty_3;
    private javax.swing.JSpinner qty_4;
    private javax.swing.JSpinner qty_5;
    private javax.swing.JSpinner qty_6;
    private javax.swing.JSpinner qty_7;
    private javax.swing.JSpinner qty_8;
    private javax.swing.JSpinner qty_9;
    public static javax.swing.JTable tblDishTable;
    private javax.swing.JTextField txtCoupon;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTaxes;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
