
package view;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Diem;
import model.DiemDAO;
import model.HocSinh;
import model.HocSinhDAO;
import model.MonHoc;
import model.MonHocDAO;
import model.StaticVariable;
import static view.GiaoVienUI.danhsachhocsinh;


public class DanhSachHocSinhGioiUI extends javax.swing.JFrame {


    public DanhSachHocSinhGioiUI() {
        initComponents();
        hienThiDanhSachHocSinhGioi();
    }
    private double temp = 0;
    private boolean check(String maHocSinh) {
        boolean check = false;
        List<MonHoc> listMH = MonHocDAO.selectAllMonHocTheoMaLop(StaticVariable.GV_MALOP);
        double diemtb = 0;
        double tb = 0;
        Diem d;
        DecimalFormat format = new DecimalFormat("#.##");
        for (MonHoc mh : listMH) {
            diemtb = 0;
            d = DiemDAO.selectDiem(maHocSinh, mh.getMaMonHoc(), 1);
            diemtb += d.getDiem();
            d = DiemDAO.selectDiem(maHocSinh, mh.getMaMonHoc(), 2);
            diemtb += d.getDiem() * 2;
            d = DiemDAO.selectDiem(maHocSinh, mh.getMaMonHoc(), 3);
            diemtb += d.getDiem() * 3;
            diemtb /= 6;
            tb += diemtb;
        }
        tb /= listMH.size();
        
        if(tb >= 8) {
            check = true;
            temp = tb;
        }
        return check;
    }
    
    private void hienThiDanhSachHocSinhGioi() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //(DefaultTableCellRenderer)
        ds.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        ((DefaultTableCellRenderer)ds.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        DefaultTableModel dtm = (DefaultTableModel) ds.getModel();
        DecimalFormat format = new DecimalFormat("#.##");
        dtm.setRowCount(0);
        List<HocSinh> listHS = HocSinhDAO.selectAllHocSinhTheoMaLop(StaticVariable.GV_MALOP);
        for (HocSinh hs : listHS) {
            Vector<Object> vec = new Vector<>();
            if(check(hs.getMaHocSinh())) {
                vec.add(hs.getMaHocSinh());
                vec.add(hs.getHo() + " " + hs.getTen());
                vec.add(format.format(temp));
                dtm.addRow(vec);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ds = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh Sách Học Sinh Giỏi");
        setResizable(false);

        ds.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        ds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Học Sinh", "Họ Tên", "Điểm Trung Bình"
            }
        ));
        ds.setFocusable(false);
        ds.setRowHeight(22);
        jScrollPane1.setViewportView(ds);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(726, 505));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DanhSachHocSinhGioiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinhGioiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinhGioiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinhGioiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachHocSinhGioiUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ds;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
