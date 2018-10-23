package model;

public class Lop {
    private String maLop;
    private String tenLop;
    private String khoa;
    private int siSo;
    private String maGiaoVien;

    public Lop() {
        
    }

    public Lop(String maLop, String tenLop, String khoa, int siSo, String maGiaoVien) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.siSo = siSo;
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }
}
