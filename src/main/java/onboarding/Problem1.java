package onboarding;

import java.util.List;

class Problem1 {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validate(pobi) || validate(crong)) {
            return -1;
        }

        return answer;
    }

    public static boolean validate(List<Integer> checkList) {
        return checkList.contains(FIRST_PAGE) || checkList.contains(LAST_PAGE);
    }
}