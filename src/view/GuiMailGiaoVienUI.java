
package view;

import java.awt.Image;
import java.io.IOException;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.LopDAO;
import model.MailPhuHuynhDAO;
import model.StaticVariable;

public class GuiMailGiaoVienUI extends javax.swing.JFrame {

  
    public GuiMailGiaoVienUI() {
        initComponents();
        btn_gui.setEnabled(false);
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_noidung = new javax.swing.JTextArea();
        btn_gui = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gửi Email Giáo Viên");
        setPreferredSize(new java.awt.Dimension(480, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nội Dung");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        txt_noidung.setColumns(20);
        txt_noidung.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txt_noidung.setRows(5);
        txt_noidung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_noidungKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_noidungKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_noidung);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 340, 330));

        btn_gui.setBackground(new java.awt.Color(255, 255, 255));
        btn_gui.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_gui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        btn_gui.setText("Gửi");
        btn_gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_gui, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 340, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 510, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 520));

        setSize(new java.awt.Dimension(498, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_noidungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noidungKeyTyped
        
    }//GEN-LAST:event_txt_noidungKeyTyped

    private void btn_guiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guiActionPerformed
        LopDAO.layMaGiaoVienTuMaLop();
        String noiDung = txt_noidung.getText();
        int x = MailPhuHuynhDAO.insertMailPhuHuynh(StaticVariable.PH_MAHOCSINH, StaticVariable.PH_MAGIAOVIEN, 
                                                   noiDung, new Timestamp(System.currentTimeMillis()));
        if(x == 1) {
            JOptionPane.showMessageDialog(null, "Gửi Email Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "Gửi Email Thất Bại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_guiActionPerformed

    private void txt_noidungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noidungKeyReleased
        if(txt_noidung.getText().equals("")) {
            btn_gui.setEnabled(false);
        }
        if(!txt_noidung.getText().equals("")) {
            btn_gui.setEnabled(true);
        }
    }//GEN-LAST:event_txt_noidungKeyReleased

 
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
            java.util.logging.Logger.getLogger(GuiMailGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMailGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMailGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMailGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMailGiaoVienUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_noidung;
    // End of variables declaration//GEN-END:variables
}
