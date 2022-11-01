package onboarding.problem3;

import java.util.stream.IntStream;

public class ThreefoldGamer {

    private final int MAX_NUM;

    public ThreefoldGamer(int number) {
        this.MAX_NUM = number;
    }

    public int play() {
        StringBuilder builder = new StringBuilder();
        IntStream.range(1, MAX_NUM + 1).forEach(builder::append);
        return (int) builder.chars().filter(this::isThreefoldNum).count();
    }

    private boolean isThreefoldNum(int num) {
        num -= '0';
        return num != 0 && num % 3 == 0;
    }
}
