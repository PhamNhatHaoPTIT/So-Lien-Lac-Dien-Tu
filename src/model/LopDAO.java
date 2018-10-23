
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;

public class LopDAO {
    public static Lop selectLopTheoMaGiaoVien(String maGiaoVien) {
        Lop l = new Lop();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql.append("select * from lop where magiaovien = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maGiaoVien);
            rs = pre.executeQuery();
            while(rs.next()) {
                l.setMaLop(rs.getString(1));
                l.setTenLop(rs.getNString(2));
                l.setKhoa(rs.getString(3));
                l.setSiSo(rs.getInt(4));
                l.setMaGiaoVien(maGiaoVien);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return l;
    }
    public static int insertLop(String maLop, String tenLop, String khoa, int siso, String maGiaoVien) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into lop values(?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maLop);
           pre.setNString(2, tenLop);
           pre.setString(3, khoa);
           pre.setInt(4, siso);
           pre.setString(5, maGiaoVien);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /*public static int deleteLop(String maLop) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "delete from lop where malop = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maLop);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/
    public static boolean checkMaLopCoTrongHeThong(String maLop) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from lop where malop = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maLop);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maLop)) {
                    check = true;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static void layMaLopTuMaGiaoVien() {
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from lop where magiaovien = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, StaticVariable.GV_MAGV);
            rs = pre.executeQuery();
            while(rs.next()) {
                StaticVariable.GV_MALOP = rs.getString(1);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void layMaLopTuMaHocSinh() {
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from hocsinh where mahocsinh = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, StaticVariable.PH_MAHOCSINH);
            rs = pre.executeQuery();
            while(rs.next()) {
                StaticVariable.GV_MALOP = rs.getString(7);
                StaticVariable.PH_MALOP = StaticVariable.GV_MALOP;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void layMaGiaoVienTuMaLop() {
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from lop where malop = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, StaticVariable.PH_MALOP);
            rs = pre.executeQuery();
            while(rs.next()) {
                StaticVariable.PH_MAGIAOVIEN = rs.getString(5);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
