package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem2 {
    private static final int FIND_DUPLICATION = -1;

    public static String solution(String cryptogram) {
        String answer = "answer";

        while(checkDuplicateString(cryptogram)) {
            cryptogram = getAmendString(cryptogram);
        }

        answer = cryptogram;

        return answer;
    }

    private static boolean checkDuplicateString(String inputString) {
        IntStream inputIntStream = inputString.chars();
        int result = inputIntStream
                .reduce(0, (a, b) -> a == FIND_DUPLICATION ? a : (a == b) ? FIND_DUPLICATION : b);

        return result == -1;
    }

    private static String getAmendString(String inputString) {
        List<Character> resultList = new ArrayList<>();
        String resultString = null;
        Character nowChar = null;
        Character deleteChar = '.';
        Integer nowSize = null;

        for(int i = 0; i < inputString.length(); i++) {
            nowSize = resultList.size();
            nowChar = inputString.charAt(i);

            try {
                if (resultList.get(nowSize - 1).equals(nowChar)) {
                    deleteChar = nowChar;
                    resultList.remove(nowSize - 1);
                } else if (deleteChar.equals(nowChar)) {
                    continue;
                } else {
                    resultList.add(nowChar);
                    deleteChar = '.';
                }
            } catch (Exception e) {
                resultList.add(nowChar);
            }
        }

        resultString = resultList.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat);

        return resultString;
    }
}
