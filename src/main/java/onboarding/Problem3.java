package onboarding;

public class Problem3 {
    public static final int MINIMUM_STRING_LENGTH = 1;
    public static final int MAXIMUM_STRING_LENGTH = 10000;
    public static int solution(int number) {
        validateRange(number);
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String iToString = String.valueOf(i);
        }
        return answer;
    }
    public static void validateRange(int number) {
        if (number < MINIMUM_STRING_LENGTH || MAXIMUM_STRING_LENGTH < number) {
            throw new IllegalArgumentException();
        }
    }
}
