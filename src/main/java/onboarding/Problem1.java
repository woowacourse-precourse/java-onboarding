package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!isValid(pobi) || !isValid(crong) || pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        int maxPobi = 0, maxCrong = 0;
        maxPobi = Math.max(makeBig(pobi.get(0).toString()), makeBig(pobi.get(1).toString()));
        maxCrong = Math.max(makeBig(crong.get(0).toString()), makeBig(crong.get(1).toString()));

        return maxPobi > maxCrong ? 1 : maxPobi == maxCrong ? 0 : 2;
    }

    static boolean isValid(List<Integer> list) {
        if(Math.min(list.get(0), list.get(1)) < 1 || Math.max(list.get(0), list.get(1)) > 400) {
            return false;
        }
        return true;
    }

    static int makeBig(String str) {
        int maxSum = 0, maxMul = 1;

        for(char ch : str.toCharArray()) {
            maxSum += ch - '0';
            maxMul *= ch - '0';
        }

        return Math.max(maxMul, maxSum);
    }
}