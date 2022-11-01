package onboarding;

import java.util.List;

/**
 * 기능 구현 사항
 *
 * 1. 페이지를 통해 max 값 추출
 * 2. return 값 정하기
 * 3. 예외처리 구현
 */

class Problem1 {
    /**
     *
     * 에러 항목
     * 1. 왼쪽 페이지가 홀수인가? 오른쪽 페이지가 짝수인가?
     * 2. 왼쪽 페이지는 오른쪽보다 작은가?
     * 3. 범위내의 페이지 수인가?
     * 4. 왼쪽 오른쪽 페이지 수의 차가 1인가?
     *
     * @param pages : 왼쪽, 오른쪽 페이지를 담은 인티저 리스트
     * @return : 에러가 검출될 시 true, 에러 검출 되지 않을 시 false
     */
    private static boolean error(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);

        if ((left % 2 != 1) || (right % 2 != 0)){
            return true;
        } else if (right - left != 1){
            return true;
        } else if (left >= right){
            return true;
        } else if ((left > 399) || (right > 400)){
            return true;
        }
        return false;
    }
    private static int extraction(int page){
        int result;
        int add = 0;
        int mul = 1;
        // 더하기, 곱하기
        while (page != 0){
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }
        result = Math.max(add, mul);
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (error(pobi) || error(crong)){
            return -1;
        }

        int pobiScore = Math.max(extraction(pobi.get(0)), extraction(pobi.get(1)));
        int crongScore = Math.max(extraction(crong.get(0)), extraction(crong.get(1)));

        if (pobiScore > crongScore){
            return 1;
        } else if (pobiScore < crongScore){
            return 2;
        } else if (pobiScore == crongScore){
            return 0;
        }

        return -1;
    }
}