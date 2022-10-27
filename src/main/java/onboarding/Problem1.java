package onboarding;

import java.util.List;
import onboarding.problem1.Page;
import onboarding.problem1.PageCalculationFeature;
import onboarding.problem1.PageComparisonFeature;
import onboarding.problem1.PageNumberCalculator;
import onboarding.problem1.PageNumberComparator;

class Problem1 {

    static PageCalculationFeature<Integer, Integer> pageCalculator = new PageNumberCalculator();
    static PageComparisonFeature<Page, Integer> pageComparator = new PageNumberComparator(pageCalculator);

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return startGame(pobi, crong);
    }

    private static Integer startGame(List<Integer> pobi, List<Integer> crong) {
        try {
            return comparingPobiAndCrong(pobi, crong);
        } catch (Exception exception) {
            return -1;
        }
    }

    private static Integer comparingPobiAndCrong(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);
        return pageComparator.comparePageBetween(pobiPage, crongPage);
    }
}