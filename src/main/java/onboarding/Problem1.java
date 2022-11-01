package onboarding;

import java.util.List;

class Problem1 {
    private static boolean isInRange(int page) {
        return page >= 3 && page <= 398;
    }
    private static boolean isEven(int page) {
        return page % 2 == 0;
    }
    private static boolean isPair(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }
    private static boolean isValidPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (!(isInRange(leftPage) && isInRange(rightPage))) {
            return false;
        }
        if (isEven(leftPage) || !isEven(rightPage)) {
            return false;
        }
        return isPair(leftPage, rightPage);
    }
    private static int sumOfDigit(int page) {
        String pageToString = Integer.toString(page);
        int sum = 0;
        for (int i = 0; i < pageToString.length(); i++) {
            int digit = pageToString.charAt(i) - '0';
            sum += digit;
        }
        return sum;
    }
    private static int productOfDigit(int page) {
        String pageToString = Integer.toString(page);
        int product = 1;
        for (int i = 0; i < pageToString.length(); i++) {
            int digit = pageToString.charAt(i) - '0';
            product *= digit;
        }
        return product;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}