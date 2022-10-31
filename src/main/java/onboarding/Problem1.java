package onboarding;

import java.util.List;

class Problem1 {
    // 전체 기능 호출
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkValidPage(pobi, crong)) {
            return 0;
        }
        return -1;
    }

    // 예외처리 기능
    @SafeVarargs
    private static boolean checkValidPage(List<Integer>...list) {
        for (int i = 0; i < list.length; i++) {
            if (isNotConsecutiveNumber(list[i])) return false;
        }
        return true;
    }
    // 두 페이지가 연속된 숫자인지 판별하는 기능
    private static boolean isNotConsecutiveNumber(List<Integer> list) {
        return list.get(1) - list.get(0) != 1;
    }
}