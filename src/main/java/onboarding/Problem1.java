package onboarding;

import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.max;

/*
- 기능 구현사항 목록-
1. 각 페이지 번호를 받아서 각 자리 숫자를 더하고, 곱한 숫자중 최댓값을 리턴 하는 함수 선언
2. 예외처리 사항 return -1
3. 1번 단계에서 얻은 값을 비교해 result 출
 */
class Problem1 {
    private static final int INIT_ERROR = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static boolean exception(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1) - pobi.get(0) != 1) return false;
        if(crong.get(1) - crong.get(0) != 1) return false;
        if(pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) return false;
        if(pobi.contains(FIRST_PAGE) || pobi.contains(LAST_PAGE)) return false;
        if(crong.contains(FIRST_PAGE) || crong.contains(LAST_PAGE)) return false;
        return true;
    }
    private static int findMax(int s) {
        int pageSum = 0;
        int pageMulti = 1;
        int[] digits = IntegerToList(s);
        for (int unit : digits) {
            pageSum = pageSum + unit;
            pageMulti = pageMulti * unit;
        }
        return Math.max(pageMulti, pageSum);
    }
    private static int[] IntegerToList(int n){
        String temp = Integer.toString(n);
        int l = temp.length();
        int[] pageDigits = new int[l];
        for (int i = 0; i < l; i++) pageDigits[i] = temp.charAt(i) - '0';
        return pageDigits;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!exception(pobi, crong)) return INIT_ERROR;
        // 각자 점수 산출
        List<Integer> pobiScore = new ArrayList<>(2);
        List<Integer> crongScore = new ArrayList<>(2);
        for (int i = 0; i < 2; i++){
            pobiScore.add(findMax(pobi.get(i)));
            crongScore.add(findMax(crong.get(i)));
        }
        int pobiMax = max(pobiScore);
        int crongMax = max(crongScore);
        // 비교
        if(pobiMax == crongMax){
            return DRAW;
        }
        else if(pobiMax > crongMax){
            return POBI_WIN;
        }
        return CRONG_WIN;
    }
}