package onboarding;


import java.util.Arrays;
import java.util.List;


public class Problem3 {
    static List<Character> entry = Arrays.asList('3', '6', '9');

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += validCnt(i);
        }
        return answer;
    }


    public static int validCnt(int val) {
        int result = 0;
        char[] chars = String.valueOf(val).toCharArray();
        for (char ch : chars) {
            if (entry.contains(ch)) result++;
        }
        return result;
    }
}
