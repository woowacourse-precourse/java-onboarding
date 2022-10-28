package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) return -1;
        int pobiScore = getScore(pobi.get(1));
        int crongScore = getScore(crong.get(1));
        if (pobiScore == crongScore) return 0;
        return (pobiScore < crongScore)? 2 : 1;
    }

    static int getScore(int i) {
        int j = 0, k = 1;
        while (i > 0) {
            int d = i % 10;
            j += d;
            k *= d;
            i /= 10;
        }
        return (j > k)?j : k;
    }

    static boolean isException(List<Integer> pages) {
        return (pages.get(0) + 1 != pages.get(1))? true : false;
    }
}