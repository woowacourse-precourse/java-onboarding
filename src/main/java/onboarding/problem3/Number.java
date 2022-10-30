package onboarding.problem3;

public class Number {

    // number는 1 이상 10,000 이하인 자연수이다.
    public static void validate(int num) {
        if (num < 1 || num > 10000) {
            throw new IllegalArgumentException("입력값은 1 이상 10,000 이하인 자연수여야 합니다.");
        }
    }

    // 해당 숫자에 3,6,9가 포함되는 횟수를 반환하는 메서드
    public static Integer hasThreeSixNine(int num) {
        int count = 0;
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '3' || numStr.charAt(i) == '6' || numStr.charAt(i) == '9') {
                count++;
            }
        }
        return count;
    }
}
