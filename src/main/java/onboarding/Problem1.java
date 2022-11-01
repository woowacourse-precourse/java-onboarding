package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiMax = findPobiMax(pobi);
        int crongMax = findCrongMax(crong);

        if (isInputRight(pobi, crong)) {
            answer = -1;
            return answer;
        }

        answer = comparePobiAndCrong(pobiMax, crongMax);
        return answer;
    }
    private static int comparePobiAndCrong(int pobiMax, int crongMax) {
        int answer = 0;
        if (pobiMax > crongMax) {
            answer = 1;
        }
        if (pobiMax < crongMax) {
            answer = 2;
        }
        return answer;
    }

    private static boolean isInputRight(List<Integer> pobi, List<Integer> crong) {
        return !(exception(crong) && exception(pobi));
    }

    public static boolean exception(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (ContinuePage(leftPage, rightPage)) {
            return false;
        }
        return !FirstLastPage(leftPage, rightPage);
    }
    private static boolean ContinuePage(int leftPage, int rightPage) {
        return Math.abs(rightPage - leftPage) > 1;
    }
    private static boolean FirstLastPage(int leftPage, int rightPage) {
        return rightPage == 400 || leftPage == 1;
    }


    public static int findPobiMax(List<Integer> pobi) {

        int leftPageMax = splitNum(pobi.get(0));
        int rightPageMax = splitNum(pobi.get(1));

        return getMax(leftPageMax, rightPageMax);
    }

    public static int findCrongMax(List<Integer> crong) {

        int leftPageMax = splitNum(crong.get(0));
        int rightPageMax = splitNum(crong.get(1));

        return getMax(leftPageMax, rightPageMax);
    }

    public static int splitNum(Integer x) {
        int addDigits = 0;
        int multiplyDigits = 1;
        while (x > 0) {
            addDigits += x % 10;
            multiplyDigits *= x % 10;
            x /= 10;
        }
        return getMax(addDigits, multiplyDigits);
    }
    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }
}
