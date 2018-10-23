package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MailPhuHuynhDAO {
    public static List<MailPhuHuynh> selectAllMailTuPhuHuynh(String maGiaoVien) {
        List<MailPhuHuynh> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        MailPhuHuynh mail = new MailPhuHuynh();
        Timestamp ts;
        try {
            sql.append("select * from mailphuhuynh where magiaovien = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maGiaoVien);
            rs = pre.executeQuery();
            while(rs.next()) {
                mail.setNoiDung(rs.getNString(1));
                ts = new Timestamp(rs.getDate(2).getTime());
                mail.setNgay(ts);
                mail.setMaGiaoVien(maGiaoVien);
                mail.setMaHocSinh(rs.getString(4));
                list.add(mail);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
    public static int insertMailPhuHuynh(String maHocSinh, String maGiaoVien, String noiDung, Timestamp ngay) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into mailphuhuynh values(?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, noiDung);
           pre.setTimestamp(2, ngay);
           pre.setString(3, maGiaoVien);
           pre.setString(4, maHocSinh);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
}
