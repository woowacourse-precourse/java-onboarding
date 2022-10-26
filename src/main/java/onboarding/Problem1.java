package onboarding;

import java.util.List;

class Problem1 {

    public static final int FIRST_PAGE = 1;
    public static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!verificationCheck(pobi) || !verificationCheck(crong)) {
            return -1;
        }
        
        return answer;
    }

    public static boolean verificationCheck(List<Integer> checkList) {
        for (Integer check : checkList) {
            if (check < FIRST_PAGE || check > LAST_PAGE) {
                return false;
            }
        }

        if (checkList.get(0) + 1 != checkList.get(1)) {
            return false;
        }

        return true;
    }

    public static String integerToString(int target) {
        return Integer.toString(target);
    }

    public static int getLength(int target) {
        String stringTarget = integerToString(target);
        return stringTarget.length();
    }
}
