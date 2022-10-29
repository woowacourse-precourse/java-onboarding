package onboarding;

import java.util.List;

class Problem1 {
    private static final int PAGE_MIN = 1, PAGE_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkValid(pobi);
            checkValid(crong);

            int pScore = maxScore(pobi);
            int cScore = maxScore(crong);

            if (pScore > cScore)
                return 1;
            else if (pScore < cScore)
                return 2;
            return 0;
        } catch(Exception e) {
            return -1;
        }
    }

    private static void checkValid(List<Integer> pages) throws Exception {
        // check error
        // must be [odd, odd+1]
        if(pages.size() != 2)
            throw new Exception("wrong pages size");
        else if(pages.get(0) + 1 != pages.get(1))
            throw new Exception("not continuous pages");
        else if(pages.get(0) < PAGE_MIN || pages.get(1) > PAGE_MAX)
            throw new Exception("page out of bound");
        else if(pages.get(0) % 2 == 0)
            throw new Exception("wrong page format");
    }

    private static int maxScore(List<Integer> pages) {
        int maxSco = 0;

        for(Integer page : pages)
            maxSco = Math.max(maxSco, pageScore(page));

        return maxSco;
    }

    private static int pageScore(Integer page) {
        int add = 0, mul = 1;

        while(page > 0) {
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        return Math.max(add, mul);
    }
}