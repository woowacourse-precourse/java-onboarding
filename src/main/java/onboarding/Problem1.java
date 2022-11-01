package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkExection(pobi) || checkExection(crong)) {
            answer = -1;
            return answer;
        }

        int pobiMax = Math.max(getScoreSum(pobi), getScoreMul(pobi));
        int crongMax = Math.max(getScoreSum(crong), getScoreMul(crong));

        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax == crongMax) {
            answer = 0;
        } else {
            answer = 2;
        }
        return answer;
    }
    private static int getScoreSum(List<Integer> page) {
        int max = 0;
        int[] resSum = new int[2];

        for (int i = 0; i < page.size(); i++) {
            int pageNum = page.get(i);
            int res = 0;
            while (pageNum > 0) {
                res += pageNum % 10;
                pageNum /= 10;
            }
            resSum[i] = res;
        }
        max = Math.max(resSum[0], resSum[1]);
        return max;
    }

    private static  int getScoreMul(List<Integer> page) {
        int max = 0;
        int[] resMul = new int[2];

        for (int i = 0; i < page.size(); i++) {
            int pageNum = page.get(i);
            int res = 1;
            while (pageNum > 0) {
                res *= pageNum % 10;
                pageNum /= 10;
            }
            resMul[i] = res;
        }
        max = Math.max(resMul[0], resMul[1]);
        return max;
    }

    private static boolean checkExection(List<Integer> page) { // 페이지 에러 측정
        if (page.size() != 2) {
            return true;
        }
        if (page.get(0) <= 1 || page.get(0) >= 400 || page.get(0) % 2 == 0) { // 페이지 범위
            return true;
        }
        if (page.get(1) != page.get(0) + 1) {
            return true;
        }
        return false;
    }
}

