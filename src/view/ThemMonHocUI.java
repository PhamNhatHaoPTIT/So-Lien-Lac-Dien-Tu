
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.DiemDAO;
import model.HocSinh;
import model.HocSinhDAO;
import model.MonHocDAO;
import model.StaticVariable;
import model.XuLiChuoi;


public class ThemMonHocUI extends javax.swing.JFrame {

  
    public ThemMonHocUI() {
        initComponents();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        xacnhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_tenmonhoc = new javax.swing.JTextField();
        txt_mamonhoc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm Môn Học");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ghichu.setColumns(20);
        txt_ghichu.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txt_ghichu.setRows(5);
        jScrollPane1.setViewportView(txt_ghichu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 340, 200));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ghi chú ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        xacnhan.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        xacnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        xacnhan.setText("Lưu");
        xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacnhanActionPerformed(evt);
            }
        });
        jPanel1.add(xacnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 340, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên môn học ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txt_tenmonhoc.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_tenmonhoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 340, -1));

        txt_mamonhoc.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_mamonhoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 340, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã môn học ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 500, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 510));

        setSize(new java.awt.Dimension(486, 531));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacnhanActionPerformed
        if(txt_mamonhoc.getText().equals("") || txt_tenmonhoc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String maMonHoc = XuLiChuoi.chuanHoaMa(txt_mamonhoc.getText());
            if(MonHocDAO.checkMaMonHocTrongHeThong(maMonHoc)) {
                JOptionPane.showMessageDialog(null, "Mã Môn Học Đã Tồn Tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int x = MonHocDAO.insertMonHoc(maMonHoc, XuLiChuoi.chuanHoaChuoi(txt_tenmonhoc.getText()), 
                                           txt_ghichu.getText(), StaticVariable.GV_MALOP);
            if(x == 1) {
                JOptionPane.showMessageDialog(null, "Thêm Môn Học Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                List<HocSinh> listHS = HocSinhDAO.selectAllHocSinhTheoMaLop(StaticVariable.GV_MALOP);
                for (HocSinh hs : listHS) {
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 1, 1); //
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 2, 1); // hocKy 1
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 3, 1); //
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 1, 2); //
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 2, 2); // hocKy 2
                    DiemDAO.insertDiem(0, hs.getMaHocSinh(), maMonHoc, 3, 2); // 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thêm Môn Học Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
            MonHocUI.hienThiThongTin();
            close();
        }
    }//GEN-LAST:event_xacnhanActionPerformed


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
            java.util.logging.Logger.getLogger(ThemMonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemMonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemMonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemMonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemMonHocUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_ghichu;
    private javax.swing.JTextField txt_mamonhoc;
    private javax.swing.JTextField txt_tenmonhoc;
    private javax.swing.JButton xacnhan;
    // End of variables declaration//GEN-END:variables
}
