package model;

import java.sql.Timestamp;


public class ThongBaoChung extends ThongBao{
    private Lop lop;

    public ThongBaoChung() {
        super();
    }

    public ThongBaoChung(String maThongBao, String noiDung, Timestamp ngay, GiaoVien giaoVien, Lop lop) {
        super(maThongBao, noiDung, ngay, giaoVien);
        this.lop = lop;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
    
}
