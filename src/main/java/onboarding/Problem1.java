package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // ----- 포비의 점수 계산 -----
        // 포비의 페이지 합 계산
        int pobiSum = pobi.get(0) + pobi.get(1);
        // 포비의 페이지 곱 계산
        int pobiMul = pobi.get(0) * pobi.get(1);
        // 포비의 점수 계산
        int pobiScore = Math.max(pobiSum, pobiMul);
        return 1;
    }
}