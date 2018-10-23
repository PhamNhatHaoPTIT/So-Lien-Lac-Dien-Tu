package model;

import java.sql.Timestamp;

public class ThongBao {
    private String maThongBao;
    private String noiDung;
    private Timestamp ngay;
    private GiaoVien giaoVien;

    public ThongBao() {
        
    }

    public ThongBao(String maThongBao, String noiDung, Timestamp ngay, GiaoVien giaoVien) {
        this.maThongBao = maThongBao;
        this.noiDung = noiDung;
        this.ngay = ngay;
        this.giaoVien = giaoVien;
    }

    public String getMaThongBao() {
        return maThongBao;
    }

    public void setMaThongBao(String maThongBao) {
        this.maThongBao = maThongBao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Timestamp getNgay() {
        return ngay;
    }

    public void setNgay(Timestamp ngay) {
        this.ngay = ngay;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }
    
}
