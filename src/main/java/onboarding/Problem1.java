package onboarding;

import static onboarding.feature1.Constants.*;

import java.util.List;

import onboarding.feature1.CompareMaximums;
import onboarding.feature1.MaximumCalculator;
import onboarding.feature1.Pages;
import onboarding.feature1.PageValidator;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pagesOfPobi = new Pages(pobi);
        Pages pagesOfCrong = new Pages(crong);

        if (!PageValidator.isValid(pagesOfPobi) || !PageValidator.isValid((pagesOfCrong))) {
            return RAISE_EXCEPTION;
        }

        Integer pobiMaximum = MaximumCalculator.getMaximum(pagesOfPobi);
        Integer crongMaximum = MaximumCalculator.getMaximum(pagesOfCrong);

        return CompareMaximums.chooseOwner(pobiMaximum, crongMaximum);
    }
}