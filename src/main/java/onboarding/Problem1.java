package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    boolean check(List<Integer> list) {
        //왼쪽 페이지 번호가 홀수 인지 확인
        if(list.get(0)%2 == 0) return false;

        //숫자가 연속적인지 확인
        return (list.get(1) - list.get(0) == 1);
    }
}