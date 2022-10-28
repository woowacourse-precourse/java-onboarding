package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {

    public static String changeWord(String word) {

        String alpabat = "";

        for (int i = 0; i < 26; i++) {
            alpabat += (char) ('a' + i);
        }

        String alpabatC = "";

        for (int i = 0; i < 26; i++) {
            alpabatC += (char) ('A' + i);
        }

        String alpabatR = "";

        for (int i = 0; i < 26; i++) {
            alpabatR += (char) ('z' - i);
        }

        String alpabatCR = "";

        for (int i = 0; i < 26; i++) {
            alpabatCR += (char) ('Z' - i);
        }

        if (alpabat.contains(word)) {
            return String.valueOf(alpabatR.charAt(alpabat.indexOf(word)));
        }

        if (alpabatC.contains(word)) {
            return String.valueOf(alpabatCR.charAt(alpabatC.indexOf(word)));
        }

        return " ";
    }

    public static String solution(String word) {
        String answer = "";
        List<String> splitWord = List.of(word.split(""));
        answer = splitWord.stream().map(x -> changeWord(x)).collect(Collectors.joining());

        return answer;
    }

}
