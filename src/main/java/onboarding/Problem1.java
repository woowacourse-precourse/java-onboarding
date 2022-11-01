package onboarding;

import java.util.List;

class Problem1 {
    public static boolean check(int left, int right) {
        if ((1 <= left && left < 400) && (1 < right && right <= 400) && left + 1 == right) return false;
        return true;
    }

    public static int getMax(int N) {
        int sum = 0;
        int mul = 1;

        while (N > 0) {
            sum += N % 10;
            mul *= N % 10;
            N /= 10;
        }
        return Math.max(sum, mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pleft = pobi.get(0);
        int pright = pobi.get(1);
        int cleft = crong.get(0);
        int cright = crong.get(1);

        if (check(pleft, pright) || check(cleft, cright)) return -1;

        int pobiScore = Math.max(getMax(pleft), getMax(pright));
        int crongScore = Math.max(getMax(cleft), getMax(cright));

        return (pobiScore > crongScore) ? 1 : (pobiScore == crongScore) ? 0 : 2;
    }
}