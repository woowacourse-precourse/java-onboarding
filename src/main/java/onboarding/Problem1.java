package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        return answer;
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
