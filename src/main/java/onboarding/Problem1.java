package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //주어지는 책 페이지 검사하는 기능
        if (isCorrectBookPages(pobi, crong) == -1) {
            answer = -1;
            return answer;
        }

        int pobiMaxNumber = findBigNumber(pobi);
        int crongMaxNumber = findBigNumber(crong);

        if (pobiMaxNumber > crongMaxNumber) {
            answer = 1;
        }
        if (pobiMaxNumber == crongMaxNumber) {
            answer = 0;
        }
        if (pobiMaxNumber < crongMaxNumber) {
            answer = 2;
        }

        return answer;
    }

    public static int isCorrectBookPages(List<Integer> pobi, List<Integer> crong) {
        //1.주어지는 책 페이지 검사하는 기능

        //1-1. 범위가 1~400인지
        for (int i = 0; i < 2; i++) {
            if (pobi.get(i) > 400 || pobi.get(i) < 1) {
                return -1;
            }
            if (crong.get(i) > 400 || crong.get(i) < 1) {
                return -1;
            }
        }
        //1-2. 오른쪽페이지가 왼쪽페이지보다 크거나 같은지
        if (pobi.get(0) >= pobi.get(1)) {
            return -1;
        }
        if (crong.get(0) >= crong.get(1)) {
            return -1;
        }
        //1-3. 오른쪽페이지와 왼쪽페이지의 차이가 1이 아닌지
        if (!(pobi.get(1) - pobi.get(0) == 1)) {
            return -1;
        }
        if (!(crong.get(1) - crong.get(0) == 1)) {
            return -1;
        }

        return 0;
    }
    public static int findBigNumber(List<Integer> openPages) {
        //2.왼쪽페이지와 오른쪽 페이지를 이용하여 큰수를 구하는 기능
        int leftBigNumber = Integer.MIN_VALUE;
        int rightBigNumber = Integer.MIN_VALUE;

        int leftAddNumber = 0;
        int leftMultipleNumber = 1;

        int rightAddNumber = 0;
        int rightMultipleNumber = 1;

        String leftPage = Integer.toString(openPages.get(0));
        String rightPage = Integer.toString(openPages.get(1));
        //2-1 왼쪽페이지의 수를 더한결과와 곱한결과를 구한다.
        for (int i = 0; i < leftPage.length(); i++) {
            leftAddNumber += Character.getNumericValue(leftPage.charAt(i));
            leftMultipleNumber *= Character.getNumericValue(leftPage.charAt(i));
        }
        //2-2 오른쪽페이지의 수를 더한결과와 곱한결과를 구한다.
        for (int i = 0; i < rightPage.length(); i++) {
            rightAddNumber += Character.getNumericValue(rightPage.charAt(i));
            rightMultipleNumber *= Character.getNumericValue(rightPage.charAt(i));
        }

        //2-3 왼쪽 가장 큰값과 오른쪽 가장 큰값을 비교해서 더 큰값을 리턴해준다.
        leftBigNumber = Math.max(leftAddNumber, leftMultipleNumber);
        rightBigNumber = Math.max(rightAddNumber, rightMultipleNumber);

        //3 왼쪽최대값, 오른쪽 최대값중 더 큰값을 리턴해준다.
        return Math.max(leftBigNumber, rightBigNumber);


    }



}