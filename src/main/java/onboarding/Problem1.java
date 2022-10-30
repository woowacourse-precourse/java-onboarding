package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int validate(List<Integer> pages){
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        // 시작 면 혹은 마지막 면인지 검사
        if(leftPage == 1 || rightPage == 400)
            return -1;

        // 연속된 페이지인지 검사
        if(leftPage + 1 != rightPage)
            return -1;

        return 1;
    }


    private static List<Integer> convertIntToIntList(Integer page){
        List<Integer> radix = new ArrayList<>();

        if (page > 99)
            radix.add((int) (page / 100));

        if(page > 9)
            radix.add((int) (page % 100 / 10));

        radix.add(page % 10);

        return radix;
    }

    private static int getRadixSum(Integer page){
        List<Integer> radix = convertIntToIntList(page);

        return radix.stream().mapToInt(Integer::intValue).sum();
    }

    private static int getRadixMultiply(Integer page){
        List<Integer> radix = convertIntToIntList(page);

        return radix.stream().reduce(1,(a,b) -> a*b);
    }
}