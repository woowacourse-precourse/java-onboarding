package onboarding;

import java.util.List;

class Problem1 {
    public static int pageMaxNum(List<Integer> pages) {
        int maxNum = 0;
        for (int page : pages) {
            int sum = 0;
            int multiply = 1;
            while (page > 0) {
                sum += page % 10;
                multiply *= page % 10;
                page /= 10;
            }
            if (maxNum < sum) {
                maxNum = sum;
            }
            if (maxNum < multiply) {
                maxNum = multiply;
            }
        }
        return maxNum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1).equals(pobi.get(0)+1) && crong.get(1).equals(crong.get(0)+1)) {
            int maxPobi = pageMaxNum(pobi);
            int maxCrong = pageMaxNum(crong);
            if (maxPobi > maxCrong) {
                return 1;
            } else if (maxPobi < maxCrong) {
                return 2;
            } else {
                return 0;
            }
        }
        else {
            return -1;
        }
    }
}