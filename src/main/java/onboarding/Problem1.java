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

    static boolean isFirstOrLastPage(List<Integer> pages) {
        return pages.get(0) == 1 || pages.get(1) == 400;
    }

    static boolean isConsecutive(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    static int getAnswer(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getBiggerScore(pobi);
        int crongScore = getBiggerScore(crong);
        int answer;
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 시작 면이나 마지막 면을 펼칠 경우
        if (isFirstOrLastPage(pobi) || isFirstOrLastPage(crong)) {
            answer = -1;
            // 왼쪽과 오른쪽 페이지의 차이가 한 페이지가 아닐 경우
        } else if (isConsecutive(pobi) || isConsecutive(crong)) {
            answer = -1;
        } else {
            answer = getAnswer(pobi, crong);
        }
        return answer;
    }
}