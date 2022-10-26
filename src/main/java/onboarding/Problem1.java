package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static boolean checkError(List<Integer> list) {
        if (list.get(0) == null || list.get(1) == null)
            return true;
        if (!(((list.get(0) & 1) == 1) && ((list.get(1) & 1) == 0))) {
            return true;
        }
        if (!(list.get(0) <= 400 && list.get(1) <= 400 && list.get(0) >= 1 && list.get(1) >= 1)) {
            return true;
        }
        return list.get(1) - list.get(0) != 1;
    }

    static List<Integer> intToList(int x) {
        List<Integer> result = new ArrayList<>();
        while (x != 0) {
            result.add(x % 10);
            x /= 10;
        }

        return result;
    }

    static int getMax(List<Integer> list) {
        return Integer.max(list.stream().reduce(0, Integer::sum), list.stream().reduce(1, (a, b) -> a * b));
    }

    static int calc(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        List<Integer> leftList = intToList(left);
        List<Integer> rightList = intToList(right);
        int leftResult = getMax(leftList);
        int rightResult = getMax(rightList);
        return Integer.max(leftResult, rightResult);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkError(pobi) || checkError(crong))
            return -1;
        int resultPobi = calc(pobi);
        int resultCrong = calc(crong);

        if (resultCrong == resultPobi) {
            return 0;
        } else if (resultPobi > resultCrong) {
            return 1;
        } else if (resultPobi < resultCrong) {
            return 2;
        }
        return -1;
    }
}
