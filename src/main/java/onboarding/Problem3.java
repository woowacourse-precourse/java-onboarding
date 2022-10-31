package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    private static int countClaps(int n) {
        int clap = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit > 0 && digit % 3 == 0)
                clap++;

            n /= 10;
        }
        return clap;
    }
}