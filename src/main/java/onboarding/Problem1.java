package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private final static int FIRST_PAGE = 1;
    private final static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiList = new ArrayList<>();
        List<Integer> crongList = new ArrayList<>();
        int pobiMax = 0;
        int crongMax = 0;

        checkPageRange(pobi, crong);
        if (checkValidatePageNumber(pobi, crong)) {
            return -1;
        }

        for(int i = 0; i < 2; i++) {
            separateNumber(pobi.get(i), pobiList);
            separateNumber(crong.get(i), crongList);
            pobiMax = findMaxNum(pobiList, pobiMax);
            crongMax = findMaxNum(crongList, crongMax);
        }

        answer = findAnswer(pobiMax, crongMax);

        return answer;
    }

    public static boolean checkValidatePageNumber(List<Integer> pobi, List<Integer> crong) {
        int pobiOdd = pobi.get(0);
        int pobiEven = pobi.get(1);
        int crongOdd = crong.get(0);
        int crongEven = crong.get(1);

        if (isRightSequenceOfPageNumber(pobiOdd, pobiEven, crongOdd, crongEven) || isNotFirstOrLastPage(pobiOdd, pobiEven, crongOdd, crongEven)) {
            return true;
        }
        return false;
    }

    private static boolean isRightSequenceOfPageNumber(int pobiOdd, int pobiEven, int crongOdd, int crongEven) {
        if (pobiOdd + 1 != pobiEven || crongOdd + 1 != crongEven) {
            return true;
        }
        return false;
    }

    private static boolean isNotFirstOrLastPage(int pobiOdd, int pobiEven, int crongOdd, int crongEven) {
        if(pobiOdd == FIRST_PAGE || crongOdd == FIRST_PAGE || pobiEven == LAST_PAGE || crongEven == LAST_PAGE) {
            return true;
        }
        return false;
    }

    private static void checkPageRange(List<Integer> pobi, List<Integer> crong) {
        for(int i = 0; i < 2; i++) {
            if(pobi.get(i) < FIRST_PAGE || pobi.get(i) > LAST_PAGE || crong.get(i) < FIRST_PAGE || crong.get(i) > LAST_PAGE) {
                throw new RuntimeException("페이지의 범위에서 벗어났습니다.");
            }
        }
    }

    private static void separateNumber(int num, List<Integer> list) {
        int onesPlace = num % 10;
        list.add(onesPlace);
        num -= onesPlace;
        if(num == 0) {
            return;
        }

        int tensPlace = (num % 100) / 10;
        list.add(tensPlace);
        num -= tensPlace * 10;
        if(num == 0) {
            return;
        }

        int hundredsPlace = num / 100;
        list.add(hundredsPlace);

    }

    public static int findMaxNum(List<Integer> list, int max) {
        int plus = 0;
        int multi = 1;
        int result;

        for(int i = 0; i < list.size(); i++) {
            plus += list.get(i);
            multi *= list.get(i);
        }
        result = Math.max(plus, multi);
        result = Math.max(result, max);

        return result;
    }

    private static int findAnswer(int pobiMax, int crongMax) {
        int answer;
        if(pobiMax > crongMax) {
            answer = 1;
        }else if(pobiMax < crongMax) {
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;
    }

}