package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            // 1. 숫자를 문자열 리스트로 변형
            answer += counter(String.valueOf(i).toCharArray());
            }
        return answer;
    }

    // 2. 리스트에 3,6,9가 포함되면 개수만큼 세어서 반환
    public static int counter(char[] num) {
        int count = 0;
        String[] arr = {"3", "6", "9"};
        for (char x : num) {
            if (Arrays.asList(arr).contains(String.valueOf(x))) {
                count += 1;
            }
        }
        return count;
    }
}
