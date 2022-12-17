package FinalProject;

import FinalProject.ConnectionClass;
import FinalProject.MyOrdersPage;
import FinalProject.StudentLoginPage;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.Color;

import java.sql.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;

public class StudentOrdersQRScanner extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    
    Connection con;

    public StudentOrdersQRScanner() {
        initComponents();
        initWebcam();
    }

    @SuppressWarnings("unchecked")
    
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            if (image != null) {
              LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            
             try {

                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }
            
            

            if (result != null) {
                resultField.setText(result.getText());
            }
             if (resultField.getText().equals("")) {
        }
        else {
         jLabel1.setText("QR SCANNED SUCCESFULLY");

         jLabel1.setForeground(Color.green);
        checkInButton.setEnabled(true);
        }

            }
          
           

        
             
               
            
        
            
        } while (true);
        
     
        
        
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resultField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkInButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultField.setBorder(null);
        resultField.setMaximumSize(new java.awt.Dimension(0, 0));
        resultField.setMinimumSize(new java.awt.Dimension(0, 0));
        resultField.setPreferredSize(new java.awt.Dimension(0, 0));
        resultField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                resultFieldInputMethodTextChanged(evt);
            }
        });
        resultField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultFieldActionPerformed(evt);
            }
        });
        resultField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                resultFieldPropertyChange(evt);
            }
        });
        jPanel1.add(resultField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("SCAN THE QR CODE TO COMPLETE PICK-UP ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        checkInButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        checkInButton.setText("CONFIRM");
        checkInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkInButtonMouseClicked(evt);
            }
        });
        checkInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(checkInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 110, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        checkInButton.setEnabled(false);
       
        
    }//GEN-LAST:event_formWindowActivated

    private void resultFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultFieldActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_resultFieldActionPerformed

    private void checkInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkInButtonMouseClicked
        // TODO add your handling code here:
         String username = StudentLoginPage.usernameField.getText();
        String orderID = MyOrdersPage.orderField.getText();
        

        String success = "Order Picked up";    
        
        try{
            con = ConnectionClass.getConnection();
            Statement updateStatement = (Statement) con.createStatement();
            

            String update = ("UPDATE orders SET status = '"+success+"' where Order_ID = '"+orderID+"'");

            PreparedStatement queryStatement = con.prepareStatement(update);
            queryStatement.execute();
            
            
             JOptionPane.showMessageDialog(null,"QR scanned successfully, Order picked up");
            
             //PopeyeManagerPage.lbl_ScanMsg.setText("QR SCANNED SUCCESSFULLY!");
             
                   
          
             
             dispose();
            
            
    
    } 
           
               catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
           }
        
        
    }//GEN-LAST:event_checkInButtonMouseClicked

    private void checkInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInButtonActionPerformed
        // TODO add your handling code here:
           
        
        
       
     /*   String username = StudentLoginPage.usernameField.getText();
        String orderID = MyOrdersPage.orderField.getText();
        

        String success = "Order Picked up";

        String code = "";
        try {
        
             con = (Connection) ConnectionClass.getConnection();
            Statement StudentStatement = (Statement) con.createStatement();
            String slotSql = ("Select Order_ID from orders where order_ID = '"+orderID+"' " );
            PreparedStatement slotPreparedStatement = con.prepareStatement(slotSql);
            ResultSet resultSet = slotPreparedStatement.executeQuery();
           while (resultSet.next()) { 
           code = resultSet.getString("Order_ID");
           }
            
          
           
           if (code.equals(orderID)) {
           
               try{
            con = ConnectionClass.getConnection();
            Statement updateStatement = (Statement) con.createStatement();
            

            String update = ("UPDATE orders SET status = '"+success+"' where order_ID = '"+orderID+"'");

            PreparedStatement queryStatement = con.prepareStatement(update);
            queryStatement.execute();
            
            
             JOptionPane.showMessageDialog(null,"scanned successful");
            
             //PopeyeManagerPage.lbl_ScanMsg.setText("QR SCANNED SUCCESSFULLY!");
             
                   
             
               
             
             dispose();
            
            
    
    } 
           
               catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
           }
               
                       
                       
               
           
           }
           else {
               
           JOptionPane.showMessageDialog(null, "Incorrect QR code or invalid account, please try again");

           resultField.setText("");
           jLabel1.setText("SCAN THE QR CODE TO COMPLETE ORDER PICK-UP ");
           jLabel1.setForeground(Color.red);

           }
           
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                }
        
        
        
        */

        
    }//GEN-LAST:event_checkInButtonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        
           
    }//GEN-LAST:event_jLabel1MouseClicked

    private void resultFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_resultFieldInputMethodTextChanged
        // TODO add your handling code here:
           
    }//GEN-LAST:event_resultFieldInputMethodTextChanged

    private void resultFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_resultFieldPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_resultFieldPropertyChange


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resultField.setText("");
           jLabel1.setText("SCAN THE QR CODE TO COMPLETE PICKUP ");
           jLabel1.setForeground(Color.red);
    }//GEN-LAST:event_jButton1ActionPerformed


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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentOrdersQRScanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StudentOrdersQRScanner().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField resultField;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
    }

    
}
