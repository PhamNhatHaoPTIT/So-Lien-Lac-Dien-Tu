
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;

public class DiemDAO {
    public static Diem selectDiem(String maHocSinh, String maMonHoc, int loai) {
        Diem d = new Diem();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql.append("select * from diem where (mahocsinh = ? and mamonhoc = ? and loai = ? and hocky = ?)");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maHocSinh);
            pre.setString(2, maMonHoc);
            pre.setInt(3, loai);
            pre.setInt(4, StaticVariable.hocKy);
            rs = pre.executeQuery();
            while(rs.next()) {
                d.setDiem(rs.getDouble(1));
                d.setMaHocSinh(maHocSinh);
                d.setMaMonHoc(maMonHoc);
                d.setLoai(loai);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return d;
    }
    public static int insertDiem(double diem, String maHocSinh, String maMonHoc, int loai, int hocKy) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into diem values(?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setDouble(1, diem);
           pre.setString(2, maHocSinh);
           pre.setString(3, maMonHoc);
           pre.setInt(4, loai);
           pre.setInt(5, hocKy);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    public static int suaDiem(double diem, String maHocSinh, String maMonHoc, int loai) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("update diem set diem = ? where (mahocsinh = ? and mamonhoc = ? and loai = ? and hocky = ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setDouble(1, diem);
           pre.setString(2, maHocSinh);
           pre.setString(3, maMonHoc);
           pre.setInt(4, loai);
           pre.setInt(5, StaticVariable.hocKy);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /*public static int deleteDiem(String maHocSinh, String maMonHoc, int loai) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "delete from diem where (mahocsinh = ? and mamonhoc = ? and loai = ?)";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maHocSinh);
            pre.setString(2, maMonHoc);
            pre.setInt(3, loai);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/
}
