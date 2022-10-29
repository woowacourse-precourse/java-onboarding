package onboarding;

import java.util.List;

class Problem1 {
    /*
    포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1
     */
    static final int EXCEPTION = -1;
    static final int POBI = 1;
    static final int CRONG = 2;
    static final int DRAW = 0;

    int checkNumberOfDigits(int digits){
        return (int)(Math.log10(digits) + 1);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0) <= 1 || pobi.get(0) >= 400 || pobi.get(1) <= 1 || pobi.get(1) >= 400) {
            return EXCEPTION;
        }
        if(crong.get(0) <= 1 || crong.get(0) >= 400 || crong.get(1) <= 1 || crong.get(1) >= 400) {
            return EXCEPTION;
        }

        if(pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1){
            return EXCEPTION;
        }
        if(pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0){
            return EXCEPTION;
        }

        if(pobi.get(1) - pobi.get(0) != 1){
            return EXCEPTION;
        }
        if(crong.get(1) - crong.get(0) != 1){
            return EXCEPTION;
        }

        return answer;
    }
}