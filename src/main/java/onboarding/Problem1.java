package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(validatePage(pobi) && validatePage(crong))) {
            return -1;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        return answer;
    }

    private static boolean validatePage(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if ((left < 1 || left > 400) || (right < 1 || right > 400)) {
            return false;
        }

        if ((left + 1) != right) {
            return false;
        }

        if ((left % 2 == 0) || (right % 2 == 1)) {
            return false;
        }

        return true;
    }

    private static int calculateScore(List<Integer> pages) {
        int[] score = new int[2];

        for (int i = 0; i < pages.size(); i++) {
            String pageNum = Integer.toString(pages.get(i));

            int plus = 0;
            int multiple = 1;

            for (int j = 0; j < pageNum.length(); j++) {
                int num = pageNum.charAt(j) - '0';

                plus += num;
                multiple *= num;
            }

            score[i] = Math.max(plus, multiple);
        }

        return Math.max(score[0], score[1]);
    }
}
