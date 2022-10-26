package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
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

}