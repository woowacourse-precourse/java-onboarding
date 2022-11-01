package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = 0;
            int n = i;
            while (n > 0) {
                int tmp = n % 10;
                if (tmp == 3 || tmp == 6 || tmp == 9) count++;
                n /= 10;
            }
            answer += count;
        }
        return answer;
    }

}

