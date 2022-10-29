package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPages(pobi) || !checkPages(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static Boolean checkPages(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (!isCorrectPage(leftPage) || !isCorrectPage(rightPage)){
            return false;
        }
        if (leftPage % 2 != 1 || rightPage % 2 != 0){
            return false;
        }
        return (leftPage + 1) == rightPage;
    }

    private static Boolean isCorrectPage(int page){
        return (page > 2) && (page < 399);
    }

}