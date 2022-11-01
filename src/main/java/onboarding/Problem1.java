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
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 첫번째 페이지 또는 마지막 페이지인 경우 False를 반환한다.
     * @param pageNum 페이지 번호
     * @return boolean
     */
    private boolean checkFirstOrEnd(int pageNum){
        return pageNum != firstPageNum && pageNum != lastPageNum;
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

}