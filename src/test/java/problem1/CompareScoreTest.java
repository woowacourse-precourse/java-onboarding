package problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareScoreTest {

    @Test
    @DisplayName("포비가 더 큰 경우")
    void compareAsPobiIsWinner() {
        CompareScore compareScore = new CompareScore();
        assertEquals(1, compareScore.compare(100, 95));
    }

    @Test
    @DisplayName("크롱이 더 큰 경우")
    void compareAsCrongIsWinner() {
        CompareScore compareScore = new CompareScore();
        assertEquals(2, compareScore.compare(95, 100));
    }

    @Test
    @DisplayName("무승부인 경우")
    void compareAsDraw() {
        CompareScore compareScore = new CompareScore();
        assertEquals(0, compareScore.compare(5, 5));
    }
}