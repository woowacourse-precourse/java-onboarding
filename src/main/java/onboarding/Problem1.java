package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 양쪽 페이지 중 더 큰 수를 본인의 점수로 저장
        int pobiMax = Math.max(getCalMax(pobi.get(0)), getCalMax(pobi.get(1)));
        int crongMax = Math.max(getCalMax(crong.get(0)), getCalMax(crong.get(1)));

        return getResult(pobiMax, crongMax);
    }

    public static int getCalMax(int page) {
        int sum = 0;
        int muti = 1;

        while (page > 0) {
            sum += (page % 10);
            muti *= (page % 10);
            page /= 10;
        }

        return Math.max(sum, muti);
    }

    public static int getResult(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) return 1;
        else if (pobiMax < crongMax) return 2;
        return 0;
    }
}