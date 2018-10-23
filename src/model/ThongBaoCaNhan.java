package model;

import java.sql.Timestamp;

public class ThongBaoCaNhan extends ThongBao{
    private String maHocSinh;

    public ThongBaoCaNhan() {
        super();
    }

    public ThongBaoCaNhan(String maThongBao, String noiDung, Timestamp ngay, GiaoVien giaoVien, String maHocSinh) {
        super(maThongBao, noiDung, ngay, giaoVien);
        this.maHocSinh = maHocSinh;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }
    
}
