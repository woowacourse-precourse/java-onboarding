package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // ---------- 예외 상황 확인 ----------
        // 각 List에 요소가 2개인지 확인
        if(pobi.size() != 2 || crong.size() != 2) return -1;
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
        // 페이지가 1~400 인지 확인
        if(!isInRange(pobiLeft) || !isInRange(pobiRight) || !isInRange(crongLeft)
                || !isInRange(crongRight)) return -1;
        // 왼쪽 페이지 번호가 홀수인지 확인
        if(pobiLeft % 2 != 1 || crongLeft % 2 != 1) return -1;
        // 오른쪽 페이지가 왼쪽페이지 다음 페이지인지 확인
        if(pobiRight == pobiLeft + 1 && crongRight == crongLeft + 1) return -1;
        // --------------------------------
        return 1;
    }
    // 페이지가 범위 내에 있는지(시작이나 마지막면 제외)
    static boolean isInRange(int value) {
        return value > MIN_PAGE && value < MAX_PAGE;
    }
}