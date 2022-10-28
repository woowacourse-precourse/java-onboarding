package onboarding;

import java.util.List;

class Problem1 {

    private int plusNumber(int pageNumber){
        int result = 0;

        result += pageNumber / 100;
        pageNumber %= 100;
        result += pageNumber / 10;
        pageNumber %= 10;
        result += pageNumber;

        return result;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}