package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * numSum                   : 각 자리 숫자 합 반환
 * numMulti                 : 각 자리 숫자 곱 반환
 * maxResult                : 사용자의 가장 큰 값 반환
 * compareSumMulti          : 곱과 합 중 가장 큰 값 반환
 * numToDigits              : 숫자를 각 자리의 수의 배열로 반환
 * checkValid               : 예외 상황 체크
 * checkListLengthValid     : 페이지 리스트의 길이 체크
 * checkPageValid           : 페이지 값 유효성 체크
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!checkValid(pobi, crong)) {
            answer = -1;
            return answer;
        }

        int pobiValue = maxResult(pobi);
        int crongValue = maxResult(crong);
        if (pobiValue == crongValue) {
            answer = 0;
        } else if (pobiValue > crongValue) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }

    public static int numSum(int num) {
        int sum = 0;
        List<Integer> digits = numToDigits(num);
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int numMulti(int num) {
        int multi = 1;
        List<Integer> digits = numToDigits(num);
        for (int digit : digits) {
            multi *= digit;
        }
        return multi;
    }

    public static int maxResult(List<Integer> user){
        int leftSumOutput = numSum(user.get(0));
        int leftMultiOutput = numMulti(user.get(0));
        int rightSumOutput = numSum(user.get(1));
        int rightMultiOutput = numMulti(user.get(1));

        int leftMax = compareSumMulti(leftSumOutput, leftMultiOutput);
        int rightMax = compareSumMulti(rightSumOutput, rightMultiOutput);

        return Math.max(leftMax, rightMax);
    }

    public static int compareSumMulti(int sum, int multi) {
        return Math.max(sum, multi);
    }

    public static List<Integer> numToDigits(int num){
        List<Integer> output = new ArrayList<>();
        while (num != 0) {
            output.add(num % 10);
            num = num/10;
        }
        return output;
    }

    public static boolean checkValid(List<Integer> userA, List<Integer> userB) { // 각 배열의 길이, 페이지 번호 확인
        boolean validA = checkListLengthValid(userA) && checkPageValid(userA);
        boolean validB = checkListLengthValid(userB) && checkPageValid(userB);
        return validA && validB;
    }

    public static boolean checkListLengthValid(List<Integer> user) {
        if (user.size() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPageValid(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        if (leftPage + 1 != rightPage) {
            return false;
        }
        if (leftPage % 2 == 0 || rightPage %2 == 1) {
            return false;
        }
        return true;
    }

}