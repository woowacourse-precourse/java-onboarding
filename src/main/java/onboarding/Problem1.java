package onboarding;

import java.util.List;

/**
 * 기능 요구사항
 * 1. 예외체크
 * 2. 페이지 번호 각 자리 숫자 합.
 * 3. 페이지 번호 각 자리 숫자 곱.
 * 4. 최종 점수 반환
 * 5. solution 구현
 */
class Problem1 {
    /**
     * 첫번째 페이지 default 1
     */
    private final int firstPageNum = 1;
    /**
     * 마지막 페이지 default 400
     */
    private final int lastPageNum = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();

        int pobiMaxScore = problem1.getMaxScore(pobi);
        int crongMaxScore = problem1.getMaxScore(crong);
        //예외발생
        if(pobiMaxScore == -1 || crongMaxScore == -1) return -1;
        //무승부
        if(pobiMaxScore == crongMaxScore) return 0;
        //포비 승 1, 크롱 승 2
        return pobiMaxScore > crongMaxScore ? 1 : 2;
    }

    /**
     * 첫번째 페이지 또는 마지막 페이지인 경우 True를 반환한다.
     * @param pageNum 페이지 번호
     * @return boolean
     */
    private boolean checkFirstOrEnd(int pageNum){
        return pageNum == firstPageNum || pageNum == lastPageNum;
    }
    private boolean checkPage(List<Integer> page){
        if(page.get(1) - page.get(0) != 1) return false;
        return true;
    }

    /**
     * 페이지 번호의 각 자리 숫자를 모두 더한다.
     * @param i 페이지 번호
     * @return 페이지 번호 각 자리 숫자 합.
     */
    private int getSumByIndex(int i){
        int sum = 0;
        while(i != 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    /**
     * 페이지 번호의 각 자리 숫자를 모두 곱한다.
     * @param i 페이지 번호
     * @return 페이지 번호 각 자리 숫자 곱.
     */
    private int getMultiplyByIndex(int i){
        int sum = 1;
        while(i != 0){
            sum *= i % 10;
            i /= 10;
        }
        return sum;
    }

    /**
     * 각 자리의 합과 곱 중 가장 큰 수를 반환한다.
     * @param data 페이지 번호 [34,35]
     * @return 각 자리의 합과 곱 중 가장 큰 수, <br/>예외발생 return -1
     */
    public int getMaxScore(List<Integer> data){
        Integer leftPage = data.get(0);
        Integer rightPage = data.get(1);
        //예외 처리
        if(!checkPage(data)) return -1;
        if(checkFirstOrEnd(leftPage) || checkFirstOrEnd(rightPage)) return -1;
        int leftMax = Math.max(getSumByIndex(leftPage), getMultiplyByIndex(leftPage));
        int rightMax = Math.max(getSumByIndex(rightPage), getMultiplyByIndex(rightPage));
        return Math.max(leftMax, rightMax);
    }

}