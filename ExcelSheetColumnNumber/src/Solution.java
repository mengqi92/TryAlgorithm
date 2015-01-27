/**
 * Created by peimengqi on 15/1/1.
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * */
//    26进制 -> 十进制
 public class Solution {
    public static int titleToNumber(String s) {
        int result = 0;
//        将输入字符串转化为字节数组
        byte[] bytes = s.getBytes();
//        26进制的阶数
        for (int i = bytes.length-1; i >= 0; i--) {
//            先将字母转化为数字
            int dig = bytes[i] - 'A' + 1;

//            exponent = bytes.length-1-i;
            result = (int) (dig * (Math.pow(26, (bytes.length-1-i))) + result);
        }
        return result;
    }

//    public static void main(String[] args) {
//        System.out.println(titleToNumber("A"));
//        System.out.println(titleToNumber("B"));
//        System.out.println(titleToNumber("D"));
//        System.out.println(titleToNumber("AA"));
//        System.out.println(titleToNumber("AB"));
//    }
}
