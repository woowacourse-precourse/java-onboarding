package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {


        int count = 0;
        for (int i = 1; i <= number; i++) {

            String numberStr = String.valueOf(i);
            if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
                count++;

                if (numberStr.length() >= 2) {
                    Pattern patternRegex = setRegex();
                    Matcher patternMatcher = patternRegex.matcher(numberStr);
                    if (patternMatcher.find()) {
                        count++;
                    }
                }
            }
        }

        int answer = count;
        return answer;

    }

    private static Pattern setRegex() {
        String regex = "[369]{2}";
        Pattern patternRegex = Pattern.compile(regex);
        return patternRegex;
    }
}
