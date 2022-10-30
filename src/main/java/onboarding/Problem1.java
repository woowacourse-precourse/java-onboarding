package onboarding;

import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {
    final static int ERROR = -1;
    final static int POBI_WIN = 1;
    final static int CRONG_WIN = 2;
    final static int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validation(pobi) && validation(crong))) {
            return ERROR;
        }
        int pobiScore = score(pobi);
        int crongScore = score(crong);
        if (pobiScore > crongScore) return POBI_WIN;
        if (pobiScore < crongScore) return CRONG_WIN;
        return TIE;
    }

    static boolean validation(List<Integer> pages) {
        if (pages.size() != 2) return false;
        if (pages.get(0) == 1 || pages.get(1) == 400) return false;
        if (pages.get(0) % 2 == 0) return false;
        return pages.get(1) - pages.get(0) == 1;
    }

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

    static int score(List<Integer> pages) {
        return pages.stream()
                .mapToInt(Problem1::score)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}