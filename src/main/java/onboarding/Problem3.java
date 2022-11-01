package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while (number > 2) {
            answer += check(number);
            number -= 1;
        }

        return answer;
    }

    private static int check(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n%10 == 3 || n%10 == 6 || n%10 == 9) cnt += 1;
            n /= 10;
        }
        return cnt;
    }
}
