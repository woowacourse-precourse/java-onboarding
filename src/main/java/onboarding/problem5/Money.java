package onboarding.problem5;

public class Money {

    // 입력된 금액의 유효성 검증 기능
    public static void validate(int money) {
        isPriceBetween(money);
    }

    // money는 1 이상 1,000,000 이하인 자연수이다.
    public static void isPriceBetween(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("입력된 금액은 1 이상 1,000,000 이하여야 합니다.");
        }
    }

}
