package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 에러 체크
        if (isError(pobi) || isError(crong)) {
            return -1;
        }

        return answer;
    }


    private static boolean isError(List<Integer> pages) {
        if (pages.size() != 2) {
            return true;
        }
        // 페이지 값
        Integer left = pages.get(0);
        Integer right = pages.get(1);

        // 왼쪽 | 오른쪽 페이지 번호 차이가 1이 아닐 때 , 왼쪽이 홀수가 아닐 때 , 오른쪽이 짝수가 아닐 때
        if(Math.abs(left - right) != 1 || left % 2 != 1 || right % 2 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(89, 11);
        List<Integer> crong = List.of(211, 212);

        solution(pobi, crong);
    }
}