
package model;

import java.sql.Timestamp;


public class MailPhuHuynh {
    private String noiDung, maGiaoVien, maHocSinh;
    private Timestamp ngay;

    public MailPhuHuynh() {
        
    }

    public MailPhuHuynh(String maHocSinh, String maGiaoVien, String noiDung, Timestamp ngay) {
        this.noiDung = noiDung;
        this.maGiaoVien = maGiaoVien;
        this.maHocSinh = maHocSinh;
        this.ngay = ngay;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public Timestamp getNgay() {
        return ngay;
    }

    public void setNgay(Timestamp ngay) {
        this.ngay = ngay;
    }
}
