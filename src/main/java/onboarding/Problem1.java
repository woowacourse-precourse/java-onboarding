package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    private static int getMaxNumByPage(int page) {
        String pageStr = String.valueOf(page);
        int maxPlusNum = 0;
        int maxMultiplyNum = 1;
        for (int i = 0; i < pageStr.length(); i++) {
            int tempNum = pageStr.charAt(i) - '0';

            maxPlusNum += tempNum;
            maxMultiplyNum *= tempNum;
        }

        return Math.max(maxPlusNum, maxMultiplyNum);
    }
}