package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(1) != pobi.get(0) + 1 || crong.get(1) != crong.get(0) + 1 || pobi.get(0) < 1 || crong.get(0) < 1 || pobi.get(1) > 400 || crong.get(1) > 400) {
            return -1;
        }

        int[] pobiBest = new int[2];
        int[] crongBest = new int[2];

        for (int i = 0; i < pobi.size(); i++) {
            int sum = 0;
            int mul = 1;

            int number = pobi.get(i);

            while (number != 0) {
                sum += number % 10;
                mul *= number % 10;
                number /= 10;
            }
            pobiBest[i] = Math.max(sum, mul);
        }

        for (int i = 0; i < crong.size(); i++) {
            int sum = 0;
            int mul = 1;

            int number = crong.get(i);

            while (number != 0) {
                sum += number % 10;
                mul *= number % 10;
                number /= 10;
            }
            crongBest[i] = Math.max(sum, mul);
        }

        int pobiMax = Math.max(pobiBest[0], pobiBest[1]);
        int crongMax = Math.max(crongBest[0], crongBest[1]);

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }


    }


}