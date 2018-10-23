
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HocSinhDAO {
    public static List<HocSinh> selectAllHocSinhTheoMaLop(String maLop) {
        List<HocSinh> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        HocSinh hs;
        Timestamp ts;
        try {
            sql.append("select * from hocsinh where malop = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maLop);
            rs = pre.executeQuery();
            while(rs.next()) {
                hs = new HocSinh();
                hs.setMaHocSinh(rs.getString(1));
                hs.setHo(rs.getString(2));
                hs.setTen(rs.getString(3));
                ts = new Timestamp(rs.getDate(4).getTime());
                hs.setNgaySinh(ts);
                hs.setGioiTinh(rs.getBoolean(5));
                hs.setPassword(rs.getString(6));
                hs.setMaLop(maLop);
                list.add(hs);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
    public static HocSinh selectHocSinh(String maHocSinh) {
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        HocSinh hs = new HocSinh();
        Timestamp ts;
        try {
            sql.append("select * from hocsinh where mahocsinh = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maHocSinh);
            rs = pre.executeQuery();
            while(rs.next()) {
                hs.setMaHocSinh(rs.getString(1));
                hs.setHo(rs.getString(2));
                hs.setTen(rs.getString(3));
                ts = new Timestamp(rs.getDate(4).getTime());
                hs.setNgaySinh(ts);
                hs.setGioiTinh(rs.getBoolean(5));
                hs.setPassword(rs.getString(6));
                hs.setMaLop(rs.getString(7));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return hs;
    }
    
    public static int insertHocSinh(String ho, String ten, boolean gioiTinh, String password, Timestamp ngaySinh, String maHocSinh, String maLop) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into hocsinh values(?, ?, ?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maHocSinh);
           pre.setString(2, ho);
           pre.setString(3, ten);
           pre.setTimestamp(4, ngaySinh);
           pre.setBoolean(5, gioiTinh);
           pre.setString(6,password);
           pre.setString(7, maLop);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    public static int deleteHocSinh(String maHocSinh) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "delete from hocsinh where mahocsinh = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maHocSinh);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int suaThongTinHocSinh(String maHocSinh) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "update hocsinh set ho = ?, ten = ?, ngaysinh = ?, gioitinh = ? where mahocsinh = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, StaticVariable.GV_HOHS);
            pre.setString(2, StaticVariable.GV_TENHS);
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            try {
                date = (Date) formatter.parse(StaticVariable.GV_NGAYSINHHS);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Timestamp timeStampDate = new Timestamp(date.getTime());
            pre.setTimestamp(3, timeStampDate);
            pre.setBoolean(4, StaticVariable.GV_GIOITINHHS);
            pre.setString(5, maHocSinh);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int doiMatKhauHocSinh(String mkMoi) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "update hocsinh set password = ? where mahocsinh = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, mkMoi);
            pre.setString(2, StaticVariable.PH_MAHOCSINH);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean checkPhuHuynhDangNhap(String maHocSinh, String password) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from hocsinh where (mahocsinh = ? and password = ?)";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maHocSinh);
            pre.setString(2, password);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maHocSinh) && rs.getString(6).equals(password)) {
                    check = true;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static boolean checkMaHocSinhCoTrongHeThong(String maHocSinh) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from hocsinh where mahocsinh = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maHocSinh);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maHocSinh)) {
                    check = true;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
