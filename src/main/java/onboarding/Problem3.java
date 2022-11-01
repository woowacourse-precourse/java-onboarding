package onboarding;

import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        Pattern pattern = Pattern.compile("[369]");

        for (int i = 1; i <= number; i++) {
            String num = Integer.toString(i);

            int clap = num.length() - pattern.matcher(num).replaceAll("").length();

            answer += clap;
        }

        return answer;
    }
}
