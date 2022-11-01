package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++)
            answer += countClap(i);

        return answer;
    }
    private static int countClap(int i) {
        int clap = 0;
        while (i > 0) {
            int digit = i % 10;
            if (digit > 0 && digit % 3 == 0)
                clap++;

            i /= 10;
        }
        return clap;
    }
}