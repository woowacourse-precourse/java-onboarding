package onboarding;

import java.util.List;

class Problem1 {
    static class BookPage {
        private int leftPage;
        private int rightPage;

        BookPage(int leftPage, int rightPage) throws Exception {
            if (!isValid(leftPage, rightPage)) throw new Exception("ERROR");
            this.leftPage = leftPage;
            this.rightPage = rightPage;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookPage pobiBookPage;
        BookPage crongBookPage;
        int answer;

        try {
            pobiBookPage = new BookPage(pobi.get(0), pobi.get(1));
            crongBookPage = new BookPage(crong.get(0), crong.get(1));
        } catch (Exception e) {
            return -1;
        }

        answer = getAnswer(pobiBookPage, crongBookPage);

        return answer;
    }

    private static boolean isValid(int leftPage, int rightPage) {
        boolean validValue = true;

        if ((leftPage <= 0) || (rightPage >= 400) || (leftPage % 2 == 0) || (rightPage % 2 == 1) || (rightPage - leftPage != 1)) {
            validValue = false;
        }

        return validValue;
    }
}