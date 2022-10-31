package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(1) - pobi.get(0) != 1 ||crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        int pobiNum = getMax(pobi);
        int crongNum = getMax(crong);

        if(pobiNum > crongNum) {
            return 1;
        }
        else if(pobiNum < crongNum) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static int getMax(List<Integer> human) {
        int max = 0;

        for (int i = 0; i < 2; i++) {
            int num = human.get(i);
            int plus = 0;
            int multiply = 1;
            while (num != 0) {
                int cur = num % 10;
                plus += cur;
                multiply *= cur;

                num /= 10;
            }
            max = Math.max(max, Math.max(plus, multiply));
        }
        return max;
    }
}