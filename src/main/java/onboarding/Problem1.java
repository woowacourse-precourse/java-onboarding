package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(isValidPage(pobi) && isValidPage(crong))) {
            return -1;
        }
        int pobiResult = calculatePage(pobi);
        int crongResult = calculatePage(crong);

        answer = getResult(pobiResult, crongResult);

        return answer;
    }

    private static int getResult(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return 1;
        }
        if (crongResult > pobiResult) {
            return 2;
        }
        return 0;
    }

    private static int calculatePage(List<Integer> pageList) {

        Integer leftPage = pageList.get(0);
        Integer rightPage = pageList.get(1);

        int leftPageResult = Math.max(multiplePage(leftPage), plusPage(leftPage));
        int rightPageResult = Math.max(multiplePage(rightPage), plusPage(rightPage));
        return Math.max(leftPageResult, rightPageResult);
    }

    private static int multiplePage(int page) {
        if (page < 10) {
            return page;
        }
        if (page < 100) {
            return (page % 10) * (page / 10);
        }
        return (page % 10) * ((page % 100) / 10) * (page / 100);
    }

    private static int plusPage(int page) {
        if (page < 10) {
            return page;
        }
        return (page % 10) + ((page % 100) / 10) + (page / 100);
    }

    private static boolean isValidPage(List<Integer> pageList) {
        Integer first = pageList.get(0);
        Integer second = pageList.get(1);
        return (first > 1 && second < 400) &&
                (second - first == 1);
    }
}