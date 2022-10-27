package custom.problem1;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * > 자리수 별로 계산을 도와주는 static 클래스
 */
public class Calculator {

    public static int calculateNumber(int num, BinaryOperator<Integer> operator) {
        String[] split = String.valueOf(num).split("");
        return Arrays.stream(split)
            .map(Integer::parseInt)
            .reduce(operator)
            .orElseThrow();
    }
}
