package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 각 자리 숫자를 확인해 3, 6, 9 중 하나일 경우는 answer += 1
        for (int i = 1; i <= number; i++) {
            int res = i;
            while (res != 0) {
                if (res % 10 == 3 || res % 10 == 6 || res % 10 == 9) answer += 1;
                res /= 10;
            }
        }
        return answer;
    }
}
