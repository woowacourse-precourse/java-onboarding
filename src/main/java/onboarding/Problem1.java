package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (hasNoError(pobi) && hasNoError(crong)) {
            int pobiSumMax = Math.max(sum(splitNum(pobi.get(0))), sum(splitNum(pobi.get(1))));
            int pobiMulMax = Math.max(mul(splitNum(pobi.get(0))), mul(splitNum(pobi.get(1))));
            int crongSumMax = Math.max(sum(splitNum(crong.get(0))), sum(splitNum(crong.get(1))));
            int crongMulMax = Math.max(mul(splitNum(crong.get(0))), mul(splitNum(crong.get(1))));
            int pobiMax = Math.max(pobiSumMax, pobiMulMax);
            int crongMax = Math.max(crongSumMax, crongMulMax);

            if (pobiMax > crongMax) {
                answer = 1;
            } else if (pobiMax == crongMax){
                answer = 0;
            } else {
                answer = 2;
            }
        } else {
            answer = -1;
        }
        return answer;
    }

    static List<Integer> splitNum(int num) {
        List<Integer> answerList = new ArrayList<>();
        while (num > 0) {
            answerList.add(num % 10);
            num = num / 10;
        }
        return answerList;
    }

    static int sum(List<Integer> numList) {
        int sumVal = 0;
        for (int num : numList) {
            sumVal += num;
        }
        return sumVal;
    }

    static int mul(List<Integer> numList) {
        int mulVal = 1;
        for (int num : numList) {
            mulVal *= num;
        }
        return mulVal;
    }


    // 1~400 안에 있는지 확인하는 메서드
    static boolean isInRange(List<Integer> page) {
        if (page.get(0) >= 1 && page.get(0) <= 400 && page.get(1) >= 1 && page.get(1) <= 400) {
            return true;
        } else {
            return false;
        }
    }

    // 연속된 페이지인지 확인하는 메서드
    static boolean hasContinuousPages(List<Integer> page) {
        if (page.get(1) - page.get(0) == 1) {
            return true;
        } else {
            return false;
        }
    }

    // page[0]이 홀수고 page[1]이 짝수인지 확인하는 메서드
    static boolean judgeLeftIsOddAndRightIsEven(List<Integer> page) {
        if (page.get(0) % 2 == 1 && page.get(1) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 원소가 2개인지 확인하는 메서드
    static boolean hasTwoPages(List<Integer> page) {
        if (page.size() == 2) {
            return true;
        } else {
            return false;
        }
    }

    // 4가지 예외가 모두 맞는지 확인하는 메서드
    static boolean hasNoError(List<Integer> page) {
        if (isInRange(page) && hasContinuousPages(page) && judgeLeftIsOddAndRightIsEven(page) && hasTwoPages(page)) {
            return true;
        } else {
            return false;
        }
    }

}

