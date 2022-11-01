package onboarding;

import java.util.List;

/** 포비와 크롱의 한판 승부 */
class Problem1 {
    /** 기능구현
     * 1. 포비, 크롱의 페이지를 통해 각각 최댓값 계산 (getMaxScore)
     * 2. 포비, 크롱의 최댓값 비교 후 승자 계산 (getResult)
     * 3. 예외 처리 (checkValid)
     */
    static final int PAGE_MIN = 3;  // 시작 면+1 페이지
    static final int PAGE_MAX = 398;  // 마지막 면-1 페이지
    static final int CASE_POBI_WIN = 1;  // 포비 승
    static final int CASE_CRONG_WIN = 2;  // 크롱 승
    static final int CASE_DRAW = 0;  // 무승부
    static final int ERROR = -1;  // 예외사항

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax, crongMax;   // pobi,crong의 최댓값
        int answer = Integer.MAX_VALUE; // 결과값

        if (checkValid(pobi) && checkValid(crong)) {  // 오류 예외처리
            pobiMax = Math.max( getMaxScore(pobi.get(0)), getMaxScore(pobi.get(1)) );
            crongMax = Math.max(getMaxScore(crong.get(0)), getMaxScore(crong.get(1)));
            answer = getResult(pobiMax, crongMax);
            return answer;
        }
        return ERROR;
    }

    public static boolean checkValid(List<Integer> who){
        int startPage = who.get(0);

        if ((PAGE_MIN <= startPage && startPage <= PAGE_MAX) && (startPage % 2 == 1)){
            return true;
        }
        return false;
    }

    public static int getMaxScore(int page){
        int sum = 0;    // 두 페이지의 합
        int mult = 1;   // 두 페이지의 곱

        int pageL, pageR = 0;

        while(page > 0){
            int num1 = page % 10;  // 페이지 뒷자리 숫자
            mult *= num1;
            sum += num1;
            page /= 10; // 페이지 앞자리 숫자
        }
        return Math.max(mult, sum);
    }

    public static int getResult(int pobiMax, int crongMax){
        int result = crongMax - crongMax;
        if(result > 0){
            return CASE_CRONG_WIN;
        }
        else if(result < 0){
            return CASE_POBI_WIN;
        }
        else
            return CASE_DRAW;
    }


}

