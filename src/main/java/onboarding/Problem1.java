package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0, crongScore = 0;

        if(inputValidation(pobi.get(0), pobi.get(1)) && inputValidation(crong.get(0), crong.get(1))){
            pobiScore = maxValue(pobi.get(0), pobi.get(1));
            crongScore = maxValue(crong.get(0), crong.get(1));

            if(pobiScore > crongScore) answer = 1;
            else if(crongScore > pobiScore) answer = 2;
            else answer = 0;
        }
        else {
            answer = -1;
        }

        return answer;
    }

    /**
     * n1, n2 중 예외사항에 걸리면 false 반환 통과하면 true 반환
     * @param {int} n1
     * @param {int} n2
     * @return {boolean}
     */
    public static boolean inputValidation(int n1, int n2) {
        if(n1 % 2 != 1  || n2 % 2 != 0) return false;
        if(n2 - n1 != 1) return false;
        return true;
    }

    /**
     * n1, n2 각각 자릿수의 합과 곱을 비교해 큰 수 반환
     * @param {int} n1
     * @param {int} n2
     * @return {int}
     */
    public static int maxValue(int n1, int n2) {
        char[] charN1 = String.valueOf(n1).toCharArray();
        char[] charN2 = String.valueOf(n2).toCharArray();
        int sum = 0;
        int multiple = 1;
        int n1Max, n2Max;


        for(char c : charN1) {
            sum += Character.getNumericValue(c);
            multiple *= Character.getNumericValue(c);
        }
        n1Max = Math.max(sum, multiple);

        sum = 0;
        multiple = 1;

        for(char c : charN2) {
            sum += Character.getNumericValue(c);
            multiple *= Character.getNumericValue(c);
        }
        n2Max = Math.max(sum, multiple);

        return Math.max(n1Max, n2Max);
    }



}