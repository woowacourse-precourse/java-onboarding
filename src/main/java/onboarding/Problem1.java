package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiScore = new ArrayList<>();

        for (int i = 0; i < pobi.size(); i++) {
            int pobiPage = pobi.get(i);
            int pobiPageSum = 0;
            while (pobiPage != 0) {
                pobiPageSum += pobiPage%10;
                pobiPage = pobiPage/10;
            }
            pobiScore.add(pobiPageSum);
        }














        return answer;
    }
}