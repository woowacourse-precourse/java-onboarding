package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (nonValidPage(pobi) || nonValidPage(crong))
            return -1;

        int maxNumberPobi = getBiggerNumber(pobi);
        int maxNumberCrong = getBiggerNumber(crong);

        if (maxNumberPobi > maxNumberCrong)
            return 1;
        else if (maxNumberPobi < maxNumberCrong)
            return 2;
        else
            return 0;
    }

    private static boolean nonValidPage(List<Integer> pages){
        if (pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0)
            return true;
        pages = pages.stream().sorted().collect(Collectors.toList()); // 혹시 모를 뒤에서부터 시작했을 경우
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        return !(leftPage == rightPage - 1 && leftPage > 1 && rightPage < 400);
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