package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static int _first_page = 0;
    private static int _second_page = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyBook(pobi) || !verifyBook(crong))
            return -1;
        int bigPobi = Math.max(calcMaxValue(pobi.get(_first_page)), calcMaxValue(pobi.get(_second_page)));
        int bigCrong = Math.max(calcMaxValue(crong.get(_first_page)), calcMaxValue(crong.get(_second_page)));
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
        if (list.get(0) % 2 == 0 || list.get(1) % 2 == 1) {
            return false;
        }
        // 왼쪽 페이지와 오른쪽 페이지가 1페이지 이상 차이날 경우
        if (list.get(1) - list.get(0) != 1) {
            return false;
        }
        return true;
    }

    private static int calcMaxValue(int n) {
        int sum = 0;
        int mul = 1;

        while (n > 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }
        return Math.max(sum, mul);
    }
}