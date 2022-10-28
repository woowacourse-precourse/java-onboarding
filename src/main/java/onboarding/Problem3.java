package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean isRemain369(int number) {
        int remainder = number % 10;
        if (remainder == 3 || remainder == 6 || remainder == 9) {
            return true;
        }
        return false;
    }
}
