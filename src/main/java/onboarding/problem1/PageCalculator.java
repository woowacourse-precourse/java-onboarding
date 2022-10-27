package onboarding.problem1;

public class PageCalculator implements PageCalculationFeature<Integer, Integer>{

    @Override
    public Integer plus(Integer input) {
        Integer result = 0;
        while (input != 0) {
            result += input % 10;
            input = input / 10;
        }
        return result;
    }

    @Override
    public Integer multiply(Integer input) {
        Integer result = 1;
        while (input != 0) {
            result *= input % 10;
            input = input / 10;
        }
        return result;
    }
}
