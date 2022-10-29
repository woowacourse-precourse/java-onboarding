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

    static int checkNumberOfDigits(int digits){
        return (int)(Math.log10(digits) + 1);
    }

    static List<Integer> divideDigits(int digits){
        int numberOfDigits = checkNumberOfDigits(digits);
        int units = 0;
        int tens = 0;
        int hundreds = 0;
        int result = 0;
        List<Integer> dividedDigit;

        if(numberOfDigits == 1) {
            units = digits;
            dividedDigit = List.of(units);
        }
        else if(numberOfDigits == 2){
            units = digits % 10;
            tens = digits / 10;
            dividedDigit = List.of(units, tens);
        }
        else {
            units = digits % 10;
            tens = (digits % 100) / 10;
            hundreds = digits / 100;
            dividedDigit = List.of(units, tens, hundreds);
        }

        return dividedDigit;
    }

    static int multiplyDigits(List<Integer> dividedDigit){
        int result = 1;
        for (Integer integer : dividedDigit) {
            result *= integer;
        }
        return result;
    }

    static int addDigits(List<Integer> dividedDigit){
        int result = 0;
        for (Integer integer : dividedDigit) {
            result += integer;
        }
        return result;
    }

    static int findMax(int digits){
        List<Integer> dividedDigit = divideDigits(digits);
        int multiplyResult = multiplyDigits(dividedDigit);
        int addResult = addDigits(dividedDigit);
        int res = Math.max(multiplyResult, addResult);
        return res;
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

        int pobiLeftMax = findMax(pobi.get(0));
        int pobiRightMax = findMax(pobi.get(1));
        int pobiMax = Math.max(pobiLeftMax, pobiRightMax);

        int crongLeftMax = findMax(crong.get(0));
        int crongRightMax = findMax(crong.get(1));
        int crongMax = Math.max(crongLeftMax, crongRightMax);

        if(pobiMax > crongMax) answer = POBI;
        else if(pobiMax < crongMax) answer = CRONG;
        else answer = DRAW;

        return answer;
    }
}