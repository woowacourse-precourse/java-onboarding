package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int calculateClapCount(int num) {
        int clapCount = 0;
        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 3 || remainder == 6 || remainder == 9) {
                clapCount++;
            }
            num /= 10;
        }
        return clapCount;
    }
}
