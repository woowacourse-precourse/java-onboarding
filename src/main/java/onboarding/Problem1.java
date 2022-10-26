package onboarding;

import static onboarding.feature1.Constants.*;

import java.util.List;

import onboarding.feature1.CompareMaximums;
import onboarding.feature1.MaximumCalculator;
import onboarding.feature1.Pages;
import onboarding.feature1.PageValidator;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pageOfPobi = new Pages(pobi);
        Pages pageOfCrong = new Pages(crong);

        if (!PageValidator.isValid(pageOfPobi) || !PageValidator.isValid((pageOfCrong))) {
            return RAISE_EXCEPTION;
        }

        Integer pobiMaximum = MaximumCalculator.getMaximum(pageOfPobi);
        Integer crongMaximum = MaximumCalculator.getMaximum(pageOfCrong);

        return CompareMaximums.WhoIsOwner(pobiMaximum, crongMaximum);
    }
}