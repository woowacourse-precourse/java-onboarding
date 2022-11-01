package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkPossibleInput(pobi) && checkPossibleInput(crong)) {
            List<Integer> pobiLeftNumberList = splitNumber(pobi.get(0));
            List<Integer> pobirightNumberList = splitNumber(pobi.get(1));
            List<Integer> crongLeftNumberList = splitNumber(crong.get(0));
            List<Integer> crongRightNumberList = splitNumber(crong.get(1));

            int pobiLeftScore = Math.max(addEachNumber(pobiLeftNumberList), mulEachNumber(pobiLeftNumberList));
            int pobiRightScore = Math.max(addEachNumber(pobirightNumberList), mulEachNumber(pobirightNumberList));
            int pobiScore = Math.max(pobiLeftScore, pobiRightScore);

            int crongLeftScore = Math.max(addEachNumber(crongLeftNumberList), mulEachNumber(crongLeftNumberList));
            int crongRightScore = Math.max(addEachNumber(crongRightNumberList), mulEachNumber(crongRightNumberList));
            int crongScore = Math.max(crongLeftScore, crongRightScore);

            if (pobiScore == crongScore) {
                answer = 0;
            } else if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            }
        } else {
            answer = -1;
        }
        return answer;
    }
    public static boolean checkPossibleInput(List<Integer> numberList) {
        if (numberList.get(0) % 2 != 1) {
            return false;
        }

        if (numberList.get(1) % 2 != 0) {
            return false;
        }

        if (numberList.get(1) - numberList.get(0) != 1) {
            return false;
        }

        if (numberList.get(0) <= 1 || numberList.get(1) >= 400) {
            return false;
        }

        return true;
    }
    public static List<Integer> splitNumber(int num) {
        List<Integer> numberList = new ArrayList<Integer>();
        while (num > 0) {
            int remainder = num % 10;
            numberList.add(remainder);
            num -= remainder;
            num /= 10;
        }
        return numberList;
    }

    public static int addEachNumber(List<Integer> numberList) {
        int addResult = 0;
        for (int num : numberList) {
            addResult += num;
        }
        return addResult;
    }
    public static int mulEachNumber(List<Integer> numberList) {
        int mulResult = 1;
        for (int num : numberList) {
            mulResult *= num;
        }
        return mulResult;
    }
}