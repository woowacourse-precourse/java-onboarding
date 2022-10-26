package onboarding.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Page {

    private final int leftPage;
    private final int rightPage;

    public Page(List<Integer> pageList) {
        this.leftPage = pageList.get(0);
        this.rightPage = pageList.get(1);
    }

    private int getPageNumberValue(int page) {
        final int[] numbers = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
        final int sumValue = Arrays.stream(numbers).reduce(0, Integer::sum);
        final int multiplyValue = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);

        return Math.max(sumValue, multiplyValue);
    }

    public static Page create(List<Integer> pageList) {
        return new Page(pageList);
    }
}
