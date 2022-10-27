package onboarding;

public class Problem3 {
    static int result;

    public static int solution(int number) {
        result = 0;
        for (int num = 1; num <= number; num++) {
            check369(num);
        }

        return result;
    }
}
