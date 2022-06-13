package coding.com.string;

public class PlusOne {

    public static void main(String[] args) {

        /**
         * case 1
         * Input: digits = [1,2,3]
         * Output: [1,2,4]
         */

        int[] param = {1,2,3};
        solve(param);

        /**
         * case2
         * Input: [9,9,9]
         * Output: [1,0,0,0]
         */
        int[] param2 = {9, 9, 9};
        solve(param2);

    }


    // me
    public static int[] solve(int[] k) {

        StringBuilder sb = new StringBuilder();

        for(int i : k) {
            sb.append(String.valueOf(i));
        }


        int n = Integer.valueOf(sb.toString());
        n += 1;

        char[] arr = String.valueOf(n).toCharArray();

        int[] rslt = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            rslt[i]  = Character.getNumericValue(arr[i]);
        }

        System.out.println();
        for(int i : rslt) {
            System.out.print(i);
        }

        return rslt;
    }

    public static int[] solve2(int[] k) {

        for(int i = k.length - 1; i >= 0; i--) {

            k[i] += 1;

            if(k[i] >= 10) {
                return k;
            }
        }

        int[] rslt = new int[k.length + 1];
        rslt[0] = 1;

        for(int n : rslt){
            System.out.print(n);
        }

        System.out.println("");
        return rslt;
    }
}
