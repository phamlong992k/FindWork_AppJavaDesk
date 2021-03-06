/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Login;

import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class CheckCodeFrame extends javax.swing.JFrame {

    /**
     * Creates new form CheckCode
     */
    int code;
    RegisterFrame registerFrame;
    public CheckCodeFrame() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    public CheckCodeFrame(RegisterFrame registerFrame) {
        initComponents();
        this.registerFrame=registerFrame;
        setImage();
        setLocationRelativeTo(null);
    }
    public void setCode(int code){
        this.code=code;
    }
    private void setImage()
    {
        try 
        {
            BufferedImage imageMain;            
            imageMain = ImageIO.read(getClass().getResource("/icon/Login.png"));
            ImageIcon iconMain = new ImageIcon(imageMain.getScaledInstance(710 , 860, imageMain.SCALE_SMOOTH));
            ChangePassLable.setIcon(iconMain);
        } catch (IOException ex) {
            Logger.getLogger(LoginDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        txtCode = new javax.swing.JTextField();
        btnCheckCode = new javax.swing.JButton();
        lblCode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ChangePassLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 84, 319, 39));

        btnCheckCode.setText("Check Code");
        btnCheckCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckCodeActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 84, -1, 39));

        lblCode.setText("Code");
        jPanel1.add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 95, 54, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Enter your email and Get code to check in your email !");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 25, 511, -1));

        ChangePassLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Login.png"))); // NOI18N
        jPanel1.add(ChangePassLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckCodeActionPerformed
        // TODO add your handling code here:
        if(txtCode.getText().matches("[0-9]{1,}")){
            int codeCheck=Integer.parseInt(txtCode.getText());
            if(codeCheck==code){
               JOptionPane.showMessageDialog(null,"Đúng Code");
               registerFrame.registerOK();
               this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
            else{
                JOptionPane.showMessageDialog(null,"Sai Code Xin Hãy Kiểm Tra Email");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"wrong format please enter Number");
        }

    }//GEN-LAST:event_btnCheckCodeActionPerformed

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
            java.util.logging.Logger.getLogger(CheckCodeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckCodeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckCodeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckCodeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckCodeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChangePassLable;
    private javax.swing.JButton btnCheckCode;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
