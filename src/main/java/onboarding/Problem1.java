package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pl = pobi.get(0);
        int pr = pobi.get(1);
        int cl = crong.get(0);
        int cr = crong.get(1);
        if (pr - pl != 1 || cr - cl != 1) return -1;
        int p_max = Math.max(get_max(pl), get_max(pr));
        int c_max = Math.max(get_max(cl), get_max(cr));

        if (p_max>c_max) answer = 1;
        else if (p_max<c_max) answer = 2;
        else answer = 0;

        return answer;
    }

    public static Integer get_max(Integer n) {
        int add = 0, mul = 1;
        while (n > 0) {
            add += n%10;
            mul *= n%10;
            n/=10;
        }
        return Math.max(add, mul);
    }

}