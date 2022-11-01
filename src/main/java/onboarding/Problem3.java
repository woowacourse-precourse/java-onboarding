package onboarding;

import java.util.regex.Pattern;

public class Problem3 {

    // 반복되는 숫자에서 369가 포함되는지 확인하는 메서드
    static int judgeNumber(String element) {
        int answerNumber = 0;
        Pattern pattern = Pattern.compile("^([369]*)$");
        for (int j = 0; j < element.length(); j++) {
            String elementNumber = Character.toString(element.charAt((j)));
            if (pattern.matcher(elementNumber).matches()) {
                answerNumber += 1;
            }
        }
        return answerNumber;
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