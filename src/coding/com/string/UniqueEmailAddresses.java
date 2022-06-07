package coding.com.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {

        /**
         * CASE1
         * Output: 2
         *
         * Explanation:
         * "testemail@coding.com"
         * "testemail@cod.ing.com"
         */
        String[] emails = {
            "test.email+james@coding.com",
            "test.e.mail+toto.jane@coding.com",
            "testemail+tom@cod.ing.com"
        };

        /**
         * CASE2
         * Output: 3
         */
        String[] emails2 = {
            "a@coding.com",
            "b@coding.com",
            "c@coding.com"
        };


        solve(emails);
        solve(emails2);

        //output
    }

    public static int solve(String[] emails) {

        int rslt = 0;

        List<String> list = new ArrayList<>();

        for(String s : emails) {

            String[] fb     = s.split("@");
            String[] arr    = {};
            String localNm  = fb[0];
            String domain   = fb[1];

            // 1. + 찾기

            if(localNm.indexOf("+") != -1) {
                localNm = (localNm.split("\\+"))[0];
            }

            localNm = localNm.replaceAll("\\.", "");
//            System.out.println(localNm);

           StringBuffer sb = new StringBuffer();
           sb.append(localNm).append("@").append(fb[1]);
           list.add(sb.toString());
        }

        Set<String> set = new HashSet<>(list);
        rslt = set.size();

        System.out.println("============결과");
        System.out.println(rslt);

        return rslt;
    }
}
