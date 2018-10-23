package model;

import database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HanhKiemDAO {
    public static HanhKiem selectHanhKiem(String maHocSinh, int hocKy) {
        HanhKiem hk = new HanhKiem();
        String sql = "";
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql = "select * from hanhkiem where (mahocsinh = ? and hocky = ?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, maHocSinh);
            pre.setInt(2, hocKy);
            rs = pre.executeQuery();
            while(rs.next()) {
                hk.setMaHocSinh(rs.getString(1));
                hk.setHocKy(hocKy);
                hk.setLoai(rs.getInt(3));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return hk;
    }
    public static int insertHanhKiem(String maHocSinh, int hocKy, int loai) {
        int result = 0;
        com.mysql.jdbc.Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        com.mysql.jdbc.PreparedStatement pre = null;
        try {
           sql.append("insert into hanhkiem values(?, ?, ?)");
           pre = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maHocSinh);
           pre.setInt(2, hocKy);
           pre.setInt(3, loai);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    public static int suaHanhKiem(String maHocSinh, int hocKy, int loai) {
        int result = 0;
        com.mysql.jdbc.Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        com.mysql.jdbc.PreparedStatement pre = null;
        try {
           sql.append("update hanhkiem set loai = ? where (mahocsinh = ? and hocky = ?)");
           pre = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setInt(1, loai);
           pre.setString(2, maHocSinh);
           pre.setInt(3, hocKy);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
}
