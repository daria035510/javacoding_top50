package coding.com.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JewelsAndStones {

    public static void main(String[] args) {

        /**
         * case 1
         * result 3
         */
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        solve(jewels1, stones1);

        /**
         * case 2
         * result 0
         */
        String jewels2 = "z";
        String stones2 = "ZZ";
        solve(jewels2, stones2);
    }

    public static int solve(String jew, String stones){

        char[] arrJew       = jew.toCharArray();
        char[] arrStones    = stones.toCharArray();

        List<String> stoneList = new ArrayList<>();

        // 1. ds - list
        for(char c : arrStones) {
            stoneList.add(Character.toString(c));
        };

        // 2. 정렬
        Collections.sort(stoneList);

        // 3. 인덱스 위치 계산
        int sIdx = 0;
        int lIdx = 0;
        int rslt = 0;

        for(char s : arrJew) {
            sIdx = stoneList.indexOf(Character.toString(s));
            lIdx = stoneList.lastIndexOf(Character.toString(s));

            if(sIdx != -1 && lIdx != -1) {
                if(sIdx == lIdx) {
                    rslt += 1;
                } else {
                    rslt += (lIdx - sIdx + 1);
                }
            }
        }

        System.out.println("====결과" + rslt);
        return rslt;
    }
}
