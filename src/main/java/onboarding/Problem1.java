package onboarding;

import java.util.List;

class Problem1 {

    public static final int START_PAGE = 1;
    public static final int FINAl_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }


    private static int sumScore(List<Integer> pageList, int index) {
        int pageNumber = pageList.get(index);
        int sum = 0;

        while (pageNumber > 1) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }

        return sum;
    }
}