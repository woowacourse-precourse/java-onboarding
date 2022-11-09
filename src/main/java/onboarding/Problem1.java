package onboarding;

import java.util.List;

class Problem1 {
    public static int getMax(int page) {
        int pobiSum = 0;
        int pobiMulti = 1;
        while (page > 0) {
            pobiSum += page % 10;
            pobiMulti *= page % 10;
            page = page / 10;
        }
        if (pobiSum >= pobiMulti) {
            return pobiSum;
        } else {
            return pobiMulti;
        }
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            answer = -1;
            return answer;
        }

        int pobimax = 0;
        if (getMax(pobi.get(0)) >= getMax(pobi.get(1))) {
            pobimax = getMax(pobi.get(0));
        } else {
            pobimax = getMax(pobi.get(1));
        }

        int crongmax = 0;
        if (getMax(crong.get(0)) >= getMax(crong.get(1))) {
            crongmax = getMax(crong.get(0));
        } else {
            crongmax = getMax(crong.get(1));
        }

        if (pobimax > crongmax) {
            answer = 1;
        } else if (pobimax < crongmax) {
            answer = 2;
        } else if (pobimax == crongmax) {
            answer = 0;
        }

        return answer;
    }
}