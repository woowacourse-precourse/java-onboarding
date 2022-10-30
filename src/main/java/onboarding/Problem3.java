package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    private static final List<Character> checkList = Arrays.asList('3', '6', '9');

    // 박수를 몇 번 치는지 계산하는 메서드
    private static int isClap(int num) {
        int answer = 0;
        String s = String.valueOf(num);
        for(int i = 0; i < s.length(); i++) {
            if(checkList.contains(s.charAt(i)))
                answer++;
        }
        return answer;
    }

    // 1번부터 돌면서 박수를 몇 번 쳐야하는 지 계산후 합산
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += isClap(i);
        }
        return answer;
    }
}
