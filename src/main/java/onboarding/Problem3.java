package onboarding;

/**
 * 기능 목록
 * 1. 정수 1부터 주어진 정수 number까지 반복
 * 2. 현재 숫자 num의 1의 자릿수부터 마지막 자릿수까지 자릿수의 길이만큼 반복
 * 3. 현재 숫자 num의 자릿수의 길이를 확인하고 기존 자릿수보다 큰 수라면 자릿수 길이를 늘려줌
 * 4. 일의 자리 숫자인지 검증
 * 5. 현재 숫자 num의 1의 자릿수 값을 반환
 * 6. 현재 숫자 num과 2 이상의 자릿수 마스킹을 이용해 특정 자릿수 값을 반환
 * 7. 햔제 자릿수 값이 박수치는 조건인지 검증
 * 8. 현재 자릿수 값이 3, 6, 9로 나누어 떨어지는 지 검증
 */
public class Problem3 {
    static final int ONE_DIGIT_MASK = 10;

    /* 시간 복잡도 : O(N*L), N in [1, 10000], L in [1, 5] */
    public static int solution(int number) {
        int answer = 0;
        int digitLength = 1;
        for (int num = 1; num <= number; num++) {
            if (isNumBiggerThanDigitLength(num, digitLength)) digitLength++;
            /* 자리수 갯수만큼 반복하며 각 자리수에 대해 반복 */
            for (int digit = 1; digit <= digitLength; digit++) {
                int digitMask = (int) Math.pow(10, digit - 1);
                int digitValue = isOneDigitNumber(digitMask) ? getOneDigitValue(num) : getOtherDigitValue(num, digitMask);
                if (isClapCondition(digitValue)) answer++;
            }
        }
        return answer;
    }

    static boolean isNumBiggerThanDigitLength(int number, int digitLength) {
        return number >= Math.pow(10, digitLength);
    }

    static boolean isOneDigitNumber(int digitMask) {
        return digitMask == 1;
    }

    static int getOneDigitValue(int digitValue) {
        return digitValue % ONE_DIGIT_MASK;
    }

    static int getOtherDigitValue(int digitValue, int digitMask) {
        return digitValue / digitMask;
    }

    static boolean isClapCondition(int digitValue) {
        if (digitValue == 0) return false;
        return isModThreeZero(digitValue) || isModSixZero(digitValue) || isModNineZero(digitValue);
    }

    static boolean isModThreeZero(int digitValue) {
        return digitValue % 3 == 0;
    }

    static boolean isModSixZero(int digitValue) {
        return digitValue % 6 == 0;
    }

    static boolean isModNineZero(int digitValue) {
        return digitValue % 9 == 0;
    }
}
