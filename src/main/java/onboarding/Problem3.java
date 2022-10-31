package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = count369(number);
        return answer;
    }

    private static int count369(int number) {
        String numStr;
        Pattern pattern;
        Matcher match;
        int count = 0;
        for(int i = 1; i < number+1; i++) {
            numStr = Integer.toString(i);
            pattern = Pattern.compile("([369])");
            match = pattern.matcher(numStr);
            while(match.find()) {
                count = count + 1;
            }
        }
        return count;
    }
}