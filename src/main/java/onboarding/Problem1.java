package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidList(pobi) || !isValidList(crong)) {
            return -1;
        }

        return answer;
    }

    // 예외 처리 함수
    static boolean isValidList(List<Integer> pageList) {
        if (pageList.size() != 2 || pageList.get(0) % 2 == 0 || pageList.get(1) - pageList.get(0) != 1) {
            return false;
        }
        // 시작 면이나 마지막 면이 나오면 안됨
        if (pageList.get(0) == 0 || pageList.get(1) == 400) {
            return false;
        }

        return true;
    }

    static int getPlus(int elem) {
        int score = 0;

        while (elem > 0) {
            score += elem % 10;
            elem /= 10;
        }

        return score;
    }

}