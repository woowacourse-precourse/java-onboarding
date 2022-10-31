package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePages(pobi) || !validatePages(crong)) {
            return -1;
        }
        int pobiMaxValue = findMaxValue(pobi);
        int crongMaxValue = findMaxValue(crong);

        return 0;
    }

    private static boolean validatePages(List<Integer> player) {
        if (player.get(1) - player.get(0) != 1) {
            return false;
        }
        for (int page : player) {
            if (page < 1 || page > 400) {
                return false;
            }
        }
        if (player.get(0) % 2 == 0 || player.get(1) % 2 != 0) {
            return false;
        }
        if (player.size() != 2) {
            return false;
        }
        return true;
    }

    private static int findMaxValue(List<Integer> player) {
        int max = 0;
        for (int i = 0; i < player.size(); i++) {
            String[] digits = String.valueOf(player.get(i))
                                    .split("");
            int sum = 0;
            int mul = 1;
            for (int j = 0; j < digits.length; j++) {
                sum += Integer.parseInt(digits[j]);
                mul *= Integer.parseInt(digits[j]);
            }
            int biggerValue = findBiggerValue(sum, mul);
            if (max < biggerValue) {
                max = biggerValue;
            }
        }
        return max;
    }

    private static int findBiggerValue(int sum, int mul) {
        if(sum > mul) {
            return sum;
        }
        return mul;
    }
}