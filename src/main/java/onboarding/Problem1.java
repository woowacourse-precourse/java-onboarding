package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return -1;

        if (pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400) return -1;

        int pobiScore = 0, crongScore = 0;

        for (int i = 0; i < pobi.size(); i++) {
            int pobiPage = pobi.get(i);
            if (pobiPage % 2 == i) return -1;
            pobiScore = Math.max(pobiScore, getScore(pobiPage));
        }

        for (int i = 0; i < crong.size(); i++) {
            int crongPage = crong.get(i);
            if (crongPage % 2 == i) return -1;
            crongScore = Math.max(crongScore, getScore(crongPage));
        }

        if (pobiScore > crongScore)
            return 1;
        else if (pobiScore < crongScore)
            return 2;
        else
            return 0;
    }

    public static int getScore(int page){
        int sum = 0, mul = 1;

        while (page > 0){
            int num = page % 10;
            sum += num;
            mul *= num;
            page /= 10;
        }
        return Math.max(sum,mul);
    }
}