package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ThongBaoCaNhanDAO {
    public static List<ThongBaoCaNhan> selectAllThongBaoTheoMaHocSinh(String maHocSinh) {
        List<ThongBaoCaNhan> list = new ArrayList<>();
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        ResultSet rs = null;
        ThongBaoCaNhan tb;
        Timestamp ts;
        try {
            sql.append("select * from thongbaocanhan where mahocsinh = ?");
            pre = (PreparedStatement) conn.prepareStatement(sql.toString());
            pre.setString(1, maHocSinh);
            rs = pre.executeQuery();
            while(rs.next()) {
                tb = new ThongBaoCaNhan();
                tb.setMaThongBao(rs.getString(1));
                tb.setNoiDung(rs.getString(2));
                ts = new Timestamp(rs.getDate(3).getTime());
                tb.setNgay(ts);
                tb.setMaHocSinh(rs.getString(5));
                list.add(tb);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
    
    public static int insertThongBao(String maThongBao, String noiDung, Timestamp ngay, String maGiaoVien, String maHocSinh) {
        int result = 0;
        Connection conn = Connect.getConnection();
        StringBuilder sql = new StringBuilder();
        PreparedStatement pre = null;
        try {
           sql.append("insert into thongbaocanhan values(?, ?, ?, ?, ?)");
           pre = (PreparedStatement) conn.prepareStatement(sql.toString());
           pre.setString(1, maThongBao);
           pre.setString(2, noiDung);
           pre.setTimestamp(3, ngay);
           pre.setString(4, maGiaoVien);
           pre.setString(5, maHocSinh);
           result = pre.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return result; 
    }
}
