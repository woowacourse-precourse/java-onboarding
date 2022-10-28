package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (checkValidation(word)) {

        } else {
            answer = "-1";
        }

        return answer;
    }

    public static boolean checkValidation(String inputString) {
        int inputStringLength = inputString.length();

        // 길이가 1 이상 1,000 이하인지 확인한다.
        if (!(1 <= inputStringLength && inputStringLength <= 1000)) {
            return false;
        }

        return true;
    }

    public static String convertReverse(String inputString) {
        IntStream inputIntStream = inputString.chars();
        List<Character> resultList = new ArrayList<>();
        String result;

        inputIntStream.forEach(x -> {
            if (isUppercase(x)) {

            } else if (isLowercase(x)) {

            } else {

            }
        });

        return result;
    }

    public static boolean isUppercase(int intValue) {
        if (!('A' <= intValue && intValue <= 'Z')) {
            return false;
        }

        return true;
    }

    public static boolean isLowercase(int intValue) {
        if (!('a' <= intValue && intValue <= 'z')) {
            return false;
        }

        return true;
    }
}
