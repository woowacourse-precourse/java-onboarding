package onboarding;

import java.util.List;

class Problem1 {
    public static int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isException(pobi) || isException(crong)) {
            answer = EXCEPTION;
        }

        return answer;
    }

    private static boolean isException(List<Integer> pageList) {
        if (pageList.get(1) - pageList.get(0) > 1) {
            return true;
        } else if (pageList.get(1) < pageList.get(0)) {
            return true;
        }

        for (Integer pageNumber : pageList) {
            if (pageNumber > 200) {
                return true;
            }
        }
        return false;
    }

}