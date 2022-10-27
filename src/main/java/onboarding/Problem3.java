package onboarding;

import onboarding.problem3.domain.Numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return new Numbers(number).sumCountOfMultipleOfThree();
    }
}
