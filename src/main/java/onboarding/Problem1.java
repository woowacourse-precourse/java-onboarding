package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (Stream.of(pobi, crong).map(Problem1::valid).anyMatch(e -> e == false))
            return GameResult.EXCEPTION;

        int pobiMaxScore = getMaxScore(pobi);
        int crongMaxScore = getMaxScore(crong);
        return getGameResult(pobiMaxScore, crongMaxScore);
    }

    private static boolean valid(List<Integer> list) {
        return inputValid(list) && !containBeginPageOrEndPage(list);
    }

    private static boolean inputValid(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if (!(leftPage % 2 == 1 && rightPage % 2 == 0))
            return false;
        if (!(leftPage + 1 == rightPage))
            return false;
        return true;
    }

    private static boolean containBeginPageOrEndPage(List<Integer> list) {
        if (list.contains(1))
            return true;
        if (list.contains(400))
            return true;
        return false;
    }

    private static int getMaxScore(List<Integer> list) {
        return list.stream()
                .map(e -> Integer.max(sumPlaceValue(e), multiplyPlaceValue(e)))
                .max(Integer::compareTo)
                .orElse(0);
    }

    private static int sumPlaceValue(Integer number) {
        return Stream.of(number.toString().split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static int multiplyPlaceValue(Integer number) {
        return Stream.of(number.toString().split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }

    private static int getGameResult(int score1, int score2) {
        if (score1 > score2)
            return GameResult.POBIWIN;
        if (score1 < score2)
            return GameResult.CRONGWIN;
        return GameResult.DRAW;
    }

    interface GameResult{
        int POBIWIN = 1;
        int CRONGWIN = 2;
        int DRAW = 0;
        int EXCEPTION = -1;
    }
}