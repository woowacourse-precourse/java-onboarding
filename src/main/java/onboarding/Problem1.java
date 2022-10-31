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
            //예외처리 들어갈 곳
        }
        return true;
    }
}