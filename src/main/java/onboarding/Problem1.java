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

    private static int multEachNumber(int pageNumber) {
        int mult = 0;
        String strPageNumber = String.valueOf(pageNumber);
        for(int i=0; i<strPageNumber.length(); i++) {
            mult *= Integer.parseInt(String.valueOf(strPageNumber.charAt(i)));
        }

        return mult;
    }

    private static int validateBiggerNumber(int number1, int number2) {
        if(number1 < number2) {
            return number2;
        }

        return number1;
    }
}