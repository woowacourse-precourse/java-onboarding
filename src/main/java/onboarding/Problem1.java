package onboarding;

import onboarding.problem1.Page;
import onboarding.problem1.Pages;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPages = new Pages(pobi.stream()
                    .map(pobiPage -> new Page(pobiPage))
                    .collect(Collectors.toList()));
            Pages crongPages = new Pages(crong.stream()
                    .map(crongPage -> new Page(crongPage))
                    .collect(Collectors.toList()));

//            Integer pobiScore = pobiPages.stream()
//                    .map(page -> getMaxNumber(page.getSumOfPageDigits(), page.getProductOfPageDigits()))
//                    .max(Comparator.comparing(Integer::intValue))
//                    .get();
//
//
//            Integer crongScore = crongPages.stream()
//                    .map(page -> getMaxNumber(page.getSumOfPageDigits(), page.getProductOfPageDigits()))
//                    .max(Comparator.comparing(Integer::intValue))
//                    .get();
//
//            return getMatchResult(pobiScore, crongScore);
            return 0;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public static int getMaxNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }

    public static int getMatchResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }

        if (crongScore > pobiScore) {
            return 2;
        }

        return 0;
    }


}