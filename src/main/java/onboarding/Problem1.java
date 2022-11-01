package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 사항에 대한 함수 except()
        // 최대값을 구하는 함수 maxNumber()

        if (! except(pobi) || ! except(crong)) return -1;

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean except(List<Integer> list) {

        return list.get(0).equals(list.get(1) - 1);
    }
}