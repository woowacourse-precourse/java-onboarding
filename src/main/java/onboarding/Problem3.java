package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    static String getRangedString(int n) {
        String StringNumber = IntStream.rangeClosed(1, n).mapToObj(String::valueOf).reduce("", String::concat);
        return StringNumber;
    }

    static int getCountOfNumbers(String s) {
        String reducedString = getReducedString(s);
        return reducedString.length();
    }

    static String getReducedString(String s) {
        return s.replaceAll("([^3|6|9])","");
    }

    public static int solution(int number) {
        int answer = 0;
        String numberString = getRangedString(number);
        answer = getCountOfNumbers(numberString);
        return answer;
    }
}
