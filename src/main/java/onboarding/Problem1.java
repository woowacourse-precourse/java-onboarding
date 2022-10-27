package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0, crongScore = 0;

        return answer;


    }

    /**
     * n1, n2 각각 자릿수의 합과 곱을 비교해 큰 수 반환
     * @param n1
     * @param n2
     * @return
     */
    public int maxValue(int n1, int n2) {
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