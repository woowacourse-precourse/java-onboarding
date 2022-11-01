package onboarding;

import java.util.List;

/*
* # 기능 정리
* [O] 입력 검증
* [O] 페이지 덧셈 메소드
* [O] 페이지 곱셈 메소드
* [O] 각 페이지 계산치 최고값 계산
* [O] solution 작성
* [O] 테스트 확인
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try{
            validatePage(pobi);
            validatePage(crong);
        } catch (IllegalArgumentException e){
            return -1;
        }

        int pobiHighScore = getScoreOnPage(pobi);
        int crongHighScore = getScoreOnPage(crong);

        if(pobiHighScore > crongHighScore)
            answer = 1;
        if(pobiHighScore < crongHighScore)
            answer = 2;

        return answer;
    }

    private static void validatePage(final List<Integer> pages){
        if(pages.get(0) + 1 != pages.get(1))
            throw new IllegalArgumentException("연속되지 않은 페이지입니다.");
    }

    private static int getScoreOnPage(final List<Integer> pages){
        int left = Math.max(plusPage(pages.get(0)),timesPage(pages.get(0)));
        int right = Math.max(plusPage(pages.get(1)),timesPage(pages.get(1)));

        return Math.max(left, right);
    }

    private static int plusPage(int page){
        int pageSumResult = 0;

        while(page > 0){
            pageSumResult += page % 10;
            page /= 10;
        }

        return pageSumResult;
    }

    private static int timesPage(int page){
        int pageTimesResult = 1;

        while(page > 0){
            pageTimesResult *= page % 10;
            page /= 10;
        }

        return pageTimesResult;
    }
}