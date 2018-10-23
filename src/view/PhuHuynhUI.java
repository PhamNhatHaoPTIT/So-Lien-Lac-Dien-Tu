
package view;

import java.awt.Font;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import model.LopDAO;
import model.MonHoc;
import model.MonHocDAO;
import model.StaticVariable;
import static view.GiaoVienUI.danhsachhocsinh;


public class PhuHuynhUI extends javax.swing.JFrame {

  
    public PhuHuynhUI() {
        initComponents();
        hienThiThongTinHocSinh();
        hienThiBangDiemHocSinh();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/images/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setIconImage(im);
    }
    
    private double tbHocKyI = 0, tbHocKyII = 0;
    private boolean check = false;
    
    private void hienThiThongTinHocSinh() {
        HocSinh hs = HocSinhDAO.selectHocSinh(StaticVariable.PH_MAHOCSINH);
        label_mahs.setText(hs.getMaHocSinh());
        label_ho.setText(hs.getHo());
        label_ten.setText(hs.getTen());
        label_ngaysinh.setText(new SimpleDateFormat("dd.MM.yyyy").format(hs.getNgaySinh()));
        if(hs.getGioiTinh()) {
            label_gioitinh.setText("Nam");
        } else {
            label_gioitinh.setText("Nữ");
        }
    }

