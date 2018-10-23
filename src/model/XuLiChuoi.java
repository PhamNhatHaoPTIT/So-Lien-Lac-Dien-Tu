
package model;


public class XuLiChuoi {
    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
    }
    public static String chuanHoaChuoi(String str) {
        String result = "";
        str = str.trim();
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
                str = removeCharAt(str, i);
                i--;
            }
        }
        String[] temp = str.split(" ");
        str = "";
        for(String s : temp) {
            str += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1) + " ";
        }
        str = str.trim();
        result = str;
        return result;
    }
    public static String chuanHoaMa(String str) {
        String result = "";
        str = str.trim();
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                str = removeCharAt(str, i);
                i--;
            }
        }
        String[] temp = str.split(" ");
        str = "";
        for(String s : temp) {
            str += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1) + " ";
        }
        str = str.trim();
        str = str.toUpperCase();
        result = str;
        return result;
    }
}
