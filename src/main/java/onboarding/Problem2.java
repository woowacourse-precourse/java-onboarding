package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String preProcessed = cryptogram;
        String postProcessed = remover(cryptogram);
        while (!preProcessed.equals(postProcessed)) {
            preProcessed = postProcessed;
            postProcessed = remover(preProcessed);
        }
        return postProcessed;
    }

    static String remover(String str){
        List<String> regexFormats = new ArrayList<>();
        IntStream.range(97, 123).forEach(x -> regexFormats.add("[" + (char)x + "]{2}"));

        String temp = str;
        for (String regex : regexFormats) {
            temp = temp.replaceAll(regex, "");
        }
        return temp;
    }
}
