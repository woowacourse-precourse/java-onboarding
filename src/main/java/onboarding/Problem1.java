package onboarding;

import org.assertj.core.error.ShouldBeFalse;

import java.util.List;

class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ( !verifyException(pobi) || !verifyException(crong)) {
            return -1;
        }

        int pobiScore = getMaxNumber(pobi);
        int crongScore = getMaxNumber(crong);

        return getWinner(pobiScore, crongScore);
    }

    private static int getWinner(int pobiScore, int crongScore) {
       if (pobiScore > crongScore) {
           return 1;
       }
       if (pobiScore < crongScore) {
           return 2;
       }
       return 0;
    }

    private static int getMaxNumber(List<Integer> someone) {
        Integer left = calculateNumber(someone.get(LEFT));
        Integer right = calculateNumber(someone.get(RIGHT));

        return (Math.max(left, right));
    }

    private static int calculateNumber(Integer page) {
        int getSum = addNumber(page);
        int getMul = mulNumber(page);

        return (Math.max(getSum, getMul));
    }

    private static int addNumber(Integer page) {
        int result = 0;

        if (page < 10) {
            return page;
        }
        while(page != 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    private static int mulNumber(Integer page) {
        int result = 1;

        if (page < 10) {
            return page;
        }
        while(page != 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;

    }

    private static boolean verifyException(List<Integer> someone) {
        if (!checkSize(someone))
            return false;
        if (!isInRange(someone))
            return false;
        if (!isContinuous(someone))
            return false;
        if (!isOddNumber(someone.get(LEFT)) && !isEvenNumber(someone.get(RIGHT)))
            return false;
        return true;
    }

    private static boolean checkSize(List<Integer> someone) {
        if (someone == null)
            System.out.println("null");
        return (someone != null && someone.size() == 2);
    }

    private static boolean isInRange(List<Integer> someone) {
        return (someone.get(LEFT) >= 1 && someone.get(LEFT) <= 399 && someone.get(RIGHT) >= 2 && someone.get(RIGHT) <= 400);
    }

    private static boolean isContinuous(List<Integer> someone) {
        return (someone.get(LEFT) + 1 == someone.get(RIGHT));
    }

    private static boolean isOddNumber(Integer page) {
        return (page % 2 == 1);
    }

    private static boolean isEvenNumber(Integer page) {
        return (page % 2 == 0);
    }
}