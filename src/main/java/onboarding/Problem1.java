package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (hasError(pobi) || hasError(crong))
            answer = -1;
        else {
            int pobiMax = findMax(pobi);
            int crongMax = findMax(crong);
            if (pobiMax > crongMax)
                answer = 1;
            else if (pobiMax < crongMax)
                answer = 2;
            else
                answer = 0;
        }
        return answer;
    }

    public static boolean hasError(List<Integer> pages) {
        if (pages.get(0) <= 0 || pages.get(1) <= 0
                || pages.get(0) >= 401 || pages.get(1) >= 401
                || pages.get(0) + 1 != pages.get(1))
            return true;
        else
            return false;
    }

    public static int findMax(List<Integer> pages) {
        int LeftMax = Math.max(addPage(pages.get(0)), multiplyPage(pages.get(0)));
        int RightMax = Math.max(addPage(pages.get(1)), multiplyPage(pages.get(1)));
        int Max = Math.max(LeftMax, RightMax);
        return Max;
    }

    public static int addPage(int pageNum) {
        int result = 0;
        while (pageNum > 0) {
            result += pageNum % 10;
            pageNum /= 10;
        }
        return result;
    }

    public static int multiplyPage(int pageNum) {
        int result = 1;
        while (pageNum > 0) {
            result *= pageNum % 10;
            pageNum /= 10;
        }
        return result;
    }
}