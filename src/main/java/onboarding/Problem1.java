package onboarding;

import java.util.List;

class Problem1 {
    public static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int getDigitMult(int n) {
        int mult = 1;
        while (n > 0) {
            mult *= n % 10;
            n /= 10;
        }
        return mult;
    }

    public static int getScore(List<Integer> arr) {
        int left = arr.get(0);
        int right = arr.get(1);

        if (left % 2 == 1 && right % 2 == 0 && right - left == 1) {

            int max = 0;
            max = Math.max(max, getDigitSum(left));
            max = Math.max(max, getDigitMult(left));
            max = Math.max(max, getDigitSum(right));
            max = Math.max(max, getDigitMult(right));
            return max;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int answer = Integer.MAX_VALUE;

            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);

            if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            } else {
                answer = 0;
            }

            return answer;
        } catch (Exception e) {
            return -1;
        }
    }
}