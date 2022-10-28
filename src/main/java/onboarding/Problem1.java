package onboarding;

import onboarding.problem1.Pages;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            Pages pobiPages = new Pages(pobi);
            Pages crongPages = new Pages(crong);
            int pobiMaxValue = pobiPages.getMaxValue();
            int crongMaxValue = crongPages.getMaxValue();

            if (pobiMaxValue > crongMaxValue) {
                return 1;
            }

            if (pobiMaxValue < crongMaxValue) {
                return 2;
            }

            return 0;
        }catch (IllegalArgumentException ex){
            return -1;
        }
    }
}