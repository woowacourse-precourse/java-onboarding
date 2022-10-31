package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //페이지가 처음이나 마지막 면이 아닌지 체크
    private static boolean isValidPage(int startPage, int endPage) {
        return startPage >= 1 && endPage <= 400;
    }

    //페이지가 연속된 페이지인지 체크
    private static boolean isConsecutivePages(int startPage, int endPage) {
        return startPage + 1 == endPage;
    }

    //페이지의 왼쪽면이 홀수이고 오른쪽 면이 짝수인치 체크
    private static boolean isCorrectOddAndEven(int startPage, int endPage) {
        return startPage % 2 == 1 && endPage % 2 == 0;
    }
}