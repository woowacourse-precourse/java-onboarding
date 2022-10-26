package onboarding;

import java.util.List;

class Problem1 {
    public static int sum(int n) {
        int result = 0;
        while (0 < n) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static int mul(int n) {
        int result = 1;
        while (0 < n) {
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if ((Math.abs(pobi.get(0) - pobi.get(1)) == 1) && (Math.abs(crong.get(0) - crong.get(1)) == 1)) {
            int pobiMaxSum = Math.max(sum(pobi.get(0)), sum(pobi.get(1)));
            int pobiMaxMul = Math.max(mul(pobi.get(0)), mul(pobi.get(1)));
            int pobiMaxVal = Math.max(pobiMaxSum, pobiMaxMul);

            int crongMaxSum = Math.max(sum(crong.get(0)), sum(crong.get(1)));
            int crongMaxMul = Math.max(mul(crong.get(0)), mul(crong.get(1)));
            int crongMaxVal = Math.max(crongMaxSum, crongMaxMul);

            if (crongMaxVal < pobiMaxVal) {
                answer = 1;
            } else if (pobiMaxVal < crongMaxVal) {
                answer = 2;
            } else {
                answer = 0;
            }
        } else {
            answer = -1;
        }

        return answer;
    }
}