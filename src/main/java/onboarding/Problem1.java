/*
 * Problem1.java
 *
 * 2022-10-27
 *
 */
package onboarding;

import java.util.List;

/**
 * 우아한 테크코스 - 프리코스 1주차 페이지 번호 게임
 *
 * @author 이준현
 * @version 1.00 2022년 10월 27일
 */
class Problem1 {

    public static boolean validCheck(List<Integer> list) {
        if (list.size() != 2) {
            return false;
        }
        for (int el : list) {
            if (el <= 1 || 400 <= el) {
                return false;
            }
        }
        if (list.get(0) % 2 != 1 && list.get(1) % 2 != 0) {
            return false;
        }
        if (list.get(1) - list.get(0) != 1) {
            return false;
        }
        return true;
    }


    public static int getMaxPageValue(int pageNum) {
        int sum = 0;
        int multi = 0;
        while (pageNum != 0) {
            sum += pageNum % 10;
            if (multi == 0) {
                multi = pageNum % 10;
            } else {
                multi *= pageNum % 10;
            }
            pageNum /= 10;
        }
        return Math.max(sum, multi);
    }


    public static int getScore(List<Integer> list) {
        int leftScore = getMaxPageValue(list.get(0));
        int rightScore = getMaxPageValue(list.get(1));
        return Math.max(leftScore, rightScore);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (!validCheck(pobi) || !validCheck(crong)) {
            answer = -1;
            return answer;
        }
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}