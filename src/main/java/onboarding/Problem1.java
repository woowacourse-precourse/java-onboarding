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


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}