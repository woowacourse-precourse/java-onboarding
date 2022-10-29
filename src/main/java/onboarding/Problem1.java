package onboarding;

import java.util.List;

class Problem1 {
    private static final int fisrtPage = 1;
    private static final int lastPage = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(validateInput(pobi) && validateInput(crong))) {
            return -1;
        }



        return answer;
    }

    private static boolean validateInput(List<Integer> input) {
        if (Math.abs(input.get(0) - input.get(1)) != 1) {
            return false;
        }

        for (Integer page : input) {
            if (page <= fisrtPage || lastPage <= page) {
                return false;
            }
        }

        return true;
    }

}