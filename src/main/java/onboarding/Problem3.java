package onboarding;

public class Problem3 {
    /**
     * 박수쳐야할 숫자 배열
     * 혹시 모를 문제의 확장에 대비해 전역으로 생성
     */
    static int[] checkNumber = {3, 6, 9};

    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result = verify(result, i);
        }

        return result;
    }

    /**
     * 현재 숫자의 박수 횟수를 덧셈해 결과값으로 리턴하는 메소드
     * 전역 변수를 최소한하고 싶었기에 인자와 리턴 값으로 result 이용.
     */
    private static int verify(int result, int i) {
        int pow = 0;
        while (i >= Math.pow(10, pow)) {
            int n = digitNumber(i, pow);
            if (needCrap(n)) {
                result += 1;
            }
            pow += 1;
        }
        return result;
    }

    /**
     * 자리수 별 숫자 파악 메소드
     */
    private static int digitNumber(int number, int pow) {
        return number % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
    }


    /**
     * 박수 쳐야하는 숫자인지 확인 메소드
     */
    private static boolean needCrap(int number) {
        for (int check : checkNumber) {
            if (check == number) {
                return true;
            }
        }
        return false;
    }
}
