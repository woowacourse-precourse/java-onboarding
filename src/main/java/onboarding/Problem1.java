package onboarding;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isWrongInput(pobi, crong)) {
            return EXCEPTION;
        }

        return answer;
    }

    // 입력된 페이지들이 조건에 맞는지 확인
    public static boolean isWrongInput(List<Integer> pobi, List<Integer> crong) {
        if (isFirstOrLast(pobi, crong) || isNotConsecutive(pobi, crong)) {
            return true;
        }
        return false;
    }

    // 연속된 페이지가 아닌경우
    public static boolean isNotConsecutive(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return true;
        }
        return false;
    }

    // 시작면 or 마지막면이 나오는 경우
    public static boolean isFirstOrLast(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            return true;
        }
        return false;
    }
}