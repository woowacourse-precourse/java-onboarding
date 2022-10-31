package onboarding;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {

    private static String reduceOverlap(String cryptogram) {
        return IntStream.range(0, cryptogram.length())
                .filter(x-> x == 0 || cryptogram.charAt(x) != cryptogram.charAt(x - 1))
                .filter(x -> x == cryptogram.length()-1 || cryptogram.charAt(x) != cryptogram.charAt(x + 1))
                .mapToObj(x->String.valueOf(cryptogram.charAt(x)))
                .collect(Collectors.joining());
    }


    private static void checkRules(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1)
            throw new IllegalArgumentException("올바르지 않은 범위의 입력값입니다.");
        if (!cryptogram.toLowerCase().equals(cryptogram))
            throw new IllegalArgumentException("입력값은 모두 소문자이여야합니다.");
    }

    public static String solution(String cryptogram) {
        checkRules(cryptogram);

        return null;
    }
}