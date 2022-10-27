package onboarding.problem1.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static onboarding.problem1.constance.Constance.*;

public class PageNumberGame {
    public static int winnerUser(int userScore1, int userScore2) {
        if (userScore1 > userScore2) {
            return WINNER_USER1_MESSAGE;
        } else if (userScore1 < userScore2) {
            return WINNER_USER2_MESSAGE;
        }
        return SCORE_SAME_MESSAGE;
    }

    public static int saveMaxPageNumberByUser(List<Integer> user) {
        List<Integer> maxPageNumbers = new ArrayList<>();
        for (Integer pageNumber : user) {
            int sumPage = sumEachNumber(pageNumber);
            int multPage = multEachNumber(pageNumber);
            maxPageNumbers.add(Math.max(sumPage, multPage));
        }

        return Math.max(maxPageNumbers.get(0), maxPageNumbers.get(1));
    }

    private static int sumEachNumber(int pageNumber) {
        List<Integer> pageNumberList = toList(String.valueOf(pageNumber));
        return pageNumberList.stream().reduce(0, Integer::sum);
    }

    private static int multEachNumber(int pageNumber) {
        List<Integer> pageNumberList = toList(String.valueOf(pageNumber));
        return pageNumberList.stream().reduce(1, (a, b) -> a * b);
    }

    private static List<Integer> toList(String pageNumber) {
        int[] eachPageNumbers = Stream.of(pageNumber.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(eachPageNumbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
