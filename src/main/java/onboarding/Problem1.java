/*
* 우테코 1주차 프리코스 미션 - 문제 1
* [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM1.md]
*
* */
package onboarding;

import java.util.List;

/**
 * checkPage : 전달받은 페이지 번호의 예외사항 확인하는 메서드
 **/

class Problem1 {
    public static int checkPage (List<Integer> pages){
        if(pages.get(1) - pages.get(0) != 1) {
            return -1;          // 연속된 숫자가 아닐 경우 예외
        }else if (pages.get(0) < 0 || pages.get(0) > 400) {
            return -1;          // 왼쪽 페이지 기준, 책의 범위를 벗어날 경우 예외
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}