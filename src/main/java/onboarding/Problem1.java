package onboarding;

import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {
    final static int ERROR = -1;
    final static int POBI_WIN = 1;
    final static int CRONG_WIN = 2;
    final static int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (violation(pobi) || violation(crong)) {
            return ERROR;
        }
        int pobiScore = score(pobi);
        int crongScore = score(crong);
        if (pobiScore > crongScore) return POBI_WIN;
        if (pobiScore < crongScore) return CRONG_WIN;
        return TIE;
    }

    static boolean violation(List<Integer> pages) {
        if (pages.size() != 2) return true; // 두 페이지로 구성되어 있어야함
        if (pages.get(0) == 1 || pages.get(1) == 400) return true; // 첫 페이지, 마지막 페이지 포함하면 안됨
        if (pages.get(0) % 2 == 0) return true; // 왼쪽 페이지는 홀수여야 함
        if (pages.get(1) - pages.get(0) != 1) return true; // 두 페이지는 연속
        int min = Math.min(pages.get(0), pages.get(1));
        int max = Math.max(pages.get(0), pages.get(1));
        return min < 1 || max > 400; // 페이지 범위는 1에서 400
    }
    
    // 페이지 점수 계산
    static int score(int page) {
        int product = 1;
        int sum = 0;
        while (page > 0) {
            int curr = page % 10;
            product *= curr;
            sum += curr;
            page /= 10;
        }
        return Math.max(product, sum);
    }

    // 가장 점수 높은 페이지 출력(두개만 비교해도 되지만, 나중에 게임 방식이 바뀔 수도 있는 것을 고려함)
    static int score(List<Integer> pages) {
        return pages.stream()
                .mapToInt(Problem1::score)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
