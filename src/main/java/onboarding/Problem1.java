package onboarding;

import onboarding.problem1.Page;
import onboarding.problem1.Pages;
import onboarding.problem1.Referee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPages = new Pages(pobi.stream()
                    .map(Page::new)
                    .collect(Collectors.toList()));
            Pages crongPages = new Pages(crong.stream()
                    .map(Page::new)
                    .collect(Collectors.toList()));
            Referee referee = new Referee(pobiPages, crongPages);
            return referee.getMatchResult();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}