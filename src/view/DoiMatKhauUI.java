
package view;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.GiaoVien;
import model.GiaoVienDAO;
import model.HocSinh;
import model.HocSinhDAO;
import model.StaticVariable;


public class DoiMatKhauUI extends javax.swing.JFrame {

  
    public DoiMatKhauUI() {
        initComponents();
        label_cu_v.setVisible(false);
        label_cu_x.setVisible(false);
        label_xacnhan_x.setVisible(false);
        label_xacnhan_v.setVisible(false);
        label_moi_warn.setVisible(false);
        lable_moi_v.setVisible(false);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cu = new javax.swing.JPasswordField();
        txt_moi = new javax.swing.JPasswordField();
        txt_xacnhan = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label_cu_v = new javax.swing.JLabel();
        label_xacnhan_v = new javax.swing.JLabel();
        label_cu_x = new javax.swing.JLabel();
        label_xacnhan_x = new javax.swing.JLabel();
        lable_moi_v = new javax.swing.JLabel();
        label_moi_warn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đồi Mật Khẩu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mật Khẩu Cũ ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật Khẩu Mới ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Xác Nhận");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        txt_cu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_cu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cuActionPerformed(evt);
            }
        });
        txt_cu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cuKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 230, -1));

        txt_moi.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_moi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_moiKeyReleased(evt);
            }
        });
        jPanel2.add(txt_moi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 230, -1));

        txt_xacnhan.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_xacnhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_xacnhanKeyReleased(evt);
            }
        });
        jPanel2.add(txt_xacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 230, -1));

        jButton1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 80, -1));

        jButton2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 80, -1));

        label_cu_v.setBackground(new java.awt.Color(0, 0, 0));
        label_cu_v.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_cu_v.setForeground(new java.awt.Color(255, 255, 255));
        label_cu_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
        jPanel2.add(label_cu_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 30, 30));

        label_xacnhan_v.setBackground(new java.awt.Color(0, 0, 0));
        label_xacnhan_v.setForeground(new java.awt.Color(255, 255, 255));
        label_xacnhan_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
        jPanel2.add(label_xacnhan_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 30, 30));

        label_cu_x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        jPanel2.add(label_cu_x, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 30, 30));

        label_xacnhan_x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        jPanel2.add(label_xacnhan_x, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 30, 30));

        lable_moi_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
        jPanel2.add(lable_moi_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 134, 30, 30));

        label_moi_warn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warning.png"))); // NOI18N
        jPanel2.add(label_moi_warn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 30, 30));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cu = "", moi = "", xacnhan = "";
        // kiem tra dieu kien
        if(String.valueOf(txt_cu.getPassword()).equals("") ||
           String.valueOf(txt_moi.getPassword()).equals("") || String.valueOf(txt_xacnhan.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            cu = String.valueOf(txt_cu.getPassword());
            moi = String.valueOf(txt_moi.getPassword());
            xacnhan = String.valueOf(txt_xacnhan.getPassword());
        }
        // Giao vien doi mat khau
        if(StaticVariable.role) {
            GiaoVien temp = GiaoVienDAO.selectGiaoVien(StaticVariable.GV_MAGV);
            if(!cu.equals(temp.getPassword())) {
                JOptionPane.showMessageDialog(null, "Sai Mật Khẩu Cũ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if(!moi.equals(xacnhan)) {
                    JOptionPane.showMessageDialog(null, "Xác Nhận Mật Khẩu Không Đúng", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    int x = GiaoVienDAO.doiMatKhauGiaoVien(moi);
                    if(x == 1) {
                        JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {                     // Phu huynh doi mat khau
            HocSinh temp = HocSinhDAO.selectHocSinh(StaticVariable.PH_MAHOCSINH);
            if(!cu.equals(temp.getPassword())) {
                JOptionPane.showMessageDialog(null, "Sai Mật Khẩu Cũ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if(!moi.equals(xacnhan)) {
                    JOptionPane.showMessageDialog(null, "Xác Nhận Mật Khẩu Không Đúng", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    int x = HocSinhDAO.doiMatKhauHocSinh(moi);
                    if(x == 1) {
                        JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void txt_cuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cuKeyTyped
      
    }//GEN-LAST:event_txt_cuKeyTyped

    private void txt_cuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cuActionPerformed
 
    }//GEN-LAST:event_txt_cuActionPerformed

    private void txt_cuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cuKeyReleased
        if(StaticVariable.role) {
            GiaoVien temp = GiaoVienDAO.selectGiaoVien(StaticVariable.GV_MAGV);
            if(!String.valueOf(txt_cu.getPassword()).equals("")) {
                if(temp.getPassword().equals(String.valueOf(txt_cu.getPassword()))) { // mk ok
                    label_cu_v.setVisible(true);
                    label_cu_x.setVisible(false);
                } else {
                    label_cu_v.setVisible(false);
                    label_cu_x.setVisible(true);
                }
            }
        } else {
            HocSinh temp = HocSinhDAO.selectHocSinh(StaticVariable.PH_MAHOCSINH);
            if(!String.valueOf(txt_cu.getPassword()).equals("")) {
                if(temp.getPassword().equals(String.valueOf(txt_cu.getPassword()))) { // mk ok
                    label_cu_v.setVisible(true);
                    label_cu_x.setVisible(false);
                } else {
                    label_cu_v.setVisible(false);
                    label_cu_x.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_txt_cuKeyReleased

    private void txt_xacnhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_xacnhanKeyReleased
        if(!String.valueOf(txt_xacnhan.getPassword()).equals("")) {
            if(String.valueOf(txt_xacnhan.getPassword()).equals(String.valueOf(txt_moi.getPassword()))) {
                label_xacnhan_v.setVisible(true);
                label_xacnhan_x.setVisible(false);
            } else {
                label_xacnhan_v.setVisible(false);
                label_xacnhan_x.setVisible(true);
            }
        }
    }//GEN-LAST:event_txt_xacnhanKeyReleased

    private boolean checkPassword(String pass) {
        boolean check = false;
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < pass.length(); i++) {
            char x = pass.charAt(i);
            if (Character.isLetter(x)) {
                hasLetter = true;
            }
            else if (Character.isDigit(x)) {
                hasDigit = true;
            }
            // no need to check further, break the loop
            if(hasLetter && hasDigit){
                break;
            }
        }
        if (hasLetter && hasDigit) {
            check = true;
        } else {
            check = false;
        }
        return check;
 }
    
    private void txt_moiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moiKeyReleased
        if(!String.valueOf(txt_moi.getPassword()).equals("")) {
            String temp = String.valueOf(txt_moi.getPassword());
            if(checkPassword(temp)) {
                lable_moi_v.setVisible(true);
                label_moi_warn.setVisible(false);
            } else {
                lable_moi_v.setVisible(false);
                label_moi_warn.setVisible(true);
            }
        } else {
            lable_moi_v.setVisible(false);
            label_moi_warn.setVisible(false);
        }
        if(!String.valueOf(txt_xacnhan.getPassword()).equals("")) {
            if(String.valueOf(txt_xacnhan.getPassword()).equals(String.valueOf(txt_moi.getPassword()))) {
                label_xacnhan_v.setVisible(true);
                label_xacnhan_x.setVisible(false);
            } else {
                label_xacnhan_v.setVisible(false);
                label_xacnhan_x.setVisible(true);
            }
        }
    }//GEN-LAST:event_txt_moiKeyReleased

   
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
            java.util.logging.Logger.getLogger(DoiMatKhauUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_cu_v;
    private javax.swing.JLabel label_cu_x;
    private javax.swing.JLabel label_moi_warn;
    private javax.swing.JLabel label_xacnhan_v;
    private javax.swing.JLabel label_xacnhan_x;
    private javax.swing.JLabel lable_moi_v;
    private javax.swing.JPasswordField txt_cu;
    private javax.swing.JPasswordField txt_moi;
    private javax.swing.JPasswordField txt_xacnhan;
    // End of variables declaration//GEN-END:variables
}
