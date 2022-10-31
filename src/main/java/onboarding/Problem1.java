package onboarding;

import onboarding.problem1.Page;
import onboarding.problem1.PageException;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean pobiException = PageException.checkException(pobi);
        boolean crongException = PageException.checkException(crong);

        if (pobiException || crongException) {
            return result.EXCEPTION.getCode();
        }

        int pobiMaxPage = Page.getMyMaxPage(pobi);
        int crongMaxPage = Page.getMyMaxPage(crong);

        if (pobiMaxPage > crongMaxPage) {
            return result.POBI_WIN.getCode();
        } else if (pobiMaxPage < crongMaxPage) {
            return result.CRONG_WIN.getCode();
        } else {
            return result.DRAW.getCode();
        }
    }

    private enum result {
        POBI_WIN(1),
        CRONG_WIN(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int code;

        result(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}