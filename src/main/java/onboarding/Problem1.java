package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        checkValuesValidity(pobi);
        checkValuesValidity(crong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static void checkValuesValidity(List<Integer> values) {

        if (!isValidValue(values)) {
            throw new IllegalArgumentException("유효하지 않은 페이지입니다.");
        }
    }

    private static boolean isValidValue(List<Integer> values) {

        if ((0 < values.get(0) && values.get(0) <= 400) && (0 < values.get(1) && values.get(1) <= 400)) {
            return true;
        }

        return false;
    }
}