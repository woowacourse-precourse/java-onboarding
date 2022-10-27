package onboarding;

import java.util.List;

/**
 [기능 구현]
 1. 예외 사항
 2. 두 수를 비교하여 답을 내는 메소드
 3. 자릿수 별로 곱하고 더하는 메소드
 **/
class Problem1 {

    // 예외 사항
    // 1. 들어온 숫자가 홀수/짝수가 아닐 때
    // 2. 연속된 숫자가 아닐 때
    private static boolean exception(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return true;
        if ((pobi.get(0) % 2 != 1) || (crong.get(0) % 2 != 1)) return true;
        if (pobi.get(0) == 1 ||  pobi.get(0) == 399 || crong.get(0) == 1 || crong.get(0) == 399) return true;
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}