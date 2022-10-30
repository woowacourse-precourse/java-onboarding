package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Problem1 {
    public static int compareMax(int currentMax, int candidate) {
        if (candidate > currentMax) {
            currentMax = candidate;
        }
        return currentMax;
    }

    public static int calculateMax(List<Integer> originalPageList, int isRight) {
        List<Integer> pageList = new ArrayList<>(originalPageList);
        Vector<Integer> splitList = new Vector<>();
        while(pageList.get(isRight) > 0) {
            splitList.add(0, pageList.get(isRight) % 10);
            pageList.set(isRight, (pageList.get(isRight) / 10));
        }

        int max = 0;
        for (int digit : splitList) {
            max += digit;
        }
        int multiply = 1;
        for (int digit : splitList) {
            multiply *= digit;
        }
        max = compareMax(max, multiply);
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer, pobiMax, crongMax;
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
            return -1;
        }

        // left page
        pobiMax = calculateMax(pobi, 0);
        crongMax = calculateMax(crong, 0);

        // right page
        int pobiRight = calculateMax(pobi, 1);
        int crongRight = calculateMax(crong, 1);
        pobiMax = compareMax(pobiMax, pobiRight);
        crongMax = compareMax(crongMax, crongRight);

        // compare max
        if (pobiMax == crongMax) {
            answer = 0;
        }
        else if (pobiMax > crongMax) {
            answer = 1;
        }
        else {
            answer = 2;
        }
        return answer;
    }
}