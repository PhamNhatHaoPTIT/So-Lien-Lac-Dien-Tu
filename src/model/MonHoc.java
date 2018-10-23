package model;

public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private String ghiChu;
    private String maLop;

    public MonHoc() {
        
    }

    public MonHoc(String maMonHoc, String tenMonHoc, String ghiChu, String maLop) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.ghiChu = ghiChu;
        this.maLop = maLop;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
}
