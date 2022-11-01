package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        try {
            exception(pobi);
            exception(crong);
        } catch (IllegalArgumentException e) {
            answer = -1;
            return answer;
        }
        int pobiNum = Math.max(findMaxPageNum(pobi.get(0)), findMaxPageNum(pobi.get(1)));
        int crongNum = Math.max(findMaxPageNum(crong.get(0)), findMaxPageNum(crong.get(1)));
        if (pobiNum == crongNum) {
            answer = 0;
            return answer;
        } else if (pobiNum > crongNum) {
            answer = 1;
            return answer;
        }
        answer = 2;
        return answer;
    }
    private static void exception(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if (pages.size() != 2 || left <= 1 || right >= 400 || left % 2 != 1 || right % 2 != 0 || right - left != 1) {
            throw new IllegalArgumentException("책 페이지 입력에 오류가 있습니다.");
        }
    }
    private static int findMaxPageNum(int page) {
        int plus = 0;
        int multiply = 1;
        do {
            plus += page % 10;
            multiply *= page % 10;
            page /= 10;
        } while (page != 0);
        return Math.max(plus, multiply);
    }
}