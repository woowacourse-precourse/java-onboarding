package onboarding.problem1;

import java.util.List;

public class BookScoreComparator {

    private static final int PLAYER1_WIN = 1;
    private static final int PLAYER2_WIN = 2;
    private static final int DRAW = 0;

    public int compare(List<Integer> book1, List<Integer> book2){

        BookPage player1Book = new BookPage(book1);
        BookPage player2Book = new BookPage(book2);

        int player1Score = BookScoreCalculator.score(player1Book);
        int player2Score = BookScoreCalculator.score(player2Book);

        if (player1Score > player2Score) return PLAYER1_WIN;
        if (player1Score < player2Score) return PLAYER2_WIN;
        return DRAW;
    }
}
