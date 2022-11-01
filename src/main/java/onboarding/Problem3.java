package onboarding;


/**
 * getClapCount 메서드 1부터 n까지 3,6,9가 들어가면 카운트를 증가시키고 그 값을 환반환
 * isProperNumber 메서드 number범위가 1~10000인지 확인
 */

public class Problem3 {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        isProperNumber(number);
        return getClapCount(number);
    }

    private static void isProperNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException("숫자는 1이상 10000이하인 자연수입니다.");
    }

    private static int getClapCount(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            clapCount += String.valueOf(i)
                    .chars()
                    .filter(num -> num == '3' || num == '6' || num == '9').count();
        }
        return clapCount;
    }
}