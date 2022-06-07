package coding.com.string;

import java.util.Locale;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        // CASE1.
        // Input: s = "8F3Z-2e-9-w", k = 4
        // Output: "8F3Z-2E9W“
        solve2("8F3Z-2e-9-w", 4);

        // CASE2.
        // Input: s = " 8-5g-3-J ", k = 2
        // Output: "8-5G-3J"
        solve2("8-5g-3-J", 2);
    }

    public static String solve(String s, int k) {

        StringBuilder sb = new StringBuilder();

        int idx = s.indexOf("-");

        sb.append(s.substring(0, idx)).append("-");

        char[] arr = s.substring(idx + 1, s.length()).toCharArray();

        int cnt = 0;
        for(char c : arr) {

            if(!"-".equals(Character.toString(c))) {
                sb.append(Character.toString(c).toUpperCase(Locale.ROOT));
                cnt++;

                if (cnt == k) {
                    sb.append("-");
                    cnt = 0;
                }
            }
        }

        String rslt = "";
        if(sb.lastIndexOf("-") == sb.length() - 1) {
            rslt = sb.substring(0, sb.length() - 1);
        }

        System.out.println(rslt);
        return rslt;
    }

    public static String solve2(String s, int k) {

        // 1. - 없애기
        s = s.replaceAll("-", "");

        // 2. 대문자.
        s = s.toUpperCase(Locale.ROOT);

        StringBuilder sb = new StringBuilder(s);

        // 3. '-' 삽입
        int len = s.length();
        for(int i = k; i < len; i = i + k) {
            sb.insert(len - i, "-");
        }

        System.out.println(sb);
        return sb.toString();
    }
}
