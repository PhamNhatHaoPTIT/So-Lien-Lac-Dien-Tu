package model;

public class Diem {
    private String maHocSinh;
    private String maMonHoc;
    private int loai;
    private double diem;

    public Diem() {
        
    }
    public Diem(String maHocSinh, String maMonHoc, int loai, double diem) {
        this.maHocSinh = maHocSinh;
        this.maMonHoc = maMonHoc;
        this.loai = loai;
        this.diem = diem;
    }
    public String getMaHocSinh() {
        return maHocSinh;
    }
    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }
    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
