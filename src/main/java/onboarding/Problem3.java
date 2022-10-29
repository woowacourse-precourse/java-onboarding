package onboarding;

public class Problem3 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 10000;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static void validateRange(String input) {
        int inputLength = input.length();
        if (inputLength < MIN_RANGE_NUM || inputLength > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("1 이상 10000 이하인 자연수를 입력하세요.");
        }
    }
}
