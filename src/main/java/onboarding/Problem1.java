package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi)||isException(crong)) {
            return -1;
        }

        int pobiMax = Math.max(searchMaxNum(pobi.get(0)), searchMaxNum(pobi.get(1)));
        int crongMax = Math.max(searchMaxNum(crong.get(0)), searchMaxNum(crong.get(1)));

        return getAnswer(pobiMax, crongMax);

    }

    private static int getAnswer(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }

    private static boolean isException(List<Integer> list) {
        for (Integer integer : list) {
            if (integer < 1 || integer > 400) {
                return true;
            }
        }
        if (list.get(1) - list.get(0) !=1) {
            return true;
        }
        return false;

    }


    private static int searchMaxNum(Integer num) {
        int mutiply = 1;
        int sum = 0;
        while (num != 0) {
            mutiply *= num % 10;
            sum += num % 10;
            num /= 10;
        }
        return Math.max(mutiply, sum);
    }
}