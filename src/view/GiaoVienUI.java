
package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.GiaoVien;
import model.GiaoVienDAO;
import model.HocSinh;
import model.HocSinhDAO;
import model.Lop;
import model.LopDAO;
import model.StaticVariable;


public class GiaoVienUI extends javax.swing.JFrame {

 
    public GiaoVienUI() {
        initComponents();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
        hienThiThongTinGiaoVien();
        hienThiBangDanhSachHocSinh();
        Lop l = LopDAO.selectLopTheoMaGiaoVien(StaticVariable.GV_MAGV);
        List<HocSinh> list = HocSinhDAO.selectAllHocSinhTheoMaLop(StaticVariable.GV_MALOP);
        if(list.size() >= l.getSiSo()) {
            jLabel2.setEnabled(false);
            them.setEnabled(false);
        }
    }
    
    public static void hienThiThongTinGiaoVien() {
        GiaoVien gv = GiaoVienDAO.selectGiaoVien(StaticVariable.GV_MAGV);
        label_magiaovien.setText(gv.getMaGiaoVien());
        label_ho.setText(gv.getHo());
        label_ten.setText(gv.getTen());
        if(gv.getGioiTinh()) {
            label_gioitinh.setText("Nam");
        }
        else {
            label_gioitinh.setText("Nữ");
        }
        Timestamp ngay = gv.getNgaySinh();
        String temp = new SimpleDateFormat("dd.MM.yyyy").format(ngay.getTime());
        label_ngaysinh.setText(temp);
    }
    
    public static void hienThiBangDanhSachHocSinh() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //(DefaultTableCellRenderer)
        danhsachhocsinh.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        ((DefaultTableCellRenderer)danhsachhocsinh.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        danhsachhocsinh.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        danhsachhocsinh.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        danhsachhocsinh.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        danhsachhocsinh.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        danhsachhocsinh.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        danhsachhocsinh.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        DefaultTableModel dtm = (DefaultTableModel) danhsachhocsinh.getModel();
        dtm.setRowCount(0);
        List<HocSinh> list = HocSinhDAO.selectAllHocSinhTheoMaLop(StaticVariable.GV_MALOP);
        int i = 1;
        String timeStamp;
        for (HocSinh hs : list) {
            Vector<Object> vec = new Vector<>();
            vec.add(i);
            i++;
            vec.add(hs.getMaHocSinh());
            vec.add(hs.getHo());
            vec.add(hs.getTen());
            timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(hs.getNgaySinh());
            vec.add(timeStamp);
            if(hs.getGioiTinh()) {
                vec.add("Nam");
            }
            else {
                vec.add("Nữ");
            }
            dtm.addRow(vec);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        them = new javax.swing.JMenuItem();
        xoa = new javax.swing.JMenuItem();
        sua = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_magiaovien = new javax.swing.JLabel();
        label_ho = new javax.swing.JLabel();
        label_ten = new javax.swing.JLabel();
        label_gioitinh = new javax.swing.JLabel();
        label_ngaysinh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhsachhocsinh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        combohocky = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        chucnang = new javax.swing.JMenu();
        guithongbao = new javax.swing.JMenuItem();
        xemthongbao = new javax.swing.JMenuItem();
        doimatkhau = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        quanlidaotao = new javax.swing.JMenu();
        monhoc = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        popup.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        them.setBackground(new java.awt.Color(255, 255, 255));
        them.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        them.setText("Thêm học sinh");
        them.setBorder(null);
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        popup.add(them);

        xoa.setBackground(new java.awt.Color(255, 255, 255));
        xoa.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        xoa.setText("Xóa học sinh");
        xoa.setBorder(null);
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        popup.add(xoa);

        sua.setBackground(new java.awt.Color(255, 255, 255));
        sua.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_2.png"))); // NOI18N
        sua.setText("Sửa thông tin");
        sua.setBorder(null);
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        popup.add(sua);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sổ Liên Lạc Điện Tử");
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(830, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(830, 550));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã Giáo Viên: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        label_magiaovien.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_magiaovien.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_magiaovien, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 150, 30));

        label_ho.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ho.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_ho, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, 30));

        label_ten.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ten.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 210, 150, 30));

        label_gioitinh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_gioitinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 150, 30));

        label_ngaysinh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ngaysinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(label_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 150, 40));

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Giới Tính: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh Sách Học Sinh");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 270, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        danhsachhocsinh.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        danhsachhocsinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HS", "Họ", "Tên", "Ngày sinh", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        danhsachhocsinh.setGridColor(new java.awt.Color(255, 255, 255));
        danhsachhocsinh.setRowHeight(22);
        danhsachhocsinh.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                danhsachhocsinhAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        danhsachhocsinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhsachhocsinhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                danhsachhocsinhMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                danhsachhocsinhMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(danhsachhocsinh);
        if (danhsachhocsinh.getColumnModel().getColumnCount() > 0) {
            danhsachhocsinh.getColumnModel().getColumn(0).setResizable(false);
            danhsachhocsinh.getColumnModel().getColumn(0).setPreferredWidth(20);
            danhsachhocsinh.getColumnModel().getColumn(1).setResizable(false);
            danhsachhocsinh.getColumnModel().getColumn(1).setPreferredWidth(20);
            danhsachhocsinh.getColumnModel().getColumn(2).setResizable(false);
            danhsachhocsinh.getColumnModel().getColumn(3).setResizable(false);
            danhsachhocsinh.getColumnModel().getColumn(4).setResizable(false);
            danhsachhocsinh.getColumnModel().getColumn(4).setPreferredWidth(70);
            danhsachhocsinh.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 660, 420));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel2.setText("Thêm học sinh");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 160, -1));

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ngày Sinh: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Họ: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thông Tin Giáo Viên");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 0, 10, 610));

        combohocky.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        combohocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học Kỳ 1", "Học Kỳ 2" }));
        combohocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohockyActionPerformed(evt);
            }
        });
        jPanel3.add(combohocky, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 170, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setPreferredSize(new java.awt.Dimension(830, 550));
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-310, 0, 1320, 620));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 600));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        chucnang.setBackground(new java.awt.Color(255, 255, 255));
        chucnang.setBorder(null);
        chucnang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tool.png"))); // NOI18N
        chucnang.setText("Chức năng");
        chucnang.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        guithongbao.setBackground(new java.awt.Color(255, 255, 255));
        guithongbao.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        guithongbao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        guithongbao.setText("Gửi thông báo");
        guithongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guithongbaoActionPerformed(evt);
            }
        });
        chucnang.add(guithongbao);

        xemthongbao.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        xemthongbao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        xemthongbao.setText("Xem email");
        xemthongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemthongbaoActionPerformed(evt);
            }
        });
        chucnang.add(xemthongbao);

        doimatkhau.setBackground(new java.awt.Color(255, 255, 255));
        doimatkhau.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        doimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        doimatkhau.setText("Thay đổi mật khẩu");
        doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doimatkhauActionPerformed(evt);
            }
        });
        chucnang.add(doimatkhau);

        jMenuItem3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jMenuItem3.setText("Sửa thông tin");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        chucnang.add(jMenuItem3);

        jMenuItem4.setText("Danh sách học sinh giỏi");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        chucnang.add(jMenuItem4);

        jMenuItem1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jMenuItem1.setText("Thoát");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        chucnang.add(jMenuItem1);

        menu.add(chucnang);

        quanlidaotao.setBackground(new java.awt.Color(255, 255, 255));
        quanlidaotao.setBorder(null);
        quanlidaotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/education.png"))); // NOI18N
        quanlidaotao.setText("Quản lí đào tạo");
        quanlidaotao.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        monhoc.setBackground(new java.awt.Color(255, 255, 255));
        monhoc.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        monhoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/subject.png"))); // NOI18N
        monhoc.setText("Môn học");
        monhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monhocActionPerformed(evt);
            }
        });
        quanlidaotao.add(monhoc);

        jMenuItem2.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mark.png"))); // NOI18N
        jMenuItem2.setText("Nhập điểm");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        quanlidaotao.add(jMenuItem2);

        menu.add(quanlidaotao);

        help.setBackground(new java.awt.Color(255, 255, 255));
        help.setBorder(null);
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        help.setText("Trợ giúp");
        help.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        about.setBackground(new java.awt.Color(255, 255, 255));
        about.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        about.setText("Giới thiệu");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        menu.add(help);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(1016, 646));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void monhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monhocActionPerformed
        MonHocUI ui = new MonHocUI();
        ui.setVisible(true);
    }//GEN-LAST:event_monhocActionPerformed

    private void danhsachhocsinhAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_danhsachhocsinhAncestorAdded
        
    }//GEN-LAST:event_danhsachhocsinhAncestorAdded

    private void danhsachhocsinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhsachhocsinhMouseClicked
        
    }//GEN-LAST:event_danhsachhocsinhMouseClicked

    private void danhsachhocsinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhsachhocsinhMousePressed
        
    }//GEN-LAST:event_danhsachhocsinhMousePressed

    private void danhsachhocsinhMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhsachhocsinhMouseReleased
        if(evt.isPopupTrigger()) {
            int row = danhsachhocsinh.rowAtPoint(evt.getPoint());
            int col = danhsachhocsinh.columnAtPoint(evt.getPoint());
            if(!danhsachhocsinh.isRowSelected(row)) {
                danhsachhocsinh.changeSelection(row, col, false, false);
            }
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_danhsachhocsinhMouseReleased

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        ThemHocSinhUI them = new ThemHocSinhUI();
        them.setVisible(true);
    }//GEN-LAST:event_themActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        String maHS = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 1);
        int x = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Học Sinh?", "Xác Nhận", JOptionPane.YES_NO_CANCEL_OPTION);
        if(x == 0) {
            if(HocSinhDAO.deleteHocSinh(maHS) > 0) {
                JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiBangDanhSachHocSinh();
            }
            else {
                JOptionPane.showMessageDialog(null, "Xóa Không Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(x == 1) {
            return;
        }
    }//GEN-LAST:event_xoaActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        StaticVariable.GV_MAHS = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 1);
        StaticVariable.GV_HOHS = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 2);
        StaticVariable.GV_TENHS = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 3);
        StaticVariable.GV_NGAYSINHHS = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 4);
        String temp = (String) danhsachhocsinh.getValueAt(danhsachhocsinh.getSelectedRow(), 5);
        if(temp.equals("Nam")) {
            StaticVariable.GV_GIOITINHHS = true;
        }
        else {
            StaticVariable.GV_GIOITINHHS = false;
        }
        SuaThongTinHocSinhUI sua = new SuaThongTinHocSinhUI();
        sua.setVisible(true);
    }//GEN-LAST:event_suaActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        GioiThieuUI gt = new GioiThieuUI();
        gt.setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed

    private void guithongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guithongbaoActionPerformed
        GuiThongBaoUI gui = new GuiThongBaoUI();
        gui.setVisible(true);
    }//GEN-LAST:event_guithongbaoActionPerformed

    private void xemthongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemthongbaoActionPerformed
        XemMailTuPhuHuynhUI xem = new XemMailTuPhuHuynhUI();
        xem.setVisible(true);
    }//GEN-LAST:event_xemthongbaoActionPerformed

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        ThemHocSinhUI them = new ThemHocSinhUI();
        them.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseReleased

    private void doimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doimatkhauActionPerformed
        DoiMatKhauUI doi = new DoiMatKhauUI();
        doi.setVisible(true);
    }//GEN-LAST:event_doimatkhauActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát Không?", "Xác Nhận", JOptionPane.CLOSED_OPTION);
        if(x == 1) {
            return;
        }
        if(x == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        NhapDiemUI ui = new NhapDiemUI();
        ui.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void combohockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohockyActionPerformed
        StaticVariable.hocKy = combohocky.getSelectedIndex() + 1;
    }//GEN-LAST:event_combohockyActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        SuaThongTinGiaoVienUI sua = new SuaThongTinGiaoVienUI();
        sua.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        DanhSachHocSinhGioiUI ds = new DanhSachHocSinhGioiUI();
        ds.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

 
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
            java.util.logging.Logger.getLogger(GiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoVienUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu chucnang;
    private javax.swing.JComboBox<String> combohocky;
    public static javax.swing.JTable danhsachhocsinh;
    private javax.swing.JMenuItem doimatkhau;
    private javax.swing.JMenuItem guithongbao;
    private javax.swing.JMenu help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel label_gioitinh;
    public static javax.swing.JLabel label_ho;
    public static javax.swing.JLabel label_magiaovien;
    public static javax.swing.JLabel label_ngaysinh;
    public static javax.swing.JLabel label_ten;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem monhoc;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JMenu quanlidaotao;
    private javax.swing.JMenuItem sua;
    private javax.swing.JMenuItem them;
    private javax.swing.JMenuItem xemthongbao;
    private javax.swing.JMenuItem xoa;
    // End of variables declaration//GEN-END:variables
}
