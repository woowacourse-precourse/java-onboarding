package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            return getAnswer(getMaxPoint(pobi), getMaxPoint(crong));
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private static int getAnswer(int pobiPoint, int crongPoint) {
        if (pobiPoint > crongPoint) {
            return 1;
        }
        if (pobiPoint < crongPoint) {
            return 2;
        }
        return 0;
    }

    public static int getMaxPoint(List<Integer> pages) {
        int page1 = pages.get(0);
        int page2 = pages.get(1);
        validatePage(page1, page2);
        int leftMax = Math.max(getPlusNum(page1), getMultiplyNum(page1));
        int rightMax = Math.max(getMultiplyNum(page2), getMultiplyNum(page2));
        return Math.max(leftMax, rightMax);
    }

    private static void validatePage(int page1, int page2) {
        if ((page1 + 1 != page2) || page1 % 2 == 0 || page2 % 2 == 1 || page1 < 1 || page2 > 400) {
            throw new IllegalArgumentException("페이지 번호 에러");
        }
    }

    public static int getPlusNum(int num) {
        int result = 0;
        String s = Integer.toString(num);
        for (char c : s.toCharArray()) {
            result += c - '0';
        }
        return result;
    }

    public static int getMultiplyNum(int num) {
        int result = 1;
        String s = Integer.toString(num);
        for (char c : s.toCharArray()) {
            result *= c - '0';
        }
        return result;
    }
}