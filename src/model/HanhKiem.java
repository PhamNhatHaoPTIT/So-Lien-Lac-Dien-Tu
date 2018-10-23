package model;


public class HanhKiem {
    private String maHocSinh;
    private int hocKy, loai;

    public HanhKiem() {
        
    }

    public HanhKiem(String maHocSinh, int hocKy, int loai) {
        this.maHocSinh = maHocSinh;
        this.hocKy = hocKy;
        this.loai = loai;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
