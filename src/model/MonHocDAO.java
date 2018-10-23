package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {
    public static MonHoc selectMonHoc(String maMonHoc) {
        MonHoc m = new MonHoc();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql.append("select * from monhoc where mamonhoc = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maMonHoc);
            rs = pre.executeQuery();
            while(rs.next()) {
                m.setMaMonHoc(rs.getString(1));
                m.setTenMonHoc(rs.getNString(2));
                m.setGhiChu(rs.getNString(3));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return m;
    }
    public static String layMaMonHocTuTenMonHoc(String tenMonHoc) {
        String maMonHoc = "";
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql.append("select * from monhoc where tenmonhoc = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, tenMonHoc);
            rs = pre.executeQuery();
            while(rs.next()) {
                maMonHoc = rs.getString(1);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return maMonHoc;
    }
    public static List<MonHoc> selectAllMonHocTheoMaLop(String maLop) {
        List<MonHoc> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        MonHoc mh = null;
        try {
            sql.append("select * from monhoc where malop = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maLop);
            rs = pre.executeQuery();
            while(rs.next()) {
                mh = new MonHoc();
                mh.setMaMonHoc(rs.getString(1));
                mh.setTenMonHoc(rs.getNString(2));
                mh.setGhiChu(rs.getNString(3));
                mh.setMaLop(rs.getString(4));
                list.add(mh);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
    public static boolean checkMaMonHocTrongHeThong(String maMonHoc) {
        boolean check = false;
        Connection conn = Connect.getConnection();
        String sql = "";
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            sql = "select * from monhoc where mamonhoc = ? and malop = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maMonHoc);
            pre.setString(2, StaticVariable.GV_MALOP);
            rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString(1).equals(maMonHoc)) {
                    check = true;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static int insertMonHoc(String maMonHoc, String tenMonHoc, String ghiChu, String maLop) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into monhoc values(?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maMonHoc);
           pre.setNString(2, tenMonHoc);
           pre.setNString(3, ghiChu);
           pre.setString(4, maLop);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    /*public static int deleteMonHoc(String maMonHoc) {
        int result = 0;
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "";
        try {
            sql = "delete from monhoc where mamonhoc = ?";
            pre = (PreparedStatement) conn.prepareStatement(sql);
            pre.setString(1, maMonHoc);
            result = pre.executeUpdate();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/
}
