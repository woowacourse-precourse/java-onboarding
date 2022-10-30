package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (checkValidation(cryptogram)) {
            while(checkDuplicateString(cryptogram)) {
                cryptogram = getAmendString(cryptogram);
            }
            answer = cryptogram;
        } else {
            answer = "-1";
        }

        return answer;
    }

    private static boolean checkValidation(String inputString) {
        int inputStringLength;

        // null 값이 들어갔는지 확인하다.
        if (inputString == null) {
            return false;
        }

        inputStringLength = inputString.length();

        // 길이가 1 이상 400 이하여야 한다.
        if (!(1 <= inputStringLength && inputStringLength <= 400)) {
            return false;
        }

        // 알파벳 소문자만 들어 있어야 한다.
        String pattern = "^[a-z]+$";
        if (!Pattern.matches(pattern, inputString)) {
            return false;
        }

        return true;
    }

    private static boolean checkDuplicateString(String inputString) {
        IntStream inputIntStream = inputString.chars();
        int result = inputIntStream.reduce(0, (a, b) -> a == -1 ? a : (a == b) ? -1 : b);

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
