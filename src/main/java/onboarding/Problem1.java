package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Integer pobiLeft = pobi.get(0);
        Integer pobiRight = pobi.get(1);
        Integer crongLeft = crong.get(0);
        Integer crongRight = crong.get(1);

        // 예외처리
        if (!isValid(pobiLeft, pobiRight) || !isValid(crongLeft, crongRight)) {
            answer = -1;
            return answer;
        }

        int pobiResult = getMax(getMax(getSum(pobiLeft), getMul(pobiLeft)), getMax(getSum(pobiRight), getMul(pobiRight)));
        int crongResult = getMax(getMax(getSum(crongLeft), getMul(crongLeft)), getMax(getSum(crongRight), getMul(crongRight)));

        if (pobiResult > crongResult) {
            answer = 1;
        } else if (pobiResult < crongResult) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int getSum(int n) {
        int result = 0;

        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static int getMul(int n) {
        int result = 1;

        while (n != 0) {
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else return b;
    }
    public static boolean isValid(int a, int b) { // 검증 모음
        if(validOdd(a) && validEven(b) && validNext(a, b) && validRange(a) && validRange(b)) {
            return true;
        } else return false;
    }
    public static boolean validOdd(int a) { // 홀수 검증
        if (a % 2 == 0) {
            return false;
        } else return true;
    }
    public static boolean validEven(int a) { // 짝수 검증
        if (a % 2 == 0) {
            return true;
        } else return false;
    }
    public static boolean validNext(int a, int b) { // 다음 숫자 검증
        if (a + 1 == b) {
            return true;
        } else return false;
    }
    public static boolean validRange(int a) { // 범위 검증
        if (a >= 0 && a <= 400) {
            return true;
        } else return false;
    }

}