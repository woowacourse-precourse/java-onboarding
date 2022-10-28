package onboarding;

import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {
    private static Pages pobiPages;
    private static Pages crongPages;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            pobiPages = new Pages(pobi);
            crongPages = new Pages(crong);
            return checkWinner();
        }catch (IllegalArgumentException ex){
            return -1;
        }
    }

    private static int checkWinner () {
        int pobiMaxValue = pobiPages.getMaxValue();
        int crongMaxValue = crongPages.getMaxValue();

        if (pobiMaxValue > crongMaxValue) {
            return 1;
        }

        if (pobiMaxValue < crongMaxValue) {
            return 2;
        }

        return 0;
    }
}