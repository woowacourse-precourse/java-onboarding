package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!findPageException(pobi) || !findPageException(crong)) return -1;

        int pobiScore = Integer.MIN_VALUE;
        for (Integer pageNum : pobi) {
            int curPobiMaxScore = Math.max(addPageDigits(pageNum), mulPageDigits(pageNum));
            pobiScore = Math.max(pobiScore, curPobiMaxScore);
        }

        int crongScore = Integer.MIN_VALUE;
        for (Integer pageNum : crong) {
            int curCrongMaxScore = Math.max(addPageDigits(pageNum), mulPageDigits(pageNum));
            crongScore = Math.max(crongScore, curCrongMaxScore);
        }
        return answer;
    }

    public static boolean findPageException(List<Integer> user) {
        if (user.get(0) % 2 == 0) return false;
        if (user.get(1) != user.get(0) + 1) return false;
        if (user.get(0) == 1 || user.get(1) == 400) return false;
        return true;
    }

    public static int addPageDigits(int pageNum) {
        int pageDigitsSum = 0;
        while (pageNum > 0) {
            pageDigitsSum += pageNum % 10;
            pageNum /= 10;
        }
        return pageDigitsSum;
    }

    public static int mulPageDigits(int pageNum) {
        int pageDigitsMul = 1;
        while (pageNum > 0) {
            pageDigitsMul *= pageNum % 10;
            pageNum /= 10;
        }
        return pageDigitsMul;
    }
}