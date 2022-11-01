package onboarding;

import java.util.regex.Pattern;

public class Problem3 {

    static int judgeNumber(String element) {
        int answernumber = 0;
        Pattern pattern = Pattern.compile("^([369]*)$");
        for (int j = 0; j < element.length(); j++) {
            String elementnumber = Character.toString(element.charAt((j)));
            if (pattern.matcher(elementnumber).matches()) {
                answernumber += 1;
            }
        }
        return answernumber;
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String element = Integer.toString((i));
            answer += judgeNumber(element);
        }

        return answer;
    }
}
