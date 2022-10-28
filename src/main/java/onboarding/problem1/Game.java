package onboarding.problem1;

import java.util.List;

public class Game {
    private int getSumOfDigits(int number) {
        int sumOfDigits = 0;

        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits;
    }

    private int getMultipleOfDigits(int number) {
        int multipleOfDigits = 1;

        while (number > 0) {
            multipleOfDigits *= number % 10;
            number /= 10;
        }

        return multipleOfDigits;
    }

    private int getScore(Pages pages) {
        int score = Integer.MIN_VALUE;

        score = Math.max(score, Math.max(
                getSumOfDigits(pages.getPage1()), getMultipleOfDigits(pages.getPage1())
        ));

        score = Math.max(score, Math.max(
                getSumOfDigits(pages.getPage2()), getMultipleOfDigits(pages.getPage2())
        ));

        return score;
    }

    public Result play(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPages = new Pages(pobi.get(0), pobi.get(1));
            Pages crongPages = new Pages(crong.get(0), crong.get(1));

            int pobiScore = getScore(pobiPages);
            int crongScore = getScore(crongPages);

            if(pobiScore > crongScore) {
                return Result.POBI_WIN;
            } else if(pobiScore < crongScore) {
                return Result.CRONG_WIN;
            } else {
                return Result.DRAW;
            }
        } catch (IllegalArgumentException exception) {
            return Result.EXCEPTION;
        }
    }
}
