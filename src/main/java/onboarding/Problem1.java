package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isValidParameter(List<Integer> pages) {

    }

    public static int getEachMaximumNumber(Integer page) {

    }

    public static int getMaximumNumber(List<Integer> pages) {

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (isValidParameter(pobi) && isValidParameter(crong)) {
            int maximumPobi = getMaximumNumber(pobi);
            int maximumCrong = getMaximumNumber(crong);

            if (maximumPobi == maximumCrong) {
                answer = 0;
            } else if (maximumPobi > maximumCrong) {
                answer = 1;
            } else {
                answer = 2;
            }
        }

        return answer;
    }
}