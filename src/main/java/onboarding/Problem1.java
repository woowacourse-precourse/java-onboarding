package onboarding;

import java.util.List;

/**
 *
 * 구현할 기능 목록
 * 1. 페이지 유효성 검증 기능
 *       1.1. 시작 면이나 마지막 면이 나오면 안된다.
 *       1.2. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호여야한 한다.
 *       1.3. 왼쪽 페이지 번호와 오른쪽 페이지 번호는 연속되어야 한다.
 *
 *
 * 2. 승부에 낼 점수 계산 기능
 *      2.1. 각 페이지 자릿수를 더하거나 곱해서 가장 큰 수가 해당 페이지의 점수가 된다.
 *      2.2. 왼쪽 오른쪽 페이지의 점수중 가장 큰 수가 자신의 점수가 된다.
 *
 */

class Problem1 {

    static final int START_PAGE = 1;   // 시작 페이지
    static final int END_PAGE = 400; // 마지막 페이지

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if(!(isValidatePage(pobi) && isValidatePage(crong))){
            return -1;
        }

        int pobiScore = calScore(pobi);
        int crongScore = calScore(crong);

        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }

        return 2;

    }

    //페이지 유효성 검증
    private static boolean isValidatePage(List<Integer> pages){

        if(pages.size() != 2){
            return false;
        }

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호인지 확인
        if (leftPage % 2 == 0 && rightPage % 2 == 1) {
            return false;
        }
        // 시작 면이나 마지막 면인지 확인
        if (leftPage == START_PAGE || rightPage == END_PAGE) {
            return false;
        }
        // 페이지 번호가 유효한 번호인지 확인
        if (leftPage < START_PAGE || leftPage > END_PAGE || rightPage < START_PAGE || rightPage > END_PAGE) {
            return false;
        }
        // 왼쪽 페이지 번호와 오른쪽 페이지 번호가 연속되는지 확인
        if (rightPage - leftPage != 1) {
            return false;
        }
        return true;
    }

    //승부에 낼 점수 계산
    private static int calScore(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftMax = Math.max(sumPages(leftPage), mulPates(rightPage));
        int rightMax = Math.max(sumPages(rightPage), mulPates(rightPage));

        // 왼쪽 오른쪽 페이지의 점수중 가장 큰 수가 자신의 점수가 됨
        return Math.max(leftMax, rightMax);

    }

    // 페이지 각 자릿수 합 구하기
    private static int sumPages(int page){
        int sum = 0;

        while(page>0){
            sum += (page % 10);
            page /= 10;
        }
        return sum;
    }
    // 페이지 각 자릿수 곱 구하기
    private static int mulPates(int page){
        int mul = 1;

        while (page > 0) {
            mul *= (page % 10);
            page /= 10;
        }

        return mul;
    }


}