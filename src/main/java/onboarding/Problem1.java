package onboarding;

import java.util.List;

import static onboarding.LeftRight.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Boolean isWrongFormatpobi = FindException(pobi);
        Boolean isWrongFormatcrong = FindException(crong);

        if(!isWrongFormatpobi && !isWrongFormatcrong){
            Integer pobiScore = FindScore(pobi);
            Integer crongScore = FindScore(crong);

            System.out.println("crongScore = " + crongScore);
            System.out.println("pobiScore = " + pobiScore);

            if(pobiScore > crongScore)
                answer=1;
            if(pobiScore < crongScore)
                answer=2;
            if(pobiScore == crongScore)
                answer=0;

            return answer;
        }

        answer = -1;
        return answer;
    }

    public static Integer sumDigit(Integer page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static Integer multiplyDigit(Integer page) {
        int multiply = 1;
        while (page > 0) {
            multiply *= page % 10;
            page /= 10;
        }
        return multiply;
    }

    public static Boolean isInRange(List<Integer> pages) {

        if (pages.get(LEFT.ordinal()) - pages.get(RIGHT.ordinal()) == -1)
            return true;
        return false;
    }

    public static Boolean isOdd(Integer page) {
        if (page % 2 == 1)
            return true;
        return false;
    }

    public static Boolean isEven(Integer page) {
        if (page % 2 == 0)
            return true;
        return false;
    }

    public static Boolean isNotStartOrEnd(List<Integer> pages) {
        if (pages.get(LEFT.ordinal()) == 1)
            return false;
        if (pages.get(RIGHT.ordinal()) == 400)
            return false;

        return true;
    }

    public static Integer FindScore(List<Integer> pages) {
        int LeftScore = Math.max(
                sumDigit(pages.get(LEFT.ordinal())),
                multiplyDigit(pages.get(LEFT.ordinal()))
        );

        int RightScore = Math.max(
                sumDigit(pages.get(RIGHT.ordinal())),
                multiplyDigit(pages.get(RIGHT.ordinal()))
        );

        return Math.max(LeftScore, RightScore);
    }

    public static Boolean FindException(List<Integer> pages) {

        if (isInRange(pages) &&
                isOdd(pages.get(LEFT.ordinal())) &&
                isEven(pages.get(RIGHT.ordinal())) &&
                isNotStartOrEnd(pages))
            return false;

        return true;
    }
}