package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1) {
            return -1;
        }

        int pobiMax = calc(pobi);
        int crongMax = calc(crong);

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax == crongMax) {
            return 0;
        } else {
            return 2;
        }
    }

    private static int calc(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int plus = 0;
            int multi = 1;
            int n = list.get(i);

            while (n > 0) {
                plus += n%10;
                multi *= n%10;
                n /= 10;
            }

            int temp = Math.max(plus, multi);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}