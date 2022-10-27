package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftNum = pobi.get(0);
        int pobiRightNum = pobi.get(1);
        int pobiNumSum = 0;
        int crongLeftNum = crong.get(0);
        int crongRightNum = crong.get(1);

        List <Integer> pobiLeftArray = new ArrayList();
        List <Integer> pobiRightArray = new ArrayList();
        List <Integer> crongLeftArray = new ArrayList<>();
        List <Integer> crongRightArray = new ArrayList<>();

        for (int i = 0; pobiLeftNum > 0; i ++) {
            pobiLeftArray.add(pobiLeftNum % 10);
            pobiLeftNum /= 10;
        }

        for (int i = 0; pobiRightNum > 0; i ++) {
            pobiRightArray.add(pobiRightNum % 10);
            pobiRightNum /= 10;
        }

        for (int i = 0; crongLeftNum > 0; i ++) {
            crongLeftArray.add(crongLeftNum % 10);
            crongLeftNum /= 10;
        }

        for (int i = 0; crongRightNum > 0; i ++) {
            crongRightArray.add(crongRightNum % 10);
            crongRightNum /= 10;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}