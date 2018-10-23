
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ThongBaoChungDAO {
    public static List<ThongBaoChung> selectAllThongBaoTheoMaLop(String maLop) {
        List<ThongBaoChung> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        ThongBaoChung tb;
        Timestamp ts;
        try {
            sql.append("select * from thongbaochung where malop = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maLop);
            rs = pre.executeQuery();
            while(rs.next()) {
                tb = new ThongBaoChung();
                tb.setMaThongBao(rs.getString(1));
                tb.setNoiDung(rs.getString(2));
                ts = new Timestamp(rs.getDate(3).getTime());
                tb.setNgay(ts);
                
                list.add(tb);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
    public static int insertThongBao(String maThongBao, String noiDung, Timestamp ngay, String maGiaoVien, String maLop) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into thongbaochung values(?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maThongBao);
           pre.setString(2, noiDung);
           pre.setTimestamp(3, ngay);
           pre.setString(4, maGiaoVien);
           pre.setString(5, maLop);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result; 
    }
}
