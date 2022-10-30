package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkExcept(pobi) || checkExcept(crong)) return -1;
        int pobiMax = cal(pobi);
        int crongMax = cal(crong);
        if (pobiMax > crongMax) return 1;
        else if (pobiMax < crongMax) return 2;
        else return 0;
    }

    public static boolean checkExcept(List<Integer> v) {
        if (v.get(0) <= 1 || v.get(0) >= 400 || v.get(1) <= 1 || v.get(1) >= 400) return true;
        if (v.get(0) % 2 != 1 || v.get(1) % 2 != 0) return true;
        if (v.get(0) + 1 != v.get(1)) return true;
        return false;
    }

    public static int cal(List<Integer> v) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < v.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            int addSum = 0, mulSum = 1;
            int x = v.get(i);
            while (x > 0) {
                temp.add(x % 10);
                x /= 10;
            }
            for (int j = 0; j < temp.size(); j++) {
                addSum += temp.get(j);
                mulSum *= temp.get(j);
            }
            result.add(addSum);
            result.add(mulSum);
        }
        result.sort(Comparator.reverseOrder());
        return result.get(0);
    }
}