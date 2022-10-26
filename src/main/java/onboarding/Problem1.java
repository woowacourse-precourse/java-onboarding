package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    // 더하기
    private static int sum(List<Integer> value) {

        int value1 = 0;
        int value2 = 0;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            value1 = value1 + Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array2) {
            value2 = value2 + Integer.valueOf(val);
        }

        return max(value1, value2);
    }
}