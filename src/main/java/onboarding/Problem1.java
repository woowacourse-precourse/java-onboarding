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

    private static int getResult(int point1, int point2){
        if(point1 == point2)
            return 0;
        else if(point1 > point2)
            return 1;
        else
            return 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pointPobi, pointCrong;

        if(handleException(pobi) || handleException(crong))
            return -1;

        pointPobi = getPoint(pobi);
        pointCrong = getPoint(crong);

        return getResult(pointPobi, pointCrong);
    }
}