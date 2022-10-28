package onboarding;

import java.util.List;

class Problem1 {

    private int doSum(int num) {
        String stringInt = String.valueOf(num);
        int sum = 0;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            sum += Integer.parseInt(convertedNum);
        }
        return sum;
    }

    private int doMultiply(int num) {
        String stringInt = String.valueOf(num);
        int multiply = 1;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            multiply *= Integer.parseInt(convertedNum);
        }
        return multiply;
    }

    private int chooseLargeNumber(int num) {
        int summedNum = doSum(num);
        int multipliedNum = doMultiply(num);
        return Math.max(summedNum, multipliedNum);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}