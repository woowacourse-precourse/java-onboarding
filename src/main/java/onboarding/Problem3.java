package onboarding;

public class Problem3 {
    public static int solution(int number) {
        validate(number);
        return 0;
    }

    private static void validate(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("number는 1 이상 10,000 이하인 자연수이어야 합니다.");
        }
    }

    private static int addClapNumber(int clapCount, int number) {
        if (isClapCondition(number)) {
            clapCount++;
        }
        return clapCount;
    }

    private static boolean isClapCondition(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
