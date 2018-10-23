package view;

import java.awt.Image;
import java.io.IOException;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.GiaoVienDAO;
import model.LopDAO;
import model.StaticVariable;
import model.ThongBaoCaNhanDAO;
import model.ThongBaoChungDAO;

public class GuiThongBaoUI extends javax.swing.JFrame {


    public GuiThongBaoUI() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_noidung = new javax.swing.JTextArea();
        txt_mahocsinh = new javax.swing.JTextField();
        chung = new javax.swing.JCheckBox();
        txt_mathongbao = new javax.swing.JTextField();
        btn_gui = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gửi Thông Báo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nội Dung ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Thông Báo ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Học Sinh ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        txt_noidung.setColumns(20);
        txt_noidung.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txt_noidung.setRows(5);
        txt_noidung.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txt_noidungAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txt_noidung.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_noidungInputMethodTextChanged(evt);
            }
        });
        txt_noidung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_noidungKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_noidungKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_noidungKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_noidung);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 186, 320, 250));

        txt_mahocsinh.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_mahocsinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, -1));

        chung.setBackground(new java.awt.Color(0, 0, 0));
        chung.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        chung.setForeground(new java.awt.Color(255, 255, 255));
        chung.setText("Gửi thông báo chung");
        chung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chungActionPerformed(evt);
            }
        });
        jPanel1.add(chung, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 190, -1));

        txt_mathongbao.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txt_mathongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mathongbaoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_mathongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 190, -1));

        btn_gui.setBackground(new java.awt.Color(255, 255, 255));
        btn_gui.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_gui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        btn_gui.setText("Gửi");
        btn_gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_gui, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 320, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 510, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 520));

        setSize(new java.awt.Dimension(495, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guiActionPerformed
        if(!chung.isSelected()) {
            if(!txt_mahocsinh.getText().equals("") && !txt_mathongbao.getText().equals("") && !txt_noidung.getText().equals("")) {
                String maHocSinh = txt_mahocsinh.getText();
                String maThongBao = txt_mathongbao.getText();
                String noiDung = txt_noidung.getText();
                int x = ThongBaoCaNhanDAO.insertThongBao(maThongBao, noiDung, new Timestamp(System.currentTimeMillis()), 
                                                         StaticVariable.GV_MAGV, maHocSinh);
                if(x == 1) {
                    JOptionPane.showMessageDialog(null, "Gửi Thông Báo Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Gửi Thông Báo Thất Bại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            if(!txt_mathongbao.getText().equals("") && !txt_noidung.getText().equals("")) {
                String maThongBao = txt_mathongbao.getText();
                String noiDung = txt_noidung.getText();
                int x = ThongBaoChungDAO.insertThongBao(maThongBao, noiDung, new Timestamp(System.currentTimeMillis()), 
                                                        StaticVariable.GV_MAGV, StaticVariable.GV_MALOP);
                if(x == 1) {
                    JOptionPane.showMessageDialog(null, "Gửi Thông Báo Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Gửi Thông Báo Thất Bại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_guiActionPerformed

    private void chungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chungActionPerformed
        if(chung.isSelected()) {
            txt_mahocsinh.setEditable(false);
            txt_mahocsinh.setEnabled(false);
        }
        if(!chung.isSelected()) {
            txt_mahocsinh.setEditable(true);
            txt_mahocsinh.setEnabled(true);
        }
    }//GEN-LAST:event_chungActionPerformed

    private void txt_noidungAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_noidungAncestorAdded
        
    }//GEN-LAST:event_txt_noidungAncestorAdded

    private void txt_noidungInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_noidungInputMethodTextChanged
        
    }//GEN-LAST:event_txt_noidungInputMethodTextChanged

    private void txt_noidungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noidungKeyTyped
       
    }//GEN-LAST:event_txt_noidungKeyTyped

    private void txt_mathongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mathongbaoActionPerformed
        
    }//GEN-LAST:event_txt_mathongbaoActionPerformed

    private void txt_noidungKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noidungKeyPressed
        
    }//GEN-LAST:event_txt_noidungKeyPressed

    private void txt_noidungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noidungKeyReleased
        if(txt_noidung.getText().equals("")) {
            btn_gui.setEnabled(false);
        }
        if(!txt_noidung.getText().equals("")) {
            btn_gui.setEnabled(true);
        }
    }//GEN-LAST:event_txt_noidungKeyReleased

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
            java.util.logging.Logger.getLogger(GuiThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiThongBaoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gui;
    private javax.swing.JCheckBox chung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_mahocsinh;
    private javax.swing.JTextField txt_mathongbao;
    private javax.swing.JTextArea txt_noidung;
    // End of variables declaration//GEN-END:variables
}
