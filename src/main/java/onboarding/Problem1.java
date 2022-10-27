package onboarding;

import java.util.*;

class Problem1 {

    static final int LEFT_INDEX_IN_LIST = 0;
    static final int RIGHT_INDEX_IN_LIST = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 결과로 -1 예외사항이 생길 수 있는지 체크하는 메서드
     */
    public static boolean isImpossiblePages(List<Integer> pages) {
        if (pages.get(RIGHT_INDEX_IN_LIST) - pages.get(LEFT_INDEX_IN_LIST) == 1) {
            return false;
        }
        return true;
    }

    /**
     * int 자료형을 String 자료형으로 변환
     */
    private static String convertIntToString(int number) {
        return String.valueOf(number);
    }

}