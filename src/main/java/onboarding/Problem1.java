package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    private static int sumEachNumber(int pageNumber) {
        int sum = 0;
        String strPageNumber = String.valueOf(pageNumber);
        for(int i=0; i<strPageNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(strPageNumber.charAt(i)));
        }

        return sum;
    }
}