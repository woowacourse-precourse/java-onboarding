package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;

        int pobiScore = 0, crongScore = 0;

        for (int i = 0; i < 2; i++) {
            int pobiPageNumber = pobi.get(i);
            if (pobiPageNumber % 2 == i) return -1;
            pobiScore = Math.max(pobiScore, getMaxScore(pobiPageNumber));

            int crongPageNumber = crong.get(i);
            if (crongPageNumber % 2 == i) return -1;
            crongScore = Math.max(crongScore, getMaxScore(crongPageNumber));
        }

        return pobiScore > crongScore
                ? 1
                : (pobiScore == crongScore) ? 0 : 2;
    }

    public static int getMaxScore(int pageNumber) {
        int sum = 0, mul = 1;

        while (pageNumber > 0) {
            final int num = pageNumber % 10;
            sum += num;
            mul *= num;
            pageNumber /= 10;
        }

        return Math.max(sum, mul);
    }
}