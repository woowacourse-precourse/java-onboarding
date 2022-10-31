package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isError(pobi) || isError(crong)) {
            return -1;
        }

        int pobiScore = Math.max(calculateScore(pobi.get(0)), calculateScore(pobi.get(1)));
        int crongScore = Math.max(calculateScore(crong.get(0)), calculateScore(crong.get(1)));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else if (pobiScore == crongScore) {
            return 0;
        }

        return -1;
    }

    public static boolean isError(List<Integer> inputList) {
        if (inputList.get(0) == null || inputList.get(1) == null || inputList.size() != 2) {
            return true;
        }
        if (inputList.get(0) < 1 || inputList.get(0) > 400 || inputList.get(1) < 1 || inputList.get(1) > 400) {
            return true;
        }
        if (inputList.get(0) % 2 == 0 || inputList.get(1) % 2 == 1) {
            return true;
        }
        if (inputList.get(0) + 1 != inputList.get(1)) {
            return true;
        }
        return false;
    }

    public static int calculateScore(int pageNum) {
        int sumNum = 0;
        int multipleNum = 1;

        while (pageNum != 0) {
            sumNum += pageNum % 10;
            multipleNum *= pageNum % 10;
            pageNum /= 10;
        }

        return Math.max(sumNum, multipleNum);
    }
}