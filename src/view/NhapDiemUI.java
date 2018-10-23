
package view;

import java.awt.Image;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Diem;
import model.DiemDAO;
import model.HanhKiem;
import model.HanhKiemDAO;
import model.HocSinh;
import model.HocSinhDAO;
import model.MonHoc;
import model.MonHocDAO;
import model.StaticVariable;
import static view.GiaoVienUI.danhsachhocsinh;


public class NhapDiemUI extends javax.swing.JFrame {
    
    int size = 0;
  
    public NhapDiemUI() {
        initComponents();
        initCombobox();
        initDanhSachHocSinh();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }

    private void initCombobox() {
        label_lop.setText(StaticVariable.GV_MALOP);
        List<MonHoc> list = MonHocDAO.selectAllMonHocTheoMaLop(StaticVariable.GV_MALOP);
        for (MonHoc x : list) {
            combomonhoc.addItem(x.getMaMonHoc());
        }
    }
    
    private void initDanhSachHocSinh() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer)bangdiem.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        bangdiem.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        DefaultTableModel dtm = (DefaultTableModel) bangdiem.getModel();
        dtm.setRowCount(0);
        Diem d;
        List<HocSinh> list = HocSinhDAO.selectAllHocSinhTheoMaLop(StaticVariable.GV_MALOP);
        StaticVariable.GV_MAMONHOC = combomonhoc.getSelectedItem().toString();
        DecimalFormat format = new DecimalFormat("#.##");
        double tb;
        for (HocSinh hs : list) {
            Vector<Object> vec = new Vector<>();
            vec.add(hs.getMaHocSinh());
            vec.add(hs.getHo());
            vec.add(hs.getTen());
            d = new Diem();
            tb = 0;
            d = DiemDAO.selectDiem(hs.getMaHocSinh(), StaticVariable.GV_MAMONHOC, 1);
            vec.add(d.getDiem());
            tb += d.getDiem();
            d = new Diem();
            d = DiemDAO.selectDiem(hs.getMaHocSinh(), StaticVariable.GV_MAMONHOC, 2);
            vec.add(d.getDiem());
            tb += d.getDiem() * 2;
            d = new Diem();
            d = DiemDAO.selectDiem(hs.getMaHocSinh(), StaticVariable.GV_MAMONHOC, 3);
            vec.add(d.getDiem());
            tb += d.getDiem() * 3;
            tb /= 6;
            vec.add(format.format(tb));
            dtm.addRow(vec);
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        combomonhoc = new javax.swing.JComboBox<>();
        label_lop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangdiem = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txt_mot = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        label_mahs = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_hai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_diemthi = new javax.swing.JTextField();
        btn_luu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        combohanhkiem = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhập Điểm");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Môn học: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        combomonhoc.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        combomonhoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combomonhocMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combomonhocMouseReleased(evt);
            }
        });
        combomonhoc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                combomonhocCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        combomonhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomonhocActionPerformed(evt);
            }
        });
        combomonhoc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                combomonhocPropertyChange(evt);
            }
        });
        combomonhoc.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                combomonhocVetoableChange(evt);
            }
        });
        jPanel1.add(combomonhoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 141, -1));

        label_lop.setBackground(new java.awt.Color(0, 0, 0));
        label_lop.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_lop.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 141, 30));

        bangdiem.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        bangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã học sinh", "Họ", "Tên", "Điểm hệ số 1", "Điểm hệ số 2", "Điểm thi", "Trung bình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangdiem.setGridColor(new java.awt.Color(255, 255, 255));
        bangdiem.setRowHeight(22);
        bangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bangdiemMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(bangdiem);
        if (bangdiem.getColumnModel().getColumnCount() > 0) {
            bangdiem.getColumnModel().getColumn(0).setResizable(false);
            bangdiem.getColumnModel().getColumn(1).setResizable(false);
            bangdiem.getColumnModel().getColumn(2).setResizable(false);
            bangdiem.getColumnModel().getColumn(3).setResizable(false);
            bangdiem.getColumnModel().getColumn(4).setResizable(false);
            bangdiem.getColumnModel().getColumn(5).setResizable(false);
            bangdiem.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 700, 500));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 10, 560));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Điểm hệ số 1 ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txt_mot.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã học sinh: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        label_mahs.setBackground(new java.awt.Color(0, 0, 0));
        label_mahs.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_mahs.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_mahs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 70, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Điểm hệ số 2 ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txt_hai.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txt_hai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_haiActionPerformed(evt);
            }
        });
        jPanel1.add(txt_hai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Điểm thi ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txt_diemthi.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jPanel1.add(txt_diemthi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, -1));

        btn_luu.setBackground(new java.awt.Color(255, 255, 255));
        btn_luu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 200, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hạnh Kiểm: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 100, -1));

        combohanhkiem.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        combohanhkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tốt", "Khá", "Trung Bình", "Yếu" }));
        jPanel1.add(combohanhkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 570));

        setSize(new java.awt.Dimension(1020, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_haiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_haiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_haiActionPerformed

    private void combomonhocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combomonhocMouseReleased
        
    }//GEN-LAST:event_combomonhocMouseReleased

    private void combomonhocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combomonhocMouseClicked
        
    }//GEN-LAST:event_combomonhocMouseClicked

    private void combomonhocPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_combomonhocPropertyChange
        
    }//GEN-LAST:event_combomonhocPropertyChange

    private void combomonhocVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_combomonhocVetoableChange
        
    }//GEN-LAST:event_combomonhocVetoableChange

    private void combomonhocCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_combomonhocCaretPositionChanged
       
    }//GEN-LAST:event_combomonhocCaretPositionChanged

    private void combomonhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomonhocActionPerformed
        StaticVariable.GV_MAMONHOC = combomonhoc.getSelectedItem() + "";
        initDanhSachHocSinh();
    }//GEN-LAST:event_combomonhocActionPerformed

    private void bangdiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangdiemMouseReleased
        label_mahs.setText((String) bangdiem.getValueAt(bangdiem.getSelectedRow(), 0));
        txt_mot.setText(String.valueOf(bangdiem.getValueAt(bangdiem.getSelectedRow(), 3)));
        txt_hai.setText(String.valueOf(bangdiem.getValueAt(bangdiem.getSelectedRow(), 4)));
        txt_diemthi.setText(String.valueOf(bangdiem.getValueAt(bangdiem.getSelectedRow(), 5)));
        String maHS = (String) bangdiem.getValueAt(bangdiem.getSelectedRow(), 0);
        HanhKiem hk = HanhKiemDAO.selectHanhKiem(maHS, StaticVariable.hocKy);
        if(hk.getLoai() == 1) {
            combohanhkiem.setSelectedIndex(0);
        }
        if(hk.getLoai() == 2) {
            combohanhkiem.setSelectedIndex(1);
        }
        if(hk.getLoai() == 3) {
            combohanhkiem.setSelectedIndex(2);
        }
        if(hk.getLoai() == 4) {
            combohanhkiem.setSelectedIndex(3);
        }
    }//GEN-LAST:event_bangdiemMouseReleased

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        int x = 0, y = 0, z = 0, t = 0;
        try {
            x = DiemDAO.suaDiem(Double.parseDouble(txt_mot.getText()), label_mahs.getText(), StaticVariable.GV_MAMONHOC, 1);
            y = DiemDAO.suaDiem(Double.parseDouble(txt_hai.getText()), label_mahs.getText(), StaticVariable.GV_MAMONHOC, 2);
            z = DiemDAO.suaDiem(Double.parseDouble(txt_diemthi.getText()), label_mahs.getText(), StaticVariable.GV_MAMONHOC, 3);
            t = HanhKiemDAO.suaHanhKiem(label_mahs.getText(), StaticVariable.hocKy, combohanhkiem.getSelectedIndex() + 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi Nhập Liệu", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        if(x == 1 && y == 1 && z == 1 && t == 1) {
            JOptionPane.showMessageDialog(null, "Lưu Điểm Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            initDanhSachHocSinh();
        }  else {
            JOptionPane.showMessageDialog(null, "Lưu Không Thành Công", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_luuActionPerformed

 
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhapDiemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapDiemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapDiemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapDiemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapDiemUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangdiem;
    private javax.swing.JButton btn_luu;
    private javax.swing.JComboBox<String> combohanhkiem;
    private javax.swing.JComboBox<String> combomonhoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_lop;
    private javax.swing.JLabel label_mahs;
    private javax.swing.JTextField txt_diemthi;
    private javax.swing.JTextField txt_hai;
    private javax.swing.JTextField txt_mot;
    // End of variables declaration//GEN-END:variables
}
