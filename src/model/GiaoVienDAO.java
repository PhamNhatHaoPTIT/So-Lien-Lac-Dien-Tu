
package model;
import database.Connect;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GiaoVienDAO {
    /*public static List<GiaoVien> selectAllGiaoVien() {
        List<GiaoVien> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        GiaoVien gv = new GiaoVien();
        Timestamp ts;
        try {
            sql.append("select * from giaovien");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            rs = pre.executeQuery();
            while(rs.next()) {
                gv.setMaGiaoVien(rs.getString(1));
                gv.setHo(rs.getString(2));
                gv.setTen(rs.getString(3));
                gv.setGioiTinh(rs.getBoolean(4));
                ts = new Timestamp(rs.getDate(5).getTime());
                gv.setNgaySinh(ts);
                gv.setPassword(rs.getString(6));
                list.add(gv);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }*/
    public static GiaoVien selectGiaoVien(String maGiaoVien) {
        GiaoVien gv = new GiaoVien();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        Timestamp ts;
        try {
            sql.append("select * from giaovien where magiaovien = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maGiaoVien);
            rs = pre.executeQuery();
            while(rs.next()) {
                gv.setMaGiaoVien(rs.getString(1));
                gv.setHo(rs.getString(2));
                gv.setTen(rs.getString(3));
                gv.setGioiTinh(rs.getBoolean(4));
                ts = new Timestamp(rs.getDate(5).getTime());
                gv.setNgaySinh(ts);
                gv.setPassword(rs.getString(6));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return gv;
    }
    public static int insertGiaoVien(String ho, String ten, boolean gioiTinh, String password, Timestamp ngaySinh, String maGiaoVien) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into giaovien values(?, ?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maGiaoVien);
           pre.setString(2, ho);
           pre.setString(3, ten);
           pre.setBoolean(4, gioiTinh);
           pre.setTimestamp(5, ngaySinh);
           pre.setString(6,password);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /*
    public static int deleteGiaoVien(String maGiaoVien) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "delete from giaovien where magiaovien = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maGiaoVien);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    */
    public static int doiMatKhauGiaoVien(String mkMoi) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "update giaovien set password = ? where magiaovien = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, mkMoi);
            pre.setString(2, StaticVariable.GV_MAGV);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static boolean checkGiaoVienDangNhap(String maGiaoVien, String password) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from giaovien where (magiaovien = ? and password = ?)";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maGiaoVien);
            pre.setString(2, password);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maGiaoVien) && rs.getString(6).equals(password)) {
                    check = true;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static boolean checkMaGiaoVienCoTrongHeThong(String maGiaoVien) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from giaovien where magiaovien = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maGiaoVien);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maGiaoVien)) {
                    check = true;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static int suaThongTinGiaoVien(GiaoVien gv) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "update giaovien set ho = ?, ten = ?, ngaysinh = ?, gioitinh = ? where magiaovien = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, gv.getHo());
            pre.setString(2, gv.getTen());
            Timestamp timeStampDate = gv.getNgaySinh();
            pre.setTimestamp(3, timeStampDate);
            pre.setBoolean(4, gv.getGioiTinh());
            pre.setString(5, gv.getMaGiaoVien());
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
