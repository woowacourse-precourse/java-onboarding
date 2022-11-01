package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int target = i;
            // 1. 각자리가 3, 6, 9인지 확인하고 개수를 셈.
            while (target != 0) {
                if (target % 10 == 3 || target % 10 == 6 || target % 10 == 9){
                    answer++;
                }
                target /= 10;
            }
        }
        return answer;
    }
}
