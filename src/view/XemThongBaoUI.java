package view;

import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.StaticVariable;
import model.ThongBaoCaNhan;
import model.ThongBaoCaNhanDAO;
import model.ThongBaoChung;
import model.ThongBaoChungDAO;

public class XemThongBaoUI extends javax.swing.JFrame {

  
    public XemThongBaoUI() {
        initComponents();
        hienThiNoiDungThongBao();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }

    private void hienThiNoiDungThongBao() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        ((DefaultTableCellRenderer)bangthongbao.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        bangthongbao.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DefaultTableModel dtm = (DefaultTableModel) bangthongbao.getModel();
        dtm.setRowCount(0);
        List<ThongBaoCaNhan> list = ThongBaoCaNhanDAO.selectAllThongBaoTheoMaHocSinh(StaticVariable.PH_MAHOCSINH);
        String timeStamp;
        for (ThongBaoCaNhan x : list) {
            Vector<Object> vec = new Vector<>();
            vec.add(x.getNoiDung());
            timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(x.getNgay());
            vec.add(timeStamp);
            dtm.addRow(vec);
        }
        List<ThongBaoChung> listc = ThongBaoChungDAO.selectAllThongBaoTheoMaLop(StaticVariable.PH_MALOP);
        for (ThongBaoChung x : listc) {
            Vector<Object> vec = new Vector<>();
            vec.add(x.getNoiDung());
            timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(x.getNgay());
            vec.add(timeStamp);
            dtm.addRow(vec);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bangthongbao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Email");
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        bangthongbao.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        bangthongbao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nội dung", "Ngày nhận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangthongbao.setGridColor(new java.awt.Color(255, 255, 255));
        bangthongbao.setRowHeight(22);
        jScrollPane1.setViewportView(bangthongbao);
        if (bangthongbao.getColumnModel().getColumnCount() > 0) {
            bangthongbao.getColumnModel().getColumn(0).setPreferredWidth(400);
            bangthongbao.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(716, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
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
            java.util.logging.Logger.getLogger(XemThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemThongBaoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemThongBaoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangthongbao;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
