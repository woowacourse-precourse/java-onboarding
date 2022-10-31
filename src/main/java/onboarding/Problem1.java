package onboarding;

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
        if (list == null || list.size() != 2) {
            return false;
        }
        if (isPageOver(list.get(_first_page)) || isPageOver(list.get(_second_page))) {
            return false;
        }
        if (list.get(_first_page) % 2 == 0 || list.get(_second_page) % 2 == 1) {
            return false;
        }
        if (list.get(_second_page) - list.get(_first_page) != 1) {
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