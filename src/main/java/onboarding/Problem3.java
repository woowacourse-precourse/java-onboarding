package onboarding;

public class Problem3 {
    public static int crapCount(int number) {
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            numberBuilder.append(i);
        }
        return (int) numberBuilder.chars()
                .filter(a -> a == '3' || a == '6' || a == '9')
                .count();
    }
    public static int solution(int number) {
        // 1. 각 숫자 개별로 stringBuilder 에 넣은 후 3,6,9 필터링 및 카운터
        return crapCount(number);
    }
}
