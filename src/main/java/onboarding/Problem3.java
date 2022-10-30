package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1 ; i<=number ; i++) {
            int n = i;
            while (n > 0) {
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                    answer += 1;
                }
                n /= 10;
            }
        }

        return answer;
    }
}
