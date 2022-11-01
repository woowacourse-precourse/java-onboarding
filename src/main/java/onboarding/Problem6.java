package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");



        return answer;
    }

    public static boolean checkRepeated(String longerWord, String shorterWord) {

        for (int i = 0; i < shorterWord.length()-1; i++) {

            if (longerWord.contains(shorterWord.substring(i, i + 2))) {
                return true;
            }

        }

        return false;
    }
}
