package chapter01;

// 두 문자열이 애너그램인지 검사
public class Prob018 {

    private static final int EXTENDED_ASCII_CODES = 256;

    public static boolean isAnagram(String str1, String str2) {
        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        for (int i = 0; i < chStr1.length; i++) {
            chCounts[chStr1[i]]++;
            chCounts[chStr2[i]]--;
        }

        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
