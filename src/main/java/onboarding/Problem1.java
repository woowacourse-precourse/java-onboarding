package onboarding;

import java.util.List;

/**
 * 기능목록
 * 1. 예외사항 확인
 * 2. 페이지를 더한 점수
 * 3. 페이지를 곱한 점수
 * 4. 왼쪽 페이지 점수
 * 5. 오른쪽 페이지 점수
 * 6. 플레이어 점수
 * 7. 책의 주인은?
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(catchError(pobi)||catchError(crong)){
            return -1;
        }
        return answer;
    }

    static boolean catchError(List<Integer> pages){
        if(pages.get(0)+1 != pages.get(1)){
            return true;
        }
        return false;
    }

    static int addPageNum(int page){
        int sum = 0;
        while(page>0){
            sum+=page%10;
            page=page/10;
        }
        return sum;
    }
}