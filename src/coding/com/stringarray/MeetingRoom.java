package coding.com.stringarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

}

public class MeetingRoom {
    public static void main(String[] args) {

        /**
         * CASE1
         * Input: [[0,30],[5,10],[15,20]]
         * Output: false
         */
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);

        System.out.println(solve(intervals));

        /**
         * CASE2
         * Input: [[7,10],[2,4]]
         * Output: true
         */

        Interval[] intervals2 = new Interval[2];
        intervals2[0] = new Interval(7, 10);
        intervals2[1] = new Interval(2, 4);
        System.out.println(solve(intervals2));

    }

    public static boolean solve(Interval[] intervals) {

        // list 로 담기
        List<Interval> list = Arrays.asList(intervals);

        // 정렬
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return 0;
            }
        });

        // 비교
        int ce = 0; // current end
        int as = 0; // after start

        for(int i = 0; i < list.size() - 1; i++) {
            Interval current = list.get(i);
            Interval after = list.get(i + 1);

            if(after.end > current.start) {
                return false;
            }
        }

        return true;
    }
}
