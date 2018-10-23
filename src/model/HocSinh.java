package model;

import java.sql.Timestamp;

public class HocSinh extends Nguoi{
    private String maHocSinh;
    private String  maLop;

    public HocSinh() {
        super();
    }

    public HocSinh(String ho, String ten, boolean gioiTinh, String password, Timestamp ngaySinh, String maHocSinh, String maLop) {
        super(ho, ten, gioiTinh, password, ngaySinh);
        this.maHocSinh = maHocSinh;
        this.maLop = maLop;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
}
