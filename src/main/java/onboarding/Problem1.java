package onboarding;

import onboarding.problem1.PageValidator;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!PageValidator.isValidatePage(pobi, crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
