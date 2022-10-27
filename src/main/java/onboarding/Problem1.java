package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validPage(List<Integer> pages){
        pages.stream().sorted().collect(Collectors.toList()); // 혹시 모를 뒤에서부터 시작했을 경우
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        if (leftPage < 1 || rightPage > 400) // 주운 책보다 많은 페이지가 들어온 경우
            return false;
        if (leftPage != rightPage - 1 || leftPage == 1 || rightPage == 400) // 연속된 값이 아니거나 첫번째 페이지(1)이거나 마지막 페이지(400) 일경우
            return false;
        return true;
    }

    private static int getSumNumber(Integer page){
        int answer = 0;

        while (page > 0){
            answer += page % 10;
            page /= 10;
        }
        return answer;
    }

    private static int getMultiplyNumber(Integer page){
        int answer = 1;

        while (page > 0){
            answer *= page % 10;
            page /= 10;
        }
        return answer;
    }
    private static int getBiggerNumber(List<Integer> pages){
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        return Math.max(Math.max(getSumNumber(leftPage), getMultiplyNumber(leftPage)), Math.max(getSumNumber(rightPage), getMultiplyNumber(rightPage)));
    }
}