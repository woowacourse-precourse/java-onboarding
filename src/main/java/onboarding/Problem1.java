package onboarding;

import java.util.List;

class Problem1 {
    static int getSumOfDigits(char[] digits) {
        int sum = 0;
        for (int i : digits) {
            i -= 48;
            sum += i;
        }
        return sum;
    }

    static int getProductOfDigits(char[] digits) {
        int product = 1;
        for (int i : digits) {
            i -= 48;
            product *= i;
        }
        return product;
    }

    static int getBiggerNumber(char[] digits) {
        int sum = getSumOfDigits(digits);
        int product = getProductOfDigits(digits);
        return sum > product ? sum : product;
    }

    static char[] getDigitsOfNumber(int number) {
        return String.valueOf(number).toCharArray();
    }

    static int getBiggerScore(List<Integer> numbers) {
        char[] leftdigits = getDigitsOfNumber(numbers.get(0));
        char[] rightdigits = getDigitsOfNumber(numbers.get(1));
        int leftNumber = getBiggerNumber(leftdigits);
        int rightNumber = getBiggerNumber(rightdigits);
        return leftNumber > rightNumber ? leftNumber : rightNumber;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400) {
            answer = -1;
        } else if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
        } else {
            int pobiScore = getBiggerScore(pobi);
            int crongScore = getBiggerScore(crong);
            if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}