package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean validation(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // case1) 페이지가 1~400 사이의 범위에 있지 않다.
        if (leftPage <= 1 || leftPage >= 400 || rightPage <= 1 || rightPage >= 400){
            return false;
        }
        // case2) 왼쪽 페이지가 홀수가 아니다.
        if (leftPage % 2 != 1){
            return false;
        }
        //case4) 페이지가 연속된 숫자가 아니다.
        if (leftPage+1 != rightPage){
            return false;
        }

        return true;
    }
}