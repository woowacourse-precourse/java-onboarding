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