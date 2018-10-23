
package view;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Lop;
import model.LopDAO;
import model.MonHoc;
import model.MonHocDAO;
import model.StaticVariable;
import static view.GiaoVienUI.danhsachhocsinh;


public class MonHocUI extends javax.swing.JFrame {

 
    public MonHocUI() {
        initComponents();
        hienThiThongTin();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }

    public static void hienThiThongTin() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //(DefaultTableCellRenderer)
        bangmonhoc.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        ((DefaultTableCellRenderer)bangmonhoc.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        bangmonhoc.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        bangmonhoc.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        bangmonhoc.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        Lop l = LopDAO.selectLopTheoMaGiaoVien(StaticVariable.GV_MAGV);
        label_lop.setText(l.getTenLop());
        DefaultTableModel dtm = (DefaultTableModel) bangmonhoc.getModel();
        dtm.setRowCount(0);
        List<MonHoc> list = MonHocDAO.selectAllMonHocTheoMaLop(l.getMaLop());
        for (MonHoc m : list) {
            Vector<Object> vec = new Vector<>();
            vec.add(m.getMaMonHoc());
            vec.add(m.getTenMonHoc());
            vec.add(m.getGhiChu());
            dtm.addRow(vec);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_lop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangmonhoc = new javax.swing.JTable();
        btn_themmonhoc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Môn Học");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_lop.setBackground(new java.awt.Color(0, 0, 0));
        label_lop.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_lop.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 17));

        bangmonhoc.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        bangmonhoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã môn học", "Tên môn học", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangmonhoc.setGridColor(new java.awt.Color(255, 255, 255));
        bangmonhoc.setRowHeight(22);
        jScrollPane1.setViewportView(bangmonhoc);
        if (bangmonhoc.getColumnModel().getColumnCount() > 0) {
            bangmonhoc.getColumnModel().getColumn(0).setResizable(false);
            bangmonhoc.getColumnModel().getColumn(1).setResizable(false);
            bangmonhoc.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 690, 400));

        btn_themmonhoc.setBackground(new java.awt.Color(255, 255, 255));
        btn_themmonhoc.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btn_themmonhoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_themmonhoc.setText("Thêm môn học");
        btn_themmonhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themmonhocActionPerformed(evt);
            }
        });
        jPanel1.add(btn_themmonhoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 760, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 540));

        setSize(new java.awt.Dimension(749, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themmonhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themmonhocActionPerformed
        ThemMonHocUI them = new ThemMonHocUI();
        them.setVisible(true);
    }//GEN-LAST:event_btn_themmonhocActionPerformed

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
            java.util.logging.Logger.getLogger(MonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonHocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonHocUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable bangmonhoc;
    private javax.swing.JButton btn_themmonhoc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel label_lop;
    // End of variables declaration//GEN-END:variables
}
