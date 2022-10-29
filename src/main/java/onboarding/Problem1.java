package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW =0;
    private static final int EXCEPT = -1;
    private static final boolean ACCEPT_PAGE = true;
    private static final boolean EXCEPT_PAGE = false;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 둘 중 한명이라도 책의 페이지가 연속적이지 않으면 예외사항 반환
        if(!check(pobi)||!check(crong))return EXCEPT;

        int pobiMax = calculateMax(pobi);
        int crongMax = calculateMax(crong);
        if(pobiMax > crongMax) return POBI_WIN;
        if(pobiMax < crongMax) return CRONG_WIN;
        if(pobiMax == crongMax) return DRAW;
        return -100;
    }

    /**
     * 핀 책의 왼쪽, 오른쪽 페이지의 연속적 여부 반환
     * @return
     */
    private static boolean check(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        if(right-left != 1)return EXCEPT_PAGE;
        if(right == FIRST_PAGE && left == LAST_PAGE)return EXCEPT_PAGE;
        return ACCEPT_PAGE;
    }

    /**
     * 한 사람의 최대 페이지 값 반환
     * @return max
     */
    private static int calculateMax(List<Integer> list) {
        int left= list.get(0);
        int right= list.get(1);
        int sumMax= Math.max(numSum(left),numSum(right));
        int multiMax = Math.max(numMulti(left),numMulti(right));
        int max = Math.max(sumMax, multiMax);
        return max;
    }
    /**
     * 각 자릿수의 합 반환
     * @return sum
     */
    private static int numSum(int i){
        int sum = 0;
        while(i>0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
    /**
     * 각 자릿수의 곱 반환
     * @return multi
     */
    private static int numMulti(int i){
        int multi = 1;
        while(i>0){
            multi*=i%10;
            i=i/10;
        }
        return multi;
    }
}