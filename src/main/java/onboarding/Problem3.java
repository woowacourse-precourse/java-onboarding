package onboarding;

import onboarding.problem3.Game;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        return new Game().run(number);
    }
}