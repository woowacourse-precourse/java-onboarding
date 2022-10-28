package onboarding;

import java.util.List;

class Problem1 {

    private static int plusNumber(int pageNumber){
        int result = 0;

        result += pageNumber / 100;
        pageNumber %= 100;
        result += pageNumber / 10;
        pageNumber %= 10;
        result += pageNumber;

        return result;
    }

    private static int multiplyNumber(int pageNumber){
        int result = 1;

        if(pageNumber / 100 != 0){
            result *= pageNumber / 100;
            pageNumber %= 100;
        }
        if(pageNumber / 10 != 0) {
            result *= pageNumber / 10;
            pageNumber %= 10;
        }
        if(pageNumber != 0){
            result *= pageNumber;
        }

        return result;
    }

    private static boolean handleException(List<Integer> pages){
        if(pages.get(0) <= 1 || pages.get(1) >= 400)
            return true;
        if(pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1)
            return true;
        if(pages.get(0) + 1 != pages.get(1))
            return true;

        return false;
    }

    private static int getPoint(List<Integer> pages){
        int point = 0;

        point = plusNumber(pages.get(0)) > point ? plusNumber(pages.get(0)) : point;
        point = plusNumber(pages.get(1)) > point ? plusNumber(pages.get(1)) : point;
        point = multiplyNumber(pages.get(0)) > point ? multiplyNumber(pages.get(0)) : point;
        point = multiplyNumber(pages.get(1)) > point ? multiplyNumber(pages.get(1)) : point;

        return point;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}