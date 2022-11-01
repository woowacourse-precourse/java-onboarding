package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiScore = new ArrayList<>();
        List<Integer> crongScore = new ArrayList<>();
        int pobiScoreFinal = 0;
        int crongScoreFinal = 0;

        if(pobi.get(0)%2 == 0) return -1;
        if(pobi.get(1)%2 == 1) return -1;
        if(pobi.get(1) - pobi.get(0) != 1) return -1;
        if(crong.get(0)%2 == 0) return -1;
        if(crong.get(1)%2 == 1) return -1;
        if(crong.get(1) - crong.get(0) != 1) return -1;

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
            crongScore.add(crongPageSum);
        }

        for (int i = 0; i < crong.size(); i++) {
            int crongPage = crong.get(i);
            int crongPageMul = 1;
            while (crongPage != 0) {
                crongPageMul *= crongPage%10;
                crongPage = crongPage/10;
            }
            crongScore.add(crongPageMul);
        }

        for (int i = 0; i < pobiScore.size(); i++) {
            if (pobiScoreFinal < pobiScore.get(i)) pobiScoreFinal = pobiScore.get(i);
        }

        for (int i = 0; i < crongScore.size(); i++) {
            if (crongScoreFinal < crongScore.get(i)) crongScoreFinal = crongScore.get(i);
        }

        if (pobiScoreFinal > crongScoreFinal) answer = 1;
        if (pobiScoreFinal == crongScoreFinal) answer = 0;
        if (pobiScoreFinal < crongScoreFinal) answer = 2;

        return answer;
    }
}