package onboarding;

public class Problem3 {
    private static final int[] TARGET_NUMBERS = {3, 6, 9};

    public static int solution(int number) {
        int answer = getAnswer(number);
        return answer;
    }

    public static int getAnswer(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += countTargetNum(i);
        }
        return cnt;
    }

    public static int countTargetNum(int number) {

        return 0;
    }
}
