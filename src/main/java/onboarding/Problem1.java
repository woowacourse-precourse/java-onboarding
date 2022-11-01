package onboarding;

import java.util.List;

import static java.lang.Integer.max;

class Problem1 {

    public static int calculateScore(int page){
        int multi = 1;
        int add = 0;

        int divider = 10;
        while(page != 0){
            int tmp = page % divider;
            multi *= tmp;
            add += tmp;
            page /= divider;
        }

        return max(multi, add);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = max(calculateScore(pobi.get(0)), calculateScore(pobi.get(1)));
        int crongScore = max(calculateScore(crong.get(0)), calculateScore(crong.get(1)));

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else{
            return 0;
        }
    }
}