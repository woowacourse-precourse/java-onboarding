package onboarding;

import java.util.List;

public class Problem3 {
    private static final List<Integer> number369 = List.of(3, 6, 9);
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int num = i;
            while(num > 0) {
                if(number369.contains(num % 10)) {
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }
}
