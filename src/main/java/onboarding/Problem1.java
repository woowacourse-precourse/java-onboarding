package onboarding;

import java.util.List;

class Problem1 {

    private final static int DRAW = 0;
    private final static int CRONG_WIN = 2;
    private final static int POBI_WIN = 1;
    private final static int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (validateIfBookPageNotCorrect(pobi)) {
            return EXCEPTION;
        }
        if (validateIfBookPageNotCorrect(crong)) {
            return EXCEPTION;
        }

        int pobiMax = calculateMax(pobi);
        int crongMax = calculateMax(crong);

        if (pobiMax == crongMax) {
            return DRAW;
        } else if (pobiMax > crongMax) {
            return POBI_WIN;
        } else {
            return CRONG_WIN;
        }

    }

    private static boolean validateIfBookPageNotCorrect(List<Integer> targets) {
        return targets.get(0) + 1 != targets.get(1);
    }

    public static int calculateMax(List<Integer> targets) {
        int targetsMax = 0;
        String strtargets = null;

        for (Integer each : targets) {
            strtargets = each.toString(); //
            String[] splittargets = strtargets.split("");

            int sum = 0;
            int multiply = 1;
            for (String eachSplitPobi : splittargets) {
                sum += Integer.parseInt(eachSplitPobi);
                multiply *= Integer.parseInt(eachSplitPobi);
            }
            targetsMax = Math.max(sum, multiply);
        }

        return targetsMax;
    }

}