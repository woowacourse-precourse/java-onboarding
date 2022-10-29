package onboarding.problem1.gradable;

import java.util.List;
import java.util.stream.IntStream;

public class SumEachDigits implements Gradable {
    @Override
    public int grade(List<Integer> pageNumbers) {
        return pageNumbers.stream()
                .mapToInt(this::sumEachDigits)
                .max()
                .orElse(0);
    }

    private int sumEachDigits(Integer pageNumber) {
        return IntStream.iterate(pageNumber, n -> 0 < n, n -> n / 10)
                .reduce(0, (n1, n2) -> n1 + (n2 % 10));
    }
}
