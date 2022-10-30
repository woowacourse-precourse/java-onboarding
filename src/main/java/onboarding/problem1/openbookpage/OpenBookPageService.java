package onboarding.problem1.openbookpage;

import java.util.Arrays;
import java.util.stream.Stream;

public class OpenBookPageService {
    OpenBookPageValidator pageValidator = new OpenBookPageValidator();

    public int getLargeBookPoint(OpenBookPage openBookPage) {
        pageValidator.validate(openBookPage);
        int leftPagePoint = getLargePagePoint(openBookPage.getLeftPage());
        int rightPagePoint = getLargePagePoint(openBookPage.getRightPage());

        return Math.max(leftPagePoint, rightPagePoint);
    }

    private int getLargePagePoint(int pageNumber) {
        int plusPoint = getPlusPoint(pageNumber);
        int multiplyPoint = getMultiplyPoint(pageNumber);

        return Math.max(plusPoint, multiplyPoint);
    }

    private int getPlusPoint(int number) {
        int[] numberArrays = getNumberIndividually(number);
        return Arrays.stream(numberArrays).sum();
    }

    private int getMultiplyPoint(int number) {
        int[] numberArrays = getNumberIndividually(number);
        return Arrays.stream(numberArrays)
                .reduce(1, (a, b) -> a * b);
    }

    private int[] getNumberIndividually(int number) {
        return Stream.of(String.valueOf(number)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
