package onboarding.support.problem1;

public class PagePair {


    public int calculateDigitSum(int pageNumber) {
        int digitSum = 0;
        while (pageNumber >= Constants.getMinPage()) {
            digitSum += pageNumber % Constants.getDigitMod();
            pageNumber /= Constants.getDigitMod();
        }
        return digitSum;
    }


}