package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi, crong)) {
            return -1;
        }

        int pobiScore = Math.max(getScore(pobi.get(0)), getScore(pobi.get(1)));
        int crongScore = Math.max(getScore(crong.get(0)), getScore(crong.get(1)));

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer =  2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static boolean isValid(List<Integer> pobi, List<Integer> crong) {

        return (pobi.size() == 2 && crong.size() == 2)
                && (pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1)
                && (pobi.get(1) <= 400 && crong.get(1) <= 400)
                && (pobi.get(0) % 2 != 0 && pobi.get(1) % 2 != 1)
                && (crong.get(0) % 2 != 0 && crong.get(1) % 2 != 1);
    }

    private static int getScore(int num) {
        int sumScore = 0;
        int mulScore = 1;

        while (num > 0) {
            sumScore += num % 10;
            mulScore *= num % 10;
            num /= 10;
        }

        return Math.max(sumScore, mulScore);
    }
}