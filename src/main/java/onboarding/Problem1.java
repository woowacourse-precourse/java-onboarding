package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (CheckList(pobi) || CheckList(crong)) return -1;
        else return MaxNum(pobi) > MaxNum(crong) ? 1 : MaxNum(pobi) == MaxNum(crong) ? 0 : 2;
    }

    static boolean CheckList(List<Integer> list) {
        if (list.size() != 2 || list.get(1) - list.get(0) != 1 || list.get(0) % 2 != 1 || list.get(0) == 1) return true;
        else return false;
    }

    static int MaxNum(List<Integer> list) {
        int left_num = list.get(0);
        int right_num = list.get(1);
        return CalculateNum(left_num) > CalculateNum(right_num) ? CalculateNum(left_num) : CalculateNum(right_num);
    }

    static int CalculateNum(int page) {
        return PageSum(page) > PageMultiply(page) ? PageSum(page) : PageMultiply(page);
    }

    static int PageSum(int page) {
        int sum = 0;

        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    static int PageMultiply(int page) {
        int sum = 1;

        while (page > 0) {
            sum *= page % 10;
            page /= 10;
        }

        return sum;
    }
}