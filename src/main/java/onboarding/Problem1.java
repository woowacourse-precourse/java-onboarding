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

    /**
     * 주어진 입력값들이 문제의 제한사항에 유효한지 확인하는 method
     *
     * @param list 왼쪽, 오른쪽 페이지 번호가 담겨있는 List<Integer> 전달
     * @return 유효성 검증을 모두 통과할시 true, 예외사항 발생시 false return
     */
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

    /**
     * 왼쪽, 오른쪽 페이지 방향을 입력받아 해당 페이지에 적힌 번호의 자리값들의 합 또는 곱 중 더 높은 값을 return
     *
     * @param pageDirection 값이 0이면 left, 1이면 right 페이지를 의미
     * @return 자리수의 합과 곱 중, 더 높은 값을 return 한다. Math.max 사용
     */
    public static int getMaxPageValue(int pageDirection) {
        int sum = 0;
        int multi = 0;
        while (pageDirection != 0) {
            sum += pageDirection % 10;
            if (multi == 0) {
                multi = pageDirection % 10;
            } else {
                multi *= pageDirection % 10;
            }
            pageDirection /= 10;
        }
        return Math.max(sum, multi);
    }

    /**
     * getMaxPageValue Method에 의해 얻은 왼쪽 오른쪽 페이지에 대한 값 중, 게임 참가자의 점수가 될 더 큰 값을 return
     *
     * @param list 점수를 산출하기 위해 List를 전달.
     * @return getMaxPAgeValue Method에 의해 얻어진 각 페이지의 값들 중 더 큰 값을 return
     */
    public static int getScore(List<Integer> list) {
        int leftScore = getMaxPageValue(list.get(0));
        int rightScore = getMaxPageValue(list.get(1));
        return Math.max(leftScore, rightScore);

    }

    /**
     * pobi와 crong이 펼친 책의 정보가 담긴 List를 통해 승자에 따른 값을 결정하는 method
     *
     * @param pobi  pobi가 펼친 책에 관한 정보
     * @param crong crong이 펼친 책에 관한 정보
     * @return 문제의 조건에 맞춰 알맞은 answer를 return
     */
    private static int getAnswer(List<Integer> pobi, List<Integer> crong) {
        int answer;
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

    /**
     * 문제의 조건에 맞춰 결과를 return 하는 method
     *
     * @param pobi  pobi가 펼친 책에 관한 정보를 담고 있는 List
     * @param crong crong가 펼친 책에 관한 정보를 담고 있는 List
     * @return 결과 값이 저장된 answer return
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getAnswer(pobi, crong);
        return answer;
    }
}