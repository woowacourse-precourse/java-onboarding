package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiResult, crongResult;

        if(hasErrorOnInput(pobi) ||hasErrorOnInput(crong)) {
            return -1;
        }

        pobiResult = calculateScore(pobi);
        crongResult = calculateScore(crong);

        if(pobiResult == crongResult) return 0;
        else if(pobiResult > crongResult) return 1;
        else return 2;
    }

    private static boolean hasErrorOnInput(List<Integer> input) {
        int leftNum, rightNum;
        boolean isValidate;

        leftNum = input.get(0);
        rightNum = input.get(1);

        isValidate = (leftNum >= 3) && (leftNum <= 397)
                && (leftNum % 2 == 1) && (leftNum + 1 == rightNum);

        return !isValidate;
    }

    private static int calculateScore(List<Integer> input) {
        int target = input.get(1);
        int[] resultCandidate = {0, 1};

        if(target % 10 == 0)
            target = input.get(0);

        while(target != 0) {
            resultCandidate[0] += target % 10;
            resultCandidate[1] *= target % 10;
            target /= 10;
        }

        return Integer.max(resultCandidate[0], resultCandidate[1]);
    }
}