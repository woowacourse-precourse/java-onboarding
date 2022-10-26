package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //페이지를 입력받아 페이지의 최대 점수를 반환하는 함수(더하기, 곱하기 비교)
        //왼쪽, 오른쪽 페이지의 점수를 받아 최대점수를 반환하는 함수

        int answer = Integer.MAX_VALUE;

        if (!isCorrectInput(pobi.get(0), pobi.get(1)) || !isCorrectInput(crong.get(0), crong.get(1))) {
            return -1;
        }

        return answer;
    }

    public static boolean isCorrectInput(int numOfFirstPage, int numOfSecondPage) {

        if (numOfFirstPage < 1 || numOfSecondPage > 400) {
            return false;
        }

        if (((numOfFirstPage + 1) != numOfSecondPage) || numOfFirstPage % 2 != 1 || numOfSecondPage % 2 != 0) {
            return false;
        }
        return true;
    }

    public static int findMaxOfPage(int numOfPage) {
        String numOfStringPage = Integer.toString(numOfPage);
        int sumOfPage = 0;
        int productOfPage = 1;

        for (int i = 0; i < numOfStringPage.length(); i++) {
            int strToInt = Integer.parseInt(numOfStringPage.substring(i, i + 1));
            sumOfPage += strToInt;
            productOfPage *= strToInt;
        }

        return Math.max(sumOfPage, productOfPage);
    }
}