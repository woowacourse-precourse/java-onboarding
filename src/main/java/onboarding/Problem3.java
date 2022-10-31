package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

class Clap {
    private int number;
    private int clap;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;
    private static final int START_NUMBER=1;
    private static final String NOT_ALLOWED_UNDER_MIN_NUMBER = "number은 최소 1 입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_NUMBER = "number은 최대 1000 입니다.";

    public Clap(){
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (number < MIN_NUMBER) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_NUMBER);
        }
        if (number > MAX_NUMBER) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_NUMBER);
        }
    }
}
