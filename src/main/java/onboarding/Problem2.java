package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem2 {
    public static String decoding(String cryptogram) {
        if (cryptogram.length()<2) return cryptogram;

        String[] word = cryptogram.split("");
        List<String> l = IntStream.range(0, word.length)
                .filter(i -> {
                    boolean result = true;
                    if(i>0)
                        result = (word[i-1].equals(word[i]))?false:result;
                    if (i<word.length-1)
                        result = (word[i+1].equals(word[i]))?false:result;
                    return result;
                })
                .mapToObj(i -> word[i])
                .collect(Collectors.toList());
        return String.join("", l);
    }

    public static String solution(String cryptogram) {
        String before = null;
        String after =cryptogram;
        do {
            before=after;
            after=decoding(before);
        } while (!after.equals(before));

        return after;
    }
}
