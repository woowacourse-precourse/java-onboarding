package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiScore = new ArrayList<>();
        List<Integer> crongScore = new ArrayList<>();

        for (int i = 0; i < pobi.size(); i++) {
            int pobiPage = pobi.get(i);
            int pobiPageSum = 0;
            while (pobiPage != 0) {
                pobiPageSum += pobiPage%10;
                pobiPage = pobiPage/10;
            }
            pobiScore.add(pobiPageSum);
        }

        for (int i = 0; i < pobi.size(); i++) {
            int pobiPage = pobi.get(i);
            int pobiPageMul = 1;
            while (pobiPage != 0) {
                pobiPageMul *= pobiPage%10;
                pobiPage = pobiPage/10;
            }
            pobiScore.add(pobiPageMul);
        }

        for (int i = 0; i < crong.size(); i++) {
            int crongPage = crong.get(i);
            int crongPageSum = 0;
            while (crongPage != 0) {
                crongPageSum += crongPage%10;
                crongPage = crongPage/10;
            }
            pobiScore.add(crongPageSum);
        }
















        return answer;
    }
}