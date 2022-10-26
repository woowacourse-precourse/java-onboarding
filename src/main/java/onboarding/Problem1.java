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
        return answer;
    }

    private static int calculatePage(List<Integer> pageList) {
        return Math.max(
                multiplePage(pageList.get(0)),
                plusPage(pageList.get(1))
        );
    }

    private static int multiplePage(int page) {
        if (page < 10) {
            return page;
        }
        return (page % 10) * (page / 10);
    }

    private static int plusPage(int page) {
        if (page < 10) {
            return page;
        }
        return (page % 10) + (page / 10);
    }

    private static boolean isValidPage(List<Integer> pageList) {
        Integer first = pageList.get(0);
        Integer second = pageList.get(1);
        return (first > 1 && second < 400) &&
                (second - first == 1);
    }
}