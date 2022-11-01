package onboarding;

import onboarding.problem1.infra.PageNumberAndSizeValidation;
import onboarding.problem1.serivce.PageService;
import onboarding.problem1.type.ResultValue;

import java.util.List;

public class Problem1 {

    private static final PageService pageService = new PageService();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            PageNumberAndSizeValidation validation = new PageNumberAndSizeValidation();

            int pobiMaxValue = pageService.findMaxValue(pobi, validation);
            int crongMaxValue = pageService.findMaxValue(crong, validation);

            return pageService.getResult(pobiMaxValue, crongMaxValue);
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return ResultValue.EXCEPTION_VALUE.getValue();
        }
    }
}