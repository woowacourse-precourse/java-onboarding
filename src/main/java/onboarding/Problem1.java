package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        // ----- 포비의 점수 계산 -----
        // 포비의 페이지 합 계산
        int pobiSum = pobiLeft + pobiRight;
        // 포비의 페이지 곱 계산
        int pobiMul = pobiLeft * pobiRight;
        // 포비의 점수 계산
        int pobiScore = Math.max(pobiSum, pobiMul);

        // ----- 크롱의 점수 계산 -----
        // 크롱의 페이지 합 계산
        int crongSum = crongLeft + crongRight;
        // 크롱의 페이지 곱 계산
        int crongMul = crongLeft * crongRight;
        // 크롱의 점수 계산
        int crongScore = Math.max(crongSum, crongMul);

        return 2;
    }
}