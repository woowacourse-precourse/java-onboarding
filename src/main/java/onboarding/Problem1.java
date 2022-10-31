package onboarding;

import java.util.List;

class Problem1 {
    public static int pagePlus(int page) {
        int total = 0;
        while (page > 1) {
            total += page%10;
            page /= 10;
        }
        return total;
    }

    public static int pageMultiply(int page) {
        int total = 1;
        while (page > 1) {
            total *= page%10;
            page /= 10;
        }
        return total;
    }

    public static int calculationComparison(int page) {
        int plus = pagePlus(page);
        int multiply = pageMultiply(page);
        if (plus > multiply) {
            return plus;
        }
        return multiply;
    }

    public static int pagesComparison(int page1, int page2) {
        int maxPage1 = calculationComparison(page1);
        int maxPage2 = calculationComparison(page2);
        if (maxPage1 >= maxPage2) {
            return maxPage1;
        }
        return maxPage2;
    }

    public static boolean exception(int left, int right) {
        if (left+1 == right) {
            return false;
        }
        return true;
    }

    public static int winner(int pobiLeft, int pobiRight, int crongLeft, int crongRight) {
        if (exception(pobiLeft, pobiRight) || exception(crongLeft, crongRight)) {
            return -1;
        }
        int maxPobi = pagesComparison(pobiLeft, pobiRight);
        int maxCrong = pagesComparison(crongLeft, crongRight);
        if (maxPobi > maxCrong) {
            return 1;
        }
        if (maxPobi < maxCrong) {
            return 2;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] pobiArray = pobi.stream().mapToInt(i->i).toArray();
        int[] crongArray = crong.stream().mapToInt(i->i).toArray();
        int answer = winner(pobiArray[0], pobiArray[1], crongArray[0], crongArray[1]);
        return answer;
    }
}