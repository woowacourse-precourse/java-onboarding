package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        pobiScore = max(getPageNumberSum(pobi), getPageNumberMulti(pobi));
        crongScore = max(getPageNumberSum(crong), getPageNumberMulti(crong));
        answer = fight(pobiScore, crongScore);

        return answer;
    }

    public static int getPageNumberSum(List<Integer> pages) {
        return pages.get(0) + pages.get(1);
    }

    public static int getPageNumberMulti(List<Integer> pages) {
        return pages.get(0) * pages.get(1);
    }

    public static int max(int sum, int multi) {
        if (sum >= multi) {
            return sum;
        }
        return multi;
    }

    public static int fight(int pobiScore, int crongScore) {
        if (crongScore > pobiScore) {
            return 2;
        }
        else if (pobiScore > crongScore) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static boolean isValid(List<Integer> pages) {
        if (!isInRange(pages)) {
            return false;
        }
        if ((pages.get(0) + 1) != pages.get(1)) {
            return false;
        }
        return true;
    }

    public static boolean isInRange(List<Integer> pages) {
        if (pages.get(0) <= 2 || pages.get(1) <= 2) {
            return false;
        }
        if (pages.get(0) >= 399 || pages.get(1) >= 399) {
            return false;
        }
        return true;
    }
}