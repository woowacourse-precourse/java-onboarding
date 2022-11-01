package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi) || checkException(crong))
            return -1;
        int answer;
        answer = isWinner(getBigger(pobi), getBigger(crong));
        return answer;
    }
    public static boolean checkException(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);
        return leftPage + 1 != rightPage || leftPage == 0 || rightPage == 400;
    }
    public static int getBigger(List<Integer> pages) {
        int leftPage;
        int rightPage;

        leftPage = Math.max(plusPage(pages.get(0)), mulPage(pages.get(0)));
        rightPage = Math.max(plusPage(pages.get(1)), plusPage(pages.get(1)));

        return Math.max(leftPage, rightPage);
    }
    public static int isWinner(int pobiNumber, int crongNumber){
        if (pobiNumber == crongNumber) {
            return 0;
        } else if (pobiNumber > crongNumber) {
            return 1;
        } else {
            return 2;
        }
    }
    public static int plusPage(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }
    public static int mulPage(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }
}