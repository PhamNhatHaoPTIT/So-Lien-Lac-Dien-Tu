package model;

import java.sql.Timestamp;

public class GiaoVien extends Nguoi{
    private String maGiaoVien;

    public GiaoVien() {
        super();
    }

    public GiaoVien(String ho, String ten, boolean gioiTinh, String password, Timestamp ngaySinh, String maGiaoVien) {
        super(ho, ten, gioiTinh, password, ngaySinh);
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }
    
}
