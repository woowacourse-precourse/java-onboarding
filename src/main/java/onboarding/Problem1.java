package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) + 1 != pobi.get(1) ||
                crong.get(0) + 1 != crong.get(1) ||
                pobi.get(0) % 2 != 1 ||
                crong.get(0) % 2 != 1)
            answer = -1;
        else {
            int pobiMax = 0;
            int crongMax = 0;
            for (int i = 0; i < 2; i++) {
                int pobiPlus = 0;
                int pobiMulti = 1;
                int pobiPage = pobi.get(i);
                while (pobiPage != 0) {
                    pobiPlus += pobiPage % 10;
                    pobiMulti *= pobiPage % 10;
                    pobiPage /= 10;
                }
                pobiMax = Math.max(pobiMax, Math.max(pobiPlus, pobiMulti));

                int crongPlus = 0;
                int crongMulti = 1;
                int crongPage = crong.get(i);
                while (crongPage != 0) {
                    crongPlus += crongPage % 10;
                    crongMulti *= crongPage % 10;
                    crongPage /= 10;
                }
                crongMax = Math.max(crongMax, Math.max(crongPlus, crongMulti));
            }
            if(pobiMax > crongMax) answer = 1;
            else if(pobiMax < crongMax) answer = 2;
            else answer = 0;
        }

        return answer;
    }
}