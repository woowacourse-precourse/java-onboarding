package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isOpenCover(pobi) || isOpenCover(crong)) {
            return Result.EXCEPTION.number;
        }

        if (!(isOpenPageCorrect(pobi) && isOpenPageCorrect(pobi))) {
            return Result.EXCEPTION.number;
        }
    }

    private static boolean isOpenPageCorrect(List<Integer> openPages) {
        int leftPage = openPages.get(PageDirection.LEFT.index);
        int rightPage = openPages.get(PageDirection.RIGHT.index);
        return (rightPage - leftPage) == 1;
    }

    private static boolean isOpenCover(List<Integer> openPages) {
        if (openPages.get(PageDirection.LEFT.index) == 400) {
            return true;
        }

        if (openPages.get(PageDirection.RIGHT.index) == 1) {
            return true;
        }

        return false;
    }

    private enum PageDirection {
        LEFT(0),
        RIGHT(1);

        private final int index;

        PageDirection(int index) {
            this.index = index;
        }
    }

    private enum Result {
        POBI(1),
        CRONG(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int number;

        Result(int number) {
            this.number = number;
        }
    }
}
