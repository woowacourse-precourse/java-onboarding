package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
         * 1. 우선, 페이지 번호의 유효성을 검증한다.
         * */
        int answer = Integer.MAX_VALUE;

        // 1. 페이지 유효성 검증
        if (isValidPage(pobi) == false || isValidPage(crong) == false){
            return -1;
        }

        return answer;
    }

    static public boolean isValidPage(List<Integer> bookPages) {
        int leftPage = bookPages.get(0);
        int rightPage = bookPages.get(1);

        // 각 페이지의 번호가 [1,400]을 벗어나는 경우
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
            return false;
        }

        // 왼쪽 페이지가 홀수 번호가 아니거나 오른쪽 페이지가 짝수 번호가 아닌 경우
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return false;
        }

        // 연속된 페이지가 아닌 경우
        if (rightPage - leftPage != 1) {
            return false;
        }

        return true;
    }
}
