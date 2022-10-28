package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    private static List<Integer> checkOverload(StringBuffer cryptogram) {
        return IntStream.range(0, cryptogram.length() - 1)
                .filter(x -> cryptogram.charAt(x) == cryptogram.charAt(x + 1))
                .boxed()
                .collect(Collectors.toList());
    }

    public static String solution(String cryptogram) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cryptogram);

        return "answer";
    }
}