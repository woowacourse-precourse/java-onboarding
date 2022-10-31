package onboarding;

import java.util.List;
import java.util.Map;

/* 기능 목록
 *
 * checkValid : 페이지 리스트가 유효한지 확인하고 Exception 처리를 한다.
 * maxScore : 페이지 리스트에서 얻을 수 있는 최고 점수를 반환한다.
 * pageScore : 페이지 숫자로 얻을 수 있는 최고 점수를 반환한다
 */
class Problem1 {
    private static final int PAGE_MIN = 1, PAGE_MAX = 400;

    private static final Map<String, Integer> gameResult = Map.of(
            "ERROR", -1,
            "DRAW", 0,
            "POBI_WIN", 1,
            "CRONG_WIN", 2);

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkValid(pobi);
            checkValid(crong);

            int pScore = maxScore(pobi);
            int cScore = maxScore(crong);

            if (pScore > cScore)
                return gameResult.get("POBI_WIN");
            else if (pScore < cScore)
                return gameResult.get("CRONG_WIN");
            return gameResult.get("DRAW");
        } catch(Exception e) {
            return gameResult.get("ERROR");
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