package onboarding;

import java.util.List;

class Problem1 {
    public static final int LEFT_IDX = 0;
    public static final int RIGHT_IDX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getUserScore(List<Integer> pageList) {
        int leftPage = pageList.get(LEFT_IDX);
        int rightPage = pageList.get(RIGHT_IDX);

        int leftScore = getLargerValue(leftPage);
        int rightScore = getLargerValue(rightPage);

        return Math.max(leftScore, rightScore);
    }

    public static int getLargerValue(int page) {
        String[] splitNums = String.valueOf(page).split("");

        int acc = 0;
        int mul = 1;

        for (String splitNum : splitNums) {
            acc += Integer.parseInt(splitNum);
            mul *= Integer.parseInt(splitNum);
        }

        return Math.max(acc, mul);
    }
}