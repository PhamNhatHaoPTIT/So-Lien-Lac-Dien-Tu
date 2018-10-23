
package view;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Splash extends javax.swing.JFrame {

 
    public Splash() {
        initComponents();
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
        chay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        num = new javax.swing.JLabel();
        pro = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sổ Liên Lạc Điện Tử");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 570, 50));

        chay.setBackground(new java.awt.Color(0, 0, 0));
        chay.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        chay.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(chay, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 70, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 360, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 550, 10));

        num.setBackground(new java.awt.Color(0, 0, 0));
        num.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        num.setForeground(new java.awt.Color(255, 255, 255));
        num.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        num.setText("99%");
        jPanel1.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 80, 60));

        pro.setBackground(new java.awt.Color(0, 0, 0));
        pro.setForeground(new java.awt.Color(255, 0, 51));
        pro.setBorderPainted(false);
        pro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 550, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        setSize(new java.awt.Dimension(820, 429));
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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Splash sp = new Splash();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sp.setVisible(true);
            }
        });
        try {
            for(int i = 0; i <= 100; i++) {
                Thread.sleep(70);
                sp.num.setText(Integer.toString(i) + "%");
                sp.pro.setValue(i);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        new Splash().setVisible(false);
        DangNhapUI dangnhap = new DangNhapUI();
        dangnhap.setVisible(true);
        sp.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel chay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel num;
    public javax.swing.JProgressBar pro;
    // End of variables declaration//GEN-END:variables
}
