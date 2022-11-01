package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p1 = pobi.get(0), p2 = pobi.get(1);
        int c1 = crong.get(0), c2 = crong.get(1);

        if (isException(p1, p2)) return -1;
        if (isException(c1, c2)) return -1;

        return 0;
    }
    static boolean isException (int n, int m) {
        return m - n != 1;
    }
}