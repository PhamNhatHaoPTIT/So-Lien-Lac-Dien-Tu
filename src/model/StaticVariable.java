
package model;


public class StaticVariable {
    public static boolean role = false;       // giáo viên đăng nhập: role = true, phụ huynh: role = false
    public static int hocKy = 1;
    // các biến quản lý giáo viên UI
    public static String GV_MAGV = "", GV_MALOP = "", GV_MAHOCSINH = "";
    public static String GV_MAHS = "", GV_HOHS = "", GV_TENHS = "", GV_NGAYSINHHS = ""; // dung de sua thong tin hs
    public static boolean GV_GIOITINHHS = true;                                            // dung de sua thong tin hs
    public static String GV_MAMONHOC = "";        // dung trong module nhap diem
    // các biến quản lý phụ huynh UI
    public static String PH_MAGIAOVIEN = "", PH_MAHOCSINH = "", PH_MALOP = "";
    
}
