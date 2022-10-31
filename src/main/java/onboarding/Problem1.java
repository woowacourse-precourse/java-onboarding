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
     * firstPage, SecondPage 중 예외사항에 걸리면 false 반환 통과하면 true 반환
     * @param {int} firstPage
     * @param {int} secondPage
     * @return boolean
     */
    public static boolean inputValidation(int firstPage, int secondPage) {
        if(firstPage % 2 != 1  || secondPage % 2 != 0) return false;
        if(secondPage - firstPage != 1) return false;
        if (firstPage == 1 || secondPage == 400) return false;
        return true;
    }

    /**
     * firstPage, secondPage 각각 자릿수의 합과 곱을 비교해 큰 수 반환
     * @param {int} n1
     * @param {int} n2
     * @return {int} maxValue
     */
    public static int findMaxValue(int firstPage, int secondPage) {
        int firstPageMaxValue = 0;
        int secondPageMaxValue = 0;

        firstPageMaxValue = calculate(firstPage);
        secondPageMaxValue = calculate(secondPage);

        int maxValue = Math.max(firstPageMaxValue, secondPageMaxValue)

        return maxValue;
    }

    /**
     * 입력받은 page의 각 자리 합과 곱의 크기를 비교해 큰수를 반환
     * @param {int} page
     * @return {int} max
     */
    public static int calculate(int page) {
        char[] pageArr = String.valueOf(page).toCharArray();
        int sum = 0;
        int multiple = 1;

        for (char c : pageArr) {
            sum += Character.getNumericValue(c);
            multiple *= Character.getNumericValue(c);
        }

        int max = Math.max(sum, multiple);

        return max;
    }



}