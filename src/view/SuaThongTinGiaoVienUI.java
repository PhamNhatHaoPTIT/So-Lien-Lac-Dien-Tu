package view;

import java.awt.Image;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.GiaoVien;
import model.GiaoVienDAO;
import model.HocSinhDAO;
import model.StaticVariable;
import model.XuLiChuoi;

public class SuaThongTinGiaoVienUI extends javax.swing.JFrame {

    public SuaThongTinGiaoVienUI() {
        initComponents();
        GiaoVien gv = GiaoVienDAO.selectGiaoVien(StaticVariable.GV_MAGV);
        txt_mahocsinh.setText(gv.getMaGiaoVien());
        txt_ho.setText(gv.getHo());
        txt_ten.setText(gv.getTen());
        //Date date = new Date();
        Timestamp timeStampDate = gv.getNgaySinh();
        txt_ngaysinh.setDate(timeStampDate);
        if(gv.getGioiTinh()) {
            nam.setSelected(true);
        }
        else {
            nu.setSelected(true);
        }
        txt_mahocsinh.setEditable(false);
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

        gioitinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_luu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        txt_ngaysinh = new com.toedter.calendar.JDateChooser();
        txt_ten = new javax.swing.JTextField();
        txt_ho = new javax.swing.JTextField();
        txt_mahocsinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sửa Thông Tin Giáo Viên");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_luu.setBackground(new java.awt.Color(255, 255, 255));
        btn_luu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 310, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Giáo Viên ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày sinh ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giới tính ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        nam.setBackground(new java.awt.Color(0, 0, 0));
        gioitinh.add(nam);
        nam.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        nam.setForeground(new java.awt.Color(255, 255, 255));
        nam.setText("Nam");
        jPanel1.add(nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        nu.setBackground(new java.awt.Color(0, 0, 0));
        gioitinh.add(nu);
        nu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        nu.setForeground(new java.awt.Color(255, 255, 255));
        nu.setText("Nữ");
        jPanel1.add(nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        txt_ngaysinh.setDateFormatString("dd/MM/yyyy");
        txt_ngaysinh.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 307, -1));

        txt_ten.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 307, -1));

        txt_ho.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_ho, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 307, -1));

        txt_mahocsinh.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_mahocsinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 310, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 520, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 510));

        setSize(new java.awt.Dimension(507, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        if(txt_ho.getText().equals("") || txt_ten.getText().equals("")
           || txt_ngaysinh.isEnabled() == false || (nam.isSelected() == false && nu.isSelected() == false)) {
            JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
        else {
            GiaoVien gv = new GiaoVien();
            gv.setMaGiaoVien(StaticVariable.GV_MAGV);
            gv.setHo(XuLiChuoi.chuanHoaChuoi(txt_ho.getText()));
            gv.setTen(XuLiChuoi.chuanHoaChuoi(txt_ten.getText()));
            if(nam.isSelected()) {
                gv.setGioiTinh(true);
            }
            else {
                gv.setGioiTinh(false);
            }
            Date d = txt_ngaysinh.getDate();
            gv.setNgaySinh(new Timestamp(d.getTime()));
            int x = GiaoVienDAO.suaThongTinGiaoVien(gv);
            if(x == 1) {
                JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cập Nhật Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
            this.setVisible(false);
            GiaoVienUI.hienThiThongTinGiaoVien();
        }
    }//GEN-LAST:event_btn_luuActionPerformed

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
            java.util.logging.Logger.getLogger(SuaThongTinGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinGiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaThongTinGiaoVienUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.ButtonGroup gioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton nam;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField txt_ho;
    private javax.swing.JTextField txt_mahocsinh;
    private com.toedter.calendar.JDateChooser txt_ngaysinh;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
