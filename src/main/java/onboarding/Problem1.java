package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer = findWinner(pobi, crong);
        return answer;
    }

    /**
     * firstPage, SecondPage 중 예외사항에 걸리면 false 반환 통과하면 true 반환
     * @param {int} firstPage
     * @param {int} secondPage
     * @return boolean
     */
    public static boolean validatePobi(List<Integer> pobi) {
        for (int i = 0; i < pobi.size(); i++) {
            int firstPage = pobi.get(0);
            int secondPage = pobi.get(1);

            if(firstPage % 2 != 1  || secondPage % 2 != 0) return false;
            if(secondPage - firstPage != 1) return false;
            if (firstPage == 1 || secondPage == 400) return false;
        }
        return true;
    }

    /**
     * firstPage, SecondPage 중 예외사항에 걸리면 false 반환 통과하면 true 반환
     * @param {int} firstPage
     * @param {int} secondPage
     * @return boolean
     */
    public static boolean validateCrong(List<Integer> crong) {
        for (int i = 0; i < crong.size(); i++) {
            int firstPage = crong.get(0);
            int secondPage = crong.get(1);

            if(firstPage % 2 != 1  || secondPage % 2 != 0) return false;
            if(secondPage - firstPage != 1) return false;
            if (firstPage == 1 || secondPage == 400) return false;
        }
        return true;
    }

    /**
     * firstPage, secondPage 각각 자릿수의 합과 곱을 비교해 큰 수 반환
     * @param {int} n1
     * @param {int} n2
     * @return {int} maxValue
     */
    public static int findMaxValue(List<Integer> player) {
        int firstPageMaxValue = 0;
        int secondPageMaxValue = 0;

        firstPageMaxValue = calculate(player.get(0));
        secondPageMaxValue = calculate(player.get(1));

        int maxValue = Math.max(firstPageMaxValue, secondPageMaxValue);

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

    /**
     * pobi와 crong을 입력받은뒤 페이지의 최댓값이 큰쪽을 반환합니다.
     * @param {int} pobi
     * @param {int} crong
     * @return int
     */
    public static int findWinner(List<Integer> pobi, List<Integer> crong) {
        int pobiScore , crongScore;
        int inputError = -1;
        int draw = 0;
        int pobiWin = 1;
        int crongWin = 2;

        if(validatePobi(pobi) && validateCrong(crong)) {
            pobiScore = findMaxValue(pobi);
            crongScore = findMaxValue(crong);

            if(pobiScore > crongScore) return pobiWin;
            if(crongScore > pobiScore) return crongWin;
            else return draw;
        }
        return inputError;
    }


}