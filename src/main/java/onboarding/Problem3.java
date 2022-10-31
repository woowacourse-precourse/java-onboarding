package onboarding;

public class Problem3 {

    private static int count(int number) {
        int cnt = 0;
        while (number != 0) {
            int temp = number % 10;
            if (temp != 0 && temp % 3 == 0) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            answer += count(i);
        }
        return answer;
    }
}
