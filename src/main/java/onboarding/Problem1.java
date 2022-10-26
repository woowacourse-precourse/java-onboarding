package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p_1 = pobi.get(0);
        int p_2 = pobi.get(1);
        int c_1 = crong.get(0);
        int c_2 = crong.get(1);
        // proxy-> check exception
        if (p1_proxy(p_1, p_2) || p1_proxy(c_1, c_2)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static boolean p1_proxy(int a0, int a1) {
        // Check start page or last page
        if (a0 == 1 || a1 == 400) {
            return true;
        }
        // Check linked page a0, a1
        if (a0 + 1 != a1) {
            return true;
        }
        return false;
    }
}