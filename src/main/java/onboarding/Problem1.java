package onboarding;

import onboarding.problem1.Pages;

import java.util.List;

public class Problem1 {

    private static final int EXCEPTION_VALUE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPage = new Pages(pobi);
            Pages crongPage = new Pages(crong);

            return pobiPage.compareTo(crongPage);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_VALUE;
        }


    }

}