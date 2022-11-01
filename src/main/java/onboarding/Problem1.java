package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 상황
        if (pageException(pobi) || pageException(crong)) return -1;
        if (Continuous(pobi) || Continuous(crong)) return -1;

        int pobiSum = getMax(getSum(pobi.get(0)), getSum(pobi.get(1)));
        int pobiMul = getMax(getMul(pobi.get(0)), getMul(pobi.get(1)));
        int pobiMax = getMax(pobiSum, pobiMul);

        int crongSum = getMax(getSum(crong.get(0)), getSum(crong.get(1)));
        int crongMul = getMax(getMul(crong.get(0)), getMul(crong.get(1)));
        int crongMax = getMax(crongSum, crongMul);

        if (pobiMax > crongMax) answer = 1;
        else if (pobiMax < crongMax) answer = 2;
        else answer = 0;

        return answer;
    }

    static boolean pageException(List<Integer> list) {
        return list.get(0) == 1 || list.get(1) == 400;
    }

    static boolean Continuous(List<Integer> list) {
        return !list.get(0).equals(list.get(1) - 1);
    }

    static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    static int getSum(int n) {
        int sum = 0;
        while(true) {
            if (n == 0) break;
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    static int getMul(int n) {
        int mul = 1;
        while(true) {
            if (n == 0) break;
            mul *= n % 10;
            n /= 10;
        }
        return mul;
    }
}