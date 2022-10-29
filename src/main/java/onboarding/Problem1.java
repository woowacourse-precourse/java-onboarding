package onboarding;

import java.util.List;

/*
기능 구현 사항
1. 게임 규칙에 맞는 각각의 점수 계산 기능
2. 예외처리를 위한 유효성 검사 기능
3. 규칙에 맞게 점수를 비교하여 결과를 출력하는 기능
*/

class Problem1 {
    static final int PAGE_MIN = 1;
    static final int PAGE_MAX = 399;
    static final int POBI_WIN_CASE = 1;
    static final int CRONG_WIN_CASE = 2;
    static final int DRAW_CASE = 0;
    static final int ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isValid(pobi) && isValid(crong)) {
            int pobiMaxScore = Math.max(getScore(pobi.get(0)), getScore(pobi.get(1)));
            int crongMaxScore = Math.max(getScore(crong.get(0)), getScore(crong.get(1)));
            return game(pobiMaxScore, crongMaxScore);
        }
        return ERROR;
    }

    public static int game(int pobiScore, int crongScore){
        int flag = crongScore - pobiScore;
        if(flag > 0){
            return CRONG_WIN_CASE;
        }
        else if(flag < 0){
            return POBI_WIN_CASE;
        }
        else
            return DRAW_CASE;
    }

    public static boolean isValid(List<Integer> page) {
        int frontPage = page.get(0);
        int endPage = page.get(1);
        if ((PAGE_MIN < frontPage && frontPage < PAGE_MAX) && frontPage % 2 == 1) {
            return endPage - frontPage == 1;
        }
        return false;
    }

    public static int getScore(int pageNumber) {
        int pageMult = 1;
        int pageSum = 0;
        while (pageNumber > 0) {
            int digit = pageNumber % 10;
            pageMult *= digit;
            pageSum += digit;
            pageNumber = pageNumber / 10;
        }
        return Math.max(pageMult, pageSum);
    }

}