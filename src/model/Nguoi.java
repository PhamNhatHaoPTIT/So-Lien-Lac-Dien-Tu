package model;

import java.sql.Timestamp;

public class Nguoi {
    private String ho;
    private String ten;
    private boolean gioiTinh;
    private String password;
    private Timestamp ngaySinh;
    public Nguoi() {
        
    }

    public Nguoi(String ho, String ten, boolean gioiTinh, String password, Timestamp ngaySinh) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.password = password;
        this.ngaySinh = ngaySinh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
}
