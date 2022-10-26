package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    // 기능요구사항
    // TODO 예외를 처리하는 함수
    static boolean errorCheck(List<Integer> error) {
        if (error.get(0) == null || error.get(1) == null) return true;
        if (!((error.get(0) <=400 && error.get(0) >= 1) || (error.get(1) <=400 && error.get(1) >= 1))) return true;
        if (error.get(1) - error.get(0) != 1) return true;
        return false;
    }

    // TODO 자리수를 구하는 메서드
    // TODO 큰 값을 리턴하는 메서드

    // TODO pobi와 crong의 값을 비교하는 메서드
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (errorCheck(pobi) || errorCheck(crong)) return -1;
        int pobiScore;
        int crongScore;
        return 1;
    }
}