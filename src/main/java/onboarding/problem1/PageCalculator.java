package onboarding.problem1;

public class PageCalculator implements PageCalculationFeature{

    @Override
    public Integer plusNumber(Integer input) {
        Integer result = 0;
        while (input != 0) {
            result += input % 10;
            input = input / 10;
        }
        return result;
    }

    @Override
    public Integer multiplyNumber(Integer input) {
        Integer result = 1;
        while (input != 0) {
            result *= input % 10;
            input = input / 10;
        }
        return result;
    }
}
