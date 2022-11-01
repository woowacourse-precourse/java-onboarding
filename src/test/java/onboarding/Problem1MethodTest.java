package onboarding;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1MethodTest {

    @Test
    void getDigitsFromNumberTest() {
        Problem1 problem1 = new Problem1();
        try {
            Method getDigitsFromNumber = problem1.getClass().getDeclaredMethod("getDigitsFromNumber", int.class);
            getDigitsFromNumber.setAccessible(true);

            int number = 15223442;
            List<Integer> digits = (List<Integer>) getDigitsFromNumber.invoke(problem1, number);
            assertThat(digits).isEqualTo(List.of(2, 4, 4, 3, 2, 2, 5, 1));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMaxScoreTest() {
        Problem1 problem1 = new Problem1();
        try {
            Method getMaxScore = problem1.getClass().getDeclaredMethod("getMaxScore", List.class);
            getMaxScore.setAccessible(true);

            List<Integer> digits1 = List.of(1, 9, 7);
            List<Integer> digits2 = List.of(2, 1, 1);
            int maxScore1 = (int) getMaxScore.invoke(problem1, digits1);
            int maxScore2 = (int) getMaxScore.invoke(problem1, digits2);
            assertThat(maxScore1).isEqualTo(63);
            assertThat(maxScore2).isEqualTo(4);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void startGameTest() {
        Problem1 problem1 = new Problem1();
        try {
            Method startGame = problem1.getClass().getDeclaredMethod("startGame", int.class, int.class);
            startGame.setAccessible(true);

            assertThat((Problem1.Result) startGame.invoke(problem1, 5, 0)).isEqualTo(Problem1.Result.POBI_WIN);
            assertThat((Problem1.Result) startGame.invoke(problem1, 0, 5)).isEqualTo(Problem1.Result.CRONG_WIN);
            assertThat((Problem1.Result) startGame.invoke(problem1, 5, 5)).isEqualTo(Problem1.Result.DRAW);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
