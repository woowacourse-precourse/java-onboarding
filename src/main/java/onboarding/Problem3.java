package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Character> clapNum = List.of('3', '6', '9');
        for (int i = 1; i <= number; i++) {
            String stringI = i + "";
            char[] charsI = stringI.toCharArray();
            for (char c : charsI) {
                if (clapNum.contains(c)) answer++;
            }
        }
        return answer;
    }
}
