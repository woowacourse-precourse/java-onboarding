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
}