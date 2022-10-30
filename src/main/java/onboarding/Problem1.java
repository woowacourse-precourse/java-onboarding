package onboarding;

import java.util.List;

class Problem1 {
    private static final int PAGE_MIN = 1, PAGE_MAX = 400;
    private enum GameResult {
        ERROR(-1), DRAW(0), POBI_WIN(1), CRONG_WIN(2);

        private final int value;
        GameResult(int value) { this.value = value; }
        public int getValue() { return this.value; }
    };

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkValid(pobi);
            checkValid(crong);

            int pScore = maxScore(pobi);
            int cScore = maxScore(crong);

            if (pScore > cScore)
                return GameResult.POBI_WIN.getValue();
            else if (pScore < cScore)
                return GameResult.CRONG_WIN.getValue();
            return GameResult.DRAW.getValue();
        } catch(Exception e) {
            return GameResult.ERROR.getValue();
        }
    }

    private static void checkValid(List<Integer> pages) throws Exception {
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