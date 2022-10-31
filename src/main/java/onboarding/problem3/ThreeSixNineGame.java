package onboarding.problem3;

import java.util.stream.IntStream;

public class ThreeSixNineGame {

    public int do369(int number) {
        return IntStream.range(1, number + 1)
                .mapToObj(String::valueOf)
                .filter(this::contains369)
                .mapToInt(this::count369)
                .sum();
    }

    private boolean contains369(String number) {
        return number.contains("3") || number.contains("6") || number.contains("9");
    }

    private int count369(String number) {
        return (int) IntStream.range(0, number.length())
                .mapToObj(i -> number.charAt(i) - '0')
                .filter(num -> (num == 3 || num == 6 || num == 9))
                .count();
    }

}
