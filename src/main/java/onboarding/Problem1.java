package onboarding;

import onboarding.problem1.Game;

import java.util.List;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
class Problem1 {
    /*
     * Problem 1의 메인 메소드
     * @param pobi pobi이 펼친 양쪽 페이지의 정보가 담긴 배열
     * @param crong crong이 펼친 양쪽 페이지의 정보가 담긴 배열
     * @return 1,2,-1의 상태값이 리턴
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isRight(pobi)) return -1;
        if(!isRight(crong)) return -1;
        int resultPobi = new Game(pobi.get(0), pobi.get(1)).getResult();
        int resultCrong = new Game(crong.get(0), crong.get(1)).getResult();
        if(resultCrong == resultPobi) return 0;
        return (resultPobi > resultCrong)? 1 : 2;
    }
    /*
     * 양쪽 페이지의 값이 유효한지 검사하는 메소드
     * @param list 양쪽 페이지 정보가 담긴 배열
     * @return 맞는지 여부
     */
    private static boolean isRight(List<Integer> list) {
        return isRightPage(list) && isNotFirstOrLastPage(list);
    }
    /*
     * 페이지의 범위가 검사되는 메소드
     * @param list 양쪽 페이지 정보가 담긴 배열
     * @return 맞는지 여부
     */
    private static boolean isNotFirstOrLastPage(List<Integer> list) {
        boolean cond1 = (list.get(0) >0 && list.get(0) < 400);
        boolean cond2 = (list.get(1) >0 && list.get(1) < 400);
        return cond1 && cond2;
    }
    /*
     * 페이지가 홀수 - 짝수 순인지, '1' 차이나는지 검사하는 메소드
     * @param list 양쪽 페이지 정보가 담긴 배열
     * @return 맞는지 여부
     */
    private static boolean isRightPage(List<Integer> list) {
        if(list.get(0) > list.get(1)) return false;
        if(list.get(0) != list.get(1) -1) return false;
        boolean cond1 = (list.get(0)%2 == 1);
        boolean cond2 = (list.get(1)%2 == 0);
        return cond1 && cond2;
    }
}