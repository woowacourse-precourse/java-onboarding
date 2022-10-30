package onboarding;

class NumberFroPro3 {

    private final static int FIRST_NUMBER = 1;
    private final static int LAST_NUMBER = 10000;

    private int number;

    public NumberFroPro3(int number) {
        validateNumber(number);
        this.number = number;
    }

    public void validateNumber(int number) {
        if (FIRST_NUMBER > number || number > LAST_NUMBER) {
            throw new IllegalArgumentException(
                "number는 " + FIRST_NUMBER + "이상 " + LAST_NUMBER + "이하의 정수여야 합니다.");
        }
    }
}

public class Problem3 {
    public static int solution(int number) {
        NumberFroPro3 numberClass = new NumberFroPro3(number);
        int answer = 0;
        return answer;
    }
}
