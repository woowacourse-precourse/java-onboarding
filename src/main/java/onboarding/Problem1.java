package onboarding;

import custom.problem1.BookPages;
import java.util.List;

/**
 * > 요구사항 <br>
 * 1. 책 페이지의 예외 처리 조건을 만든다.(일급 컬렉션) <br>
 * 2. 페이지 별로 각 자리수 합 또는 곱 중에 최대 값을 구한다. <br>
 * 3. 예외 조건이 발생하면 -1, 포비가 이기면 1, 크롱이 이기면 2, 비기면 0 반환
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookPages pobiPages;
        BookPages crongPages;

        try {
            pobiPages = new BookPages(pobi);
            crongPages = new BookPages(crong);
        } catch (RuntimeException e) {
            return -1;
        }

        int pobiMaxScore = pobiPages.getMaxNumber();
        int crongMaxScore = crongPages.getMaxNumber();
        if (pobiMaxScore > crongMaxScore) {
            return 1;
        }
        if (pobiMaxScore < crongMaxScore) {
            return 2;
        }
        return 0;
    }
}