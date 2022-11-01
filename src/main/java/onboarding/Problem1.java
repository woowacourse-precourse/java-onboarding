package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        int pobiScore = Math.max(getScore(pobiLeft), getScore(pobiRight));
        int crongScore = Math.max(getScore(crongLeft), getScore(crongRight));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int getScore(int page) {

        int summationScore = 0;
        int multiplicationScore = 1;

        while (page > 0) {
            int digit = page % 10;
            summationScore += digit;
            multiplicationScore *= digit;
            page /= 10;
        }
        return  Math.max(summationScore, multiplicationScore);
    }



}