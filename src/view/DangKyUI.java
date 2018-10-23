
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.GiaoVienDAO;
import model.HocSinhDAO;
import model.LopDAO;
import model.StaticVariable;
import model.XuLiChuoi;


public class DangKyUI extends javax.swing.JFrame {

  
    public DangKyUI() {
        initComponents();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
        groupButton();
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void groupButton() {
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(nam);
        btnGroup.add(nu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_siso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_magv = new javax.swing.JTextField();
        txt_ho = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        txt_pass = new javax.swing.JPasswordField();
        txt_ngaysinh = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_malop = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tenlop = new javax.swing.JTextField();
        txt_khoa = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đăng Ký");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(355, 506));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Giáo Viên ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        txt_siso.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_siso.setBorder(null);
        jPanel1.add(txt_siso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 270, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày Sinh");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giới Tính ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        txt_magv.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_magv.setBorder(null);
        jPanel1.add(txt_magv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 250, 30));

        txt_ho.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_ho.setBorder(null);
        jPanel1.add(txt_ho, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 250, 30));

        txt_ten.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_ten.setBorder(null);
        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, 30));

        nam.setBackground(new java.awt.Color(0, 0, 0));
        nam.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        nam.setForeground(new java.awt.Color(255, 255, 255));
        nam.setText("Nam");
        jPanel1.add(nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        nu.setBackground(new java.awt.Color(0, 0, 0));
        nu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        nu.setForeground(new java.awt.Color(255, 255, 255));
        nu.setText("Nữ");
        jPanel1.add(nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        txt_pass.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_pass.setBorder(null);
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 250, 30));

        txt_ngaysinh.setBackground(new java.awt.Color(255, 255, 255));
        txt_ngaysinh.setDateFormatString("dd/MM/yyyy");
        txt_ngaysinh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jPanel1.add(txt_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 250, 30));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mã Lớp ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Khóa");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên Lớp ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        txt_malop.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_malop.setBorder(null);
        jPanel1.add(txt_malop, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 270, 30));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sỉ Số ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        txt_tenlop.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_tenlop.setBorder(null);
        txt_tenlop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenlopActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tenlop, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 270, 30));

        txt_khoa.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txt_khoa.setBorder(null);
        jPanel1.add(txt_khoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 270, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 10, 520));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Đăng Ký");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel11MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 270, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -6, 740, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        setSize(new java.awt.Dimension(735, 531));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        
    }//GEN-LAST:event_txt_tenActionPerformed

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
        if(txt_magv.getText().equals("") || txt_ho.getText().equals("") || txt_ten.getText().equals("")
           || txt_ngaysinh.isEnabled() == false || String.valueOf(txt_pass.getPassword()).equals("")
           || (nam.isSelected() == false && nu.isSelected() == false) 
           || txt_malop.getText().equals("") || txt_tenlop.getText().equals("") || txt_khoa.getText().equals("")
           || txt_siso.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Thông Tin", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String maGV = "", ho = "", ten = "", pass = "";
            Date d = txt_ngaysinh.getDate();
            Timestamp ngaySinh = new Timestamp(d.getTime());
            boolean gioiTinh = true;
            String maLop = "", tenLop = "", khoa = "";
            int siso = 0;
            maGV = txt_magv.getText(); ho = txt_ho.getText(); ten = txt_ten.getText();
            pass = String.valueOf(txt_pass.getPassword());
            if(nam.isSelected()) {
                gioiTinh = true;
            } 
            else {
                gioiTinh = false;
            }
            maLop = txt_malop.getText(); tenLop = txt_tenlop.getText(); khoa = txt_khoa.getText();
            // chuan hoa du lieu
            maGV = XuLiChuoi.chuanHoaMa(maGV);
            ho = XuLiChuoi.chuanHoaChuoi(ho);
            ten = XuLiChuoi.chuanHoaChuoi(ten);
            maLop = XuLiChuoi.chuanHoaMa(maLop);
            tenLop = XuLiChuoi.chuanHoaChuoi(tenLop);
            try {
                siso = Integer.valueOf(txt_siso.getText());
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi Nhập Liệu", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            if(GiaoVienDAO.checkMaGiaoVienCoTrongHeThong(maGV)) {
                JOptionPane.showMessageDialog(null, "Mã Giáo Viên Đã Tồn Tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(LopDAO.checkMaLopCoTrongHeThong(maLop)) {
                JOptionPane.showMessageDialog(null, "Mã Lớp Đã Tồn Tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            StaticVariable.GV_MAGV = maGV;
            StaticVariable.GV_MALOP = maLop;
            int x = GiaoVienDAO.insertGiaoVien(ho, ten, gioiTinh, pass, ngaySinh, maGV);
            int y = LopDAO.insertLop(maLop, tenLop, khoa, siso, maGV);
            if(x == 1 && y == 1) {
                JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng Ký Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
            close();
            GiaoVienUI gvui = new GiaoVienUI();
            gvui.setVisible(true);
        }
    }//GEN-LAST:event_jLabel11MouseReleased

    private void txt_tenlopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenlopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenlopActionPerformed


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
            java.util.logging.Logger.getLogger(DangKyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton nam;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField txt_ho;
    private javax.swing.JTextField txt_khoa;
    private javax.swing.JTextField txt_magv;
    private javax.swing.JTextField txt_malop;
    private com.toedter.calendar.JDateChooser txt_ngaysinh;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_siso;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_tenlop;
    // End of variables declaration//GEN-END:variables
}
