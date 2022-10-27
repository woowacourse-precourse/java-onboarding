package onboarding;

import onboarding.problem1.PageValidator;

import java.util.List;

class Problem1 {

    public static final int EXCEPTION_SITUATION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        PageValidator pageValidator = new PageValidator();
        try {
            pageValidator.validatePages(pobi);
            pageValidator.validatePages(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_SITUATION;
        }
        return answer;
    }
}