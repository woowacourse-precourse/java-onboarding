package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            if(pobi.get(i) <= 0 || pobi.get(i) > 400) return -1;
            if(crong.get(i) <= 0 || crong.get(i) > 400) return -1;
        }
        if(pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0) return -1;
        if(crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return -1;
        if(pobi.get(1) - pobi.get(0) != 1) return -1;
        if(crong.get(1) - crong.get(0) != 1) return -1;


        //Pobi
        Integer pobiScore = 0;
        pobiScore = getMaximum(pobiScore, pobi.get(0));
        pobiScore = getMaximum(pobiScore, pobi.get(1));

        //Crong
        int crongScore = 0;
        crongScore = getMaximum(crongScore, crong.get(0));
        crongScore = getMaximum(crongScore, crong.get(1));

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore == crongScore) {
            answer = 0;
        } else {
            answer = 2;
        }
        return answer;
    }

    private static int getMaximum(Integer score, Integer page) {
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            if(page == 0) break;
            int digit = 0;
            digit = page % 10;
            sum += digit;
            mul *= digit;
            page = page / 10;
        }
        int r = sum > mul ? sum : mul;
        return r > score ? r : score;
    }
}