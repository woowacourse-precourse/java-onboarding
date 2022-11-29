package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (verifyPair(pobi) || verifyPair(crong)) {
            return -1;
        }

        int pobiMaxNum = MaxNum.findMaxNumByPerson(pobi);
        int crongMaxNum = MaxNum.findMaxNumByPerson(crong);

        return MaxNum.finalMaxNum(pobiMaxNum, crongMaxNum);
    }

    private static boolean verifyPair(List<Integer> pairList) {
        int leftPage = pairList.get(0);
        int rightPage = pairList.get(1);

        return rightPage - leftPage != 1 || rightPage <= leftPage;
    }

    private static class MaxNum {
        private static int finalMaxNum(int pobiMaxNum, int crongMaxNum) {
            int calNum = pobiMaxNum - crongMaxNum;

            return calNum == 0 ? 0 : (calNum > 0 ? 1 : 2);
        }

        private static int findMaxNumByPerson(List<Integer> numList) {
            int leftMax = findMaxNumByPage(numList.get(0));
            int rightMax = findMaxNumByPage(numList.get(1));

            return Math.max(leftMax, rightMax);
        }

        private static int findMaxNumByPage(int num) {
            char[] charArray = String.valueOf(num).toCharArray();

            int plusNum = 0;
            int multiplyNum = 1;

            for (char c : charArray) {
                int charToNum = Character.getNumericValue(c);
                plusNum += charToNum;
                multiplyNum *= charToNum;
            }

            return Math.max(plusNum, multiplyNum);
        }
    }
}