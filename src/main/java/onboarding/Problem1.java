package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validateInputFormat(pobi) || !validateInputFormat(crong)) {
            return -1;
        }
        if (!validateContinuous(pobi) || !validateContinuous(crong)) {
            return -1;
        }
        return answer;
    }

    private static boolean validateInputFormat(List<Integer> numList) {
        Integer leftNum = numList.get(0);
        Integer rightNum = numList.get(1);
        return (leftNum % 2) == 1 && (rightNum % 2) == 0;
    }

    private static boolean validateContinuous(List<Integer> numList) {
        Integer leftNum = numList.get(0);
        Integer rightNum = numList.get(1);
        return (rightNum - leftNum) == 1;
    }
}