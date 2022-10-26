package onboarding;

import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.List;

class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        if (validateList(pobi) || validateList(crong)) {
            return -1;
        }

        return 0;
    }

    // 예외 발생시 TRUE
    private static boolean validateList(List<Integer> list) {
        // 페이지는 null 값이 들어갈 수 없다.
        if (list.get(0) == null || list.get(1) == null) {
            return true;
        }

        // 첫 페이지는 0 이상 400이하의 값이여야한다.
        if (list.get(0) <= 0 || list.get(0) >= 400){
            return true;
        }
        // 마지막 페이지는 0 이상 400이하의 값이어야한다.
        if (list.get(1) <= 0 || list.get(1) >= 400) {
            return true;
        }

        return list.get(1) - list.get(0) != 1;
    }
}