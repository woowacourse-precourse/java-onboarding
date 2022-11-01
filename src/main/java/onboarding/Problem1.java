package onboarding;

import ExceptionValidation.P1ExceptionValidation;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        final int LEFT = 0;
        final int RIGHT = 1;

        if(!(P1ExceptionValidation.p1ExceptionValidation(pobi)
                && P1ExceptionValidation.p1ExceptionValidation(crong))){
            return -1;
        }

        int pobiLeftPage = MaxBetweenSumandMultiple(pobi.get(LEFT));
        int pobiRightPage = MaxBetweenSumandMultiple(pobi.get(RIGHT));

        int crongLeftPage = MaxBetweenSumandMultiple(crong.get(LEFT));
        int crongRightPage = MaxBetweenSumandMultiple(crong.get(RIGHT));

        int pobiScore = Math.max(pobiLeftPage, pobiRightPage);
        int crongScore = Math.max(crongLeftPage, crongRightPage);

        return pobiScore > crongScore ? 1 : (pobiScore == crongScore ? 0 : 2);
    }

    public static int MaxBetweenSumandMultiple(int number) {

        int sum = 0;
        int multiple = 1;

        String s = Integer.toString(number);

        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
            multiple *= Integer.parseInt(s.substring(i, i + 1));
        }

        return Math.max(sum, multiple);
    }

}