package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    public static final int EXEPTIONS = -1;
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkExceptions(pobi);
            checkExceptions(crong);

            int pobiScore = getMaxScore(pobi);
            int crongScore = getMaxScore(crong);

            return getResult(pobiScore, crongScore);
        } catch (Exception error) {
            return EXEPTIONS;
        }
    }

    public static int getResult(int pobi, int crong) {
        if (pobi < crong) {
            return CRONG_WIN;
        }
        if (pobi > crong) {
            return POBI_WIN;
        }
        return DRAW;
    }

    public static int getMaxScore(List<Integer> pages) {
        List<Integer> score = new ArrayList<>();
        for (Integer page : pages) {
            score.add(Math.max(getSumValue(page), getMultiplyValue(page)));
        }

        return (Math.max(score.get(0), score.get(1)));
    }

    public static int getSumValue(Integer number) {
        return Stream.of(number.toString().split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }

    public static int getMultiplyValue(Integer number) {
        return Stream.of(number.toString().split(""))
            .mapToInt(Integer::parseInt)
            .reduce(1, (a, b) -> a * b);
    }

    public static void checkExceptions(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int subtractPages = rightPage - leftPage;

        if ((subtractPages != 1) || (leftPage % 2 != 1)) {
            throw new IllegalArgumentException();
        }
    }
}