package onboarding;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Problem3 {


    static class Number {

        final static int START_RANGE = 1;
        final static int END_RANGE = 10_000;
        protected int value;

        public Number(int value) {
            if (!isValidNumber(value)) {
                throw new InputMismatchException("입력 범위가 [1, 10_000] 안에 있지 않습니다.");
            }
            this.value = value;
        }

        private static boolean isValidNumber(int num) {
            return START_RANGE <= num && num <= END_RANGE;
        }

        List<Integer> getDigits(int num) {
            List<Integer> digits = new ArrayList<>();

            while (num > 0) {
                digits.add(num % 10);
                num /= 10;
            }

            return digits;
        }
    }

    static class NumberInClapGame extends Number {

        static final int[] CLAP_CASES = {3, 6, 9};

        public NumberInClapGame(int value) {
            super(value);
        }

        static public boolean isClapCase(int oneDigitNum) {

            for (int clapCase : CLAP_CASES) {
                if (oneDigitNum == clapCase) {
                    return true;
                }
            }
            return false;
        }

        public int clapCount() {
            int ret = 0;

            List<Integer> digits = getDigits(value);

            for (int digit : digits) {
                if (isClapCase(digit)) {
                    ++ret;
                }
            }

            return ret;
        }
    }

    static public NumberInClapGame makeNumberInClapGame(int num) {
        return new NumberInClapGame(num);
    }


    public static int getClapCountSum(int maxNum) {
        if(!Number.isValidNumber(maxNum))
            throw new InputMismatchException("입력한 수의 범위가 유효하지 않습니다.");

        int ret = 0;

        for (int clapNum = maxNum; clapNum > 0; --clapNum) {
            ret += makeNumberInClapGame(clapNum).clapCount();
        }

        return ret;
    }

    public static int solution(int number) {
        return getClapCountSum(number);
    }
}
