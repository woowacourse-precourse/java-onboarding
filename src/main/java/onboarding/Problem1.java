package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * numScore                 : 각 자리 숫자의 합과 곱 중 큰 값 반환
 * maxResult                : 사용자의 가장 큰 값 반환
 * numToDigits              : 숫자를 각 자리의 수의 배열로 반환
 * checkValid               : 예외 상황 체크
 * checkListLengthValid     : 페이지 리스트의 길이 체크
 * checkPageValid           : 페이지 값 유효성 체크
 */

class Problem1 {

    private static final int POBI = 1;
    private static final int CROMG = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkValid(pobi, crong)) {
            return EXCEPTION;
        }
        int pobiValue = maxResult(pobi);
        int crongValue = maxResult(crong);
        if (pobiValue > crongValue) {
            return POBI;
        }
        if (pobiValue < crongValue) {
            return CROMG;
        }
        return DRAW;
    }

    private static int numScore(int num) {
        int sum = 0;
        int mulit = 1;
        List<Integer> digits = numToDigits(num);
        for (int digit : digits) {
            sum += digit;
            mulit *= digit;
        }
        return Math.max(sum, mulit);
    }

    private static int maxResult(List<Integer> user){
        int leftNum = user.get(0);
        int rightNum = user.get(1);
        return Math.max(numScore(leftNum), numScore(rightNum));
    }

    private static List<Integer> numToDigits(int num){
        List<Integer> output = new ArrayList<>();
        while (num != 0) {
            output.add(num % 10);
            num = num/10;
        }
        return output;
    }

    private static boolean checkValid(List<Integer> userA, List<Integer> userB) {
        boolean validA = checkListLengthValid(userA) && checkPageValid(userA);
        boolean validB = checkListLengthValid(userB) && checkPageValid(userB);
        return validA && validB;
    }

    private static boolean checkListLengthValid(List<Integer> user) {
        return user.size() == 2;
    }

    private static boolean checkPageValid(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        if (leftPage + 1 != rightPage) {
            return false;
        }
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return false;
        }
        return 1 <= leftPage && leftPage <= 400 && 1 <= rightPage && rightPage <= 400;
    }
}
