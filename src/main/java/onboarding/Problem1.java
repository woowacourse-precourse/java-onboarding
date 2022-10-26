package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!isLeftOdd(pobi, crong) || !isSuccessive(pobi, crong) || isRange(pobi, crong)) {
            return -1;
        }

        return answer;
    }

    private static boolean isLeftOdd(List<Integer> pobi, List<Integer> crong) { // 왼쪽 값이 홀수인가 ?
        return (pobi.get(0) % 2 == 1) && (crong.get(0) % 2 == 1); // 참이면 조건 만족
    }

    private static boolean isSuccessive(List<Integer> pobi, List<Integer> crong) { // 연속적이지 않음
        return (pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1)); // 참이면 조건 만족
    }

    private static boolean isRange(List<Integer> pobi, List<Integer> crong) { // 1~400 을 벗어남
        return pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400; // 거짓이면 조건 만족
    }

}