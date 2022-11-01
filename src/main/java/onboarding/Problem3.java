package onboarding;

public class Problem3 {

    private static int countClap(int num) {
        int cnt = 0;

        while (num > 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                cnt++;
            }
            num /= 10;
        }
        return (cnt);
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }
}
