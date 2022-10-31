package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyBook(pobi) || !verifyBook(crong))
            return -1;
        int bigPobi = compareNumberAndReturn(
                calcForGetBigger(splitEachNumber(pobi.get(0))),
                calcForGetBigger(splitEachNumber(pobi.get(1))));
        int bigCrong = compareNumberAndReturn(
                calcForGetBigger(splitEachNumber(crong.get(0))),
                calcForGetBigger(splitEachNumber(crong.get(1))));
        if (bigPobi == bigCrong)
            return 0;
        if (bigPobi > bigCrong) {
            return 1;
        }
        return 2;
    }

    private static boolean isPageOver(int n) {
        if (n > 0 && n < 400) {
            return false;
        }
        return true;
    }

    private static boolean verifyBook(List<Integer> list) {
        // 인자가 올바르지 않을 경우
        if (list == null || list.size() != 2) {
            return false;
        }
        // 페이지 범위가 잘못된 경우
        if (isPageOver(list.get(0)) || isPageOver(list.get(1))) {
            return false;
        }
        // 왼쪽 페이지가 짝수일 경우
        if (list.get(0) % 2 == 0) {
            return false;
        }
        // 왼쪽 페이지와 오른쪽 페이지가 1페이지 이상 차이날 경우
        if (list.get(1) - list.get(0) != 1) {
            return false;
        }
        return true;
    }

    private static List<Integer> splitEachNumber(int n) {
        List<Integer> ret = new ArrayList<>();
        while (n > 0) {
            ret.add(n % 10);
            n /= 10;
        }
        return (ret);
    }

    private static int calcForGetBigger(List<Integer> list) {
        int sum = 0;
        int mul = 1;
        for (int i = 0; list.size() > i; ++i) {
            sum += list.get(i);
            mul *= list.get(i);
        }
        return compareNumberAndReturn(sum, mul);
    }

    private static int compareNumberAndReturn(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        }
        return n2;
    }
}