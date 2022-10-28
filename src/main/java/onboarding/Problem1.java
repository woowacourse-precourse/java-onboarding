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
 * @version         1.00 2022년 10월 27일
 * @author          이준현
 */
class Problem1 {

    public static boolean validCheck(List<Integer> list){
        if(list.size() != 2){
            return false;
        }
        for(int el : list){
            if(el <= 1 || 400 <= el){
                return false;
            }
        }
        if(list.get(0) % 2 != 1 && list.get(1) % 2 != 0){
            return false;
        }

        if(list.get(1) - list.get(0) != 1){
            return false;
        }

        return true;
    };

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}