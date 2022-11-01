package onboarding;

import java.util.List;

class Problem1 {
    public static  int hap(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    public static int gop(int n) {
        int sum = 1;
        while (n > 0) {
            sum *= (n % 10);
            n /= 10;
        }
        return sum;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_max = Integer.MIN_VALUE;
        int crong_max = Integer.MIN_VALUE;

        for (int i = 0; i < 2; i++) {
            int p = pobi.get(i);
            int c = crong.get(i);

            pobi_max = Math.max(pobi_max, Math.max(hap(p), gop(p)));
            crong_max = Math.max(crong_max, Math.max(hap(c), gop(c)));
        }
        if (pobi_max > crong_max) answer = 1;
        else if (pobi_max < crong_max) answer = 2;
        else answer = 0;

        return answer;
    }
}