package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() == 1){
            return cryptogram;
        }

        String next = cryptogram;
        String prev;

        do {
            prev = next;
            next = prev.replaceAll(getPattern(prev), "");
        } while(!prev.equals(next));

        return next;
    }

    static String getPattern(String cryptogram){
        List<String> tokenList = List.of(cryptogram.split(""));
        Set<String> tokenSet = new HashSet<>(tokenList);
        List<String> patternList = tokenSet.stream()
                .map(token -> token + "{2,}")
                .collect(Collectors.toList());

        String pattern = String.join("|", patternList);

        return pattern;
    }
}
