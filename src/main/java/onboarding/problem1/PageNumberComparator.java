package onboarding.problem1;

public class PageNumberComparator implements PageComparisonFeature<Page,Integer>{

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int ZERO = 0;
    public static final int EXCEPTION_NUMBER = -1;
    private final PageCalculationFeature<Integer, Integer> pageCalculator;

    public PageNumberComparator(PageCalculationFeature<Integer, Integer> pageCalculator) {
        this.pageCalculator = pageCalculator;
    }

    @Override
    public Integer lagerNumberOfCondition(Page page) {
        Integer leftSumNumber = pageCalculator.plus(page.getLeftPage());
        Integer rightSumNumber = pageCalculator.plus(page.getRightPage());
        Integer leftMultiplicationNumber = pageCalculator.multiply(page.getLeftPage());
        Integer rightMultiplicationNumber = pageCalculator.multiply(page.getRightPage());

        return Math.max(Math.max(leftSumNumber, leftMultiplicationNumber),
            Math.max(rightSumNumber, rightMultiplicationNumber));
    }

    @Override
    public Integer comparePageBetween(Page first, Page second) {
        Integer firstMaxNumber = lagerNumberOfCondition(first);
        Integer secondMaxNumber = lagerNumberOfCondition(second);

        if(firstMaxNumber > secondMaxNumber) {
            return ONE;
        }

        if(firstMaxNumber < secondMaxNumber) {
            return TWO;
        }

        if(firstMaxNumber == secondMaxNumber) {
            return ZERO;
        }

        return EXCEPTION_NUMBER;
    }
}