    private void hienThiBangDiemHocSinh() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //(DefaultTableCellRenderer)
        bangdiem.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        ((DefaultTableCellRenderer)bangdiem.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        bangdiem.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        bangdiem.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        DefaultTableModel dtm = (DefaultTableModel) bangdiem.getModel();
        dtm.setRowCount(0);
        int i = 1;
        LopDAO.layMaLopTuMaHocSinh();
        List<MonHoc> listMH = MonHocDAO.selectAllMonHocTheoMaLop(StaticVariable.PH_MALOP);
        Diem temp = new Diem();
        double tb;
        DecimalFormat format = new DecimalFormat("#.##");
        for (MonHoc x : listMH) {
            Vector<Object> vec = new Vector<>();
            vec.add(i); i++;
            vec.add(x.getTenMonHoc());
            tb = 0;
            temp = DiemDAO.selectDiem(StaticVariable.PH_MAHOCSINH, x.getMaMonHoc(), 1);
            vec.add(temp.getDiem());
            tb += temp.getDiem();
            temp = DiemDAO.selectDiem(StaticVariable.PH_MAHOCSINH, x.getMaMonHoc(), 2);
            vec.add(temp.getDiem());
            tb += temp.getDiem() * 2;
            temp = DiemDAO.selectDiem(StaticVariable.PH_MAHOCSINH, x.getMaMonHoc(), 3);
            vec.add(temp.getDiem());
            tb += temp.getDiem() * 3;
            tb /= 6;
            if(tb < 5) {
                check = true;
            }
            if(combohocky.getSelectedIndex() == 0) {
                tbHocKyI += tb;
            } else {
                tbHocKyII += tb;
            }
            vec.add(format.format(tb));
            dtm.addRow(vec);
        }
        tbHocKyI /= listMH.size();
        tbHocKyII /= listMH.size();
        if(combohocky.getSelectedIndex() == 0) {
            label_tb.setText(String.valueOf(format.format(tbHocKyI)));
            HanhKiem hk = HanhKiemDAO.selectHanhKiem(StaticVariable.PH_MAHOCSINH, 1);
            if(hk.getLoai() == 1) {
                label_hanhkiem.setText("Tốt");
            }
            if(hk.getLoai() == 2) {
                label_hanhkiem.setText("Khá");
            }
            if(hk.getLoai() == 3) {
                label_hanhkiem.setText("Trung Bình");
            }
            if(hk.getLoai() == 4) {
                label_hanhkiem.setText("Yếu");
            }
            // xếp loại học lực
            if(tbHocKyI > 9) {
                if(hk.getLoai() == 1 && check == false) {
                    label_hocluc.setText("Xuất sắc");
                } else {
                    label_hocluc.setText("Giỏi");
                }
            } else if(tbHocKyI > 8 && check == false) {
                if(hk.getLoai() == 1) {
                    label_hocluc.setText("Giỏi");
                } else {
                    label_hocluc.setText("Khá");
                }
            } else if(tbHocKyI > 6.5 && check == false) {
                if(hk.getLoai() == 1 || hk.getLoai() == 2) {
                    label_hocluc.setText("Khá");
                } else {
                    label_hocluc.setText("Trung Bình");
                }
            } else if(tbHocKyI > 4) {
                if(hk.getLoai() == 1 || hk.getLoai() == 2 || hk.getLoai() == 3) {
                    label_hocluc.setText("Trung Bình");
                } else {
                    label_hocluc.setText("Yếu");
                }
            } else {
                label_hocluc.setText("Yếu");
            }
        } else {
            label_tb.setText(String.valueOf(format.format(tbHocKyII)));
            HanhKiem hk = HanhKiemDAO.selectHanhKiem(StaticVariable.PH_MAHOCSINH, 2);
            if(hk.getLoai() == 1) {
                label_hanhkiem.setText("Tốt");
            }
            if(hk.getLoai() == 2) {
                label_hanhkiem.setText("Khá");
            }
            if(hk.getLoai() == 3) {
                label_hanhkiem.setText("Trung Bình");
            }
            if(hk.getLoai() == 4) {
                label_hanhkiem.setText("Yếu");
            }
            if(tbHocKyII > 9) {
                if(hk.getLoai() == 1 && check == false) {
                    label_hocluc.setText("Xuất sắc");
                } else {
                    label_hocluc.setText("Giỏi");
                }
            } else if(tbHocKyII > 8 && check == false) {
                if(hk.getLoai() == 1) {
                    label_hocluc.setText("Giỏi");
                } else {
                    label_hocluc.setText("Khá");
                }
            } else if(tbHocKyII > 6.5 && check == false) {
                if(hk.getLoai() == 1 || hk.getLoai() == 2) {
                    label_hocluc.setText("Khá");
                } else {
                    label_hocluc.setText("Trung Bình");
                }
            } else if(tbHocKyII > 4) {
                if(hk.getLoai() == 1 || hk.getLoai() == 2 || hk.getLoai() == 3) {
                    label_hocluc.setText("Trung Bình");
                } else {
                    label_hocluc.setText("Yếu");
                }
            } else {
                label_hocluc.setText("Yếu");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangdiem = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_mahs = new javax.swing.JLabel();
        label_ho = new javax.swing.JLabel();
        label_ten = new javax.swing.JLabel();
        label_ngaysinh = new javax.swing.JLabel();
        label_gioitinh = new javax.swing.JLabel();
        combohocky = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_tb = new javax.swing.JLabel();
        label_hanhkiem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_hocluc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        chucnang = new javax.swing.JMenu();
        guithongbao = new javax.swing.JMenuItem();
        xemthongbao = new javax.swing.JMenuItem();
        doimatkhau = new javax.swing.JMenuItem();
        thoat = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        gioithieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sổ Liên Lạc Điện Tử");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bảng Điểm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        bangdiem.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên môn học", "Điểm hệ số 1", "Điểm hệ số 2", "Điểm thi", "Trung bình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangdiem.setGridColor(new java.awt.Color(255, 255, 255));
        bangdiem.setRowHeight(22);
        jScrollPane1.setViewportView(bangdiem);
        if (bangdiem.getColumnModel().getColumnCount() > 0) {
            bangdiem.getColumnModel().getColumn(0).setResizable(false);
            bangdiem.getColumnModel().getColumn(0).setPreferredWidth(20);
            bangdiem.getColumnModel().getColumn(1).setResizable(false);
            bangdiem.getColumnModel().getColumn(2).setResizable(false);
            bangdiem.getColumnModel().getColumn(3).setResizable(false);
            bangdiem.getColumnModel().getColumn(4).setResizable(false);
            bangdiem.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 760, 400));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 10, 590));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thông tin học sinh");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã học sinh: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày sinh: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Giới tính: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Họ: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        label_mahs.setBackground(new java.awt.Color(0, 0, 0));
        label_mahs.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_mahs.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_mahs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, 20));

        label_ho.setBackground(new java.awt.Color(0, 0, 0));
        label_ho.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ho.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_ho, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 110, 20));

        label_ten.setBackground(new java.awt.Color(0, 0, 0));
        label_ten.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ten.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 90, 20));

        label_ngaysinh.setBackground(new java.awt.Color(0, 0, 0));
        label_ngaysinh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_ngaysinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 110, 20));

        label_gioitinh.setBackground(new java.awt.Color(0, 0, 0));
        label_gioitinh.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_gioitinh.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 90, 20));

        combohocky.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        combohocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học Kỳ 1", "Học Kỳ 2" }));
        combohocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohockyActionPerformed(evt);
            }
        });
        jPanel1.add(combohocky, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 170, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Trung Bình Học Kỳ: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 160, 20));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Hạnh Kiểm: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 160, 20));

        label_tb.setBackground(new java.awt.Color(0, 0, 0));
        label_tb.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_tb.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 80, 20));

        label_hanhkiem.setBackground(new java.awt.Color(0, 0, 0));
        label_hanhkiem.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_hanhkiem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_hanhkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 90, 20));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Học Lực: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, -1, -1));

        label_hocluc.setBackground(new java.awt.Color(0, 0, 0));
        label_hocluc.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        label_hocluc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label_hocluc, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 110, 20));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel2.setText("Thong tinhoc5 sinh");
        jLabel2.setMaximumSize(new java.awt.Dimension(830, 550));
        jLabel2.setPreferredSize(new java.awt.Dimension(830, 550));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 2430, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 590));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        chucnang.setBackground(new java.awt.Color(255, 255, 255));
        chucnang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tool.png"))); // NOI18N
        chucnang.setText("Chức năng");
        chucnang.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        guithongbao.setBackground(new java.awt.Color(255, 255, 255));
        guithongbao.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        guithongbao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        guithongbao.setText("Gửi thư đến giáo viên");
        guithongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guithongbaoActionPerformed(evt);
            }
        });
        chucnang.add(guithongbao);

        xemthongbao.setBackground(new java.awt.Color(255, 255, 255));
        xemthongbao.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        xemthongbao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        xemthongbao.setText("Xem thông báo");
        xemthongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemthongbaoActionPerformed(evt);
            }
        });
        chucnang.add(xemthongbao);

        doimatkhau.setBackground(new java.awt.Color(255, 255, 255));
        doimatkhau.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        doimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        doimatkhau.setText("Thay đổi mật khẩu");
        doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doimatkhauActionPerformed(evt);
            }
        });
        chucnang.add(doimatkhau);

        thoat.setBackground(new java.awt.Color(255, 255, 255));
        thoat.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });
        chucnang.add(thoat);

        menu.add(chucnang);

        help.setBackground(new java.awt.Color(255, 255, 255));
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        help.setText("Trợ giúp");
        help.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        gioithieu.setBackground(new java.awt.Color(255, 255, 255));
        gioithieu.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        gioithieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        gioithieu.setText("Giới thiệu");
        gioithieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gioithieuActionPerformed(evt);
            }
        });
        help.add(gioithieu);

        menu.add(help);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(1073, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void guithongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guithongbaoActionPerformed
        GuiMailGiaoVienUI mail = new GuiMailGiaoVienUI();
        mail.setVisible(true);
    }//GEN-LAST:event_guithongbaoActionPerformed

    private void xemthongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemthongbaoActionPerformed
        XemThongBaoUI xem = new XemThongBaoUI();
        xem.setVisible(true);
    }//GEN-LAST:event_xemthongbaoActionPerformed

    private void gioithieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gioithieuActionPerformed
        GioiThieuUI gt = new GioiThieuUI();
        gt.setVisible(true);
    }//GEN-LAST:event_gioithieuActionPerformed

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát Không?", "Xác Nhận", JOptionPane.CLOSED_OPTION);
        if(x == 1) {
            return;
        }
        if(x == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_thoatActionPerformed

    private void doimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doimatkhauActionPerformed
        DoiMatKhauUI doi = new DoiMatKhauUI();
        doi.setVisible(true);
    }//GEN-LAST:event_doimatkhauActionPerformed

    private void combohockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohockyActionPerformed
        StaticVariable.hocKy = combohocky.getSelectedIndex() + 1;
        hienThiBangDiemHocSinh();
    }//GEN-LAST:event_combohockyActionPerformed

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
            java.util.logging.Logger.getLogger(PhuHuynhUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhuHuynhUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhuHuynhUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhuHuynhUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhuHuynhUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangdiem;
    private javax.swing.JMenu chucnang;
    private javax.swing.JComboBox<String> combohocky;
    private javax.swing.JMenuItem doimatkhau;
    private javax.swing.JMenuItem gioithieu;
    private javax.swing.JMenuItem guithongbao;
    private javax.swing.JMenu help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_gioitinh;
    private javax.swing.JLabel label_hanhkiem;
    private javax.swing.JLabel label_ho;
    private javax.swing.JLabel label_hocluc;
    private javax.swing.JLabel label_mahs;
    private javax.swing.JLabel label_ngaysinh;
    private javax.swing.JLabel label_tb;
    private javax.swing.JLabel label_ten;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem thoat;
    private javax.swing.JMenuItem xemthongbao;
    // End of variables declaration//GEN-END:variables
}
