package onboarding;

import onboarding.problem1.PagePlayer;
import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION_RESULT = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            Pages pobiPages = new Pages(pobi);
            Pages crongPages = new Pages(crong);

            PagePlayer pobiPlayer = new PagePlayer(pobiPages);
            PagePlayer crongPlayer = new PagePlayer(crongPages);

        } catch (IllegalArgumentException e) {
            return EXCEPTION_RESULT;
        }
        return answer;
    }
}