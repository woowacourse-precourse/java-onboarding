package onboarding;

import java.util.List;

class Problem1 {
    public static int findMax(List<Integer> list) {
        int maxValue = 0;

        if (list.get(0) + 1 != list.get(1)) {
            return -1;
        }

        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            int mul = 1;
            int page = list.get(i);

            while (page != 0) {
                int n = page % 10;

                sum += n;
                mul *= n;

                page /= 10;
            }

            if (sum > maxValue) {
                maxValue = sum;
            }

            if (mul > maxValue) {
                maxValue = mul;
            }

        }

        return maxValue;
    }

    public static int findWinner(int pobiValue, int crongValue) {
        int answer;

        if (pobiValue == -1 || crongValue == -1) {
            answer = -1;
        } else if (pobiValue > crongValue) {
            answer = 1;
        } else if (pobiValue < crongValue) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer = findWinner(findMax(pobi), findMax(crong));

        return answer;
    }
}