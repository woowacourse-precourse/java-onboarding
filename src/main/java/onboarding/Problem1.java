package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static Boolean handleException(int leftPage, int rightPage) {   // 예외 사항 처리
        if (rightPage - leftPage > 1) {             // 연속된 페이지가 아닐 경우
            return true;
        }
        if (leftPage == 1 || rightPage == 400) {    // 시작면(1, 2)나 마지막 면(399, 400)이 포함되어 있을 경우
            return true;
        }
        return false;
    }

    static int sumPage(int rightPage) {
        int sum = 0;

        String numPage = Integer.toString(rightPage);
        char[] numPageChar = numPage.toCharArray();

        for (char x : numPageChar) {
            sum += x - '0';
        }

        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = pobi.get(1);

        // 포비와 크롱의 예외 확인
        Boolean isExceptionPobi = handleException(pobiLeftPage, pobiRightPage);
        Boolean isExceptionCrong = handleException(crongLeftPage, crongRightPage);

        if (isExceptionPobi || isExceptionCrong) {
            answer = -1;
        }

        int sumPobi = sumPage(pobiRightPage);
        int sumCrong = sumPage(crongRightPage);

        return answer;
    }

}