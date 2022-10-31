package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkException(pobi, crong) == -1) {
            return -1;
        }

        answer = compareValue(pageMaxValue(pobi), pageMaxValue(crong));

        return answer;
    }

    public static int checkException(List<Integer> pobi, List<Integer> crong) {
        int result = 0;

        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return -1;
        }

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        if (pobi.get(0) == 1 || pobi.get(1) == 400) {
            return -1;
        }

        if (crong.get(0) == 1 || crong.get(1) == 400) {
            return -1;
        }

        return result;
    }

    public static int pageMaxValue(List<Integer> page) {
        int maxValue = 0;
        int totalAddition = 0;
        int totalMultiplication = 0;

        for (int i = 0; i < 2; i++) {
            int additionValue = 0;
            int multiplicationValue = 0;

            additionValue = page.get(i) % 10;
            multiplicationValue = page.get(i) % 10;

            if (9 < page.get(i)) {
                additionValue += page.get(i) % 100 / 10;
                multiplicationValue *= page.get(i) % 100 / 10;
            }

            if (99 < page.get(i)) {
                additionValue += (page.get(i) / 100);
                multiplicationValue *= (page.get(i) / 100);
            }

            if (totalAddition < additionValue) {
                totalAddition = additionValue;
            }

            if (totalMultiplication < multiplicationValue) {
                totalMultiplication = multiplicationValue;
            }
        }

        if (totalAddition >= totalMultiplication) {
            maxValue = totalAddition;
        }

        if (totalMultiplication >= totalAddition) {
            maxValue = totalMultiplication;
        }

        return maxValue;
    }

    public static int compareValue(int pobi, int crong) {
        int result = 0;

        if (pobi > crong) {
            result = 1;
        }

        if (crong > pobi) {
            result = 2;
        }

        if (pobi == crong) {
            result = 0;
        }

        return result;
    }

}