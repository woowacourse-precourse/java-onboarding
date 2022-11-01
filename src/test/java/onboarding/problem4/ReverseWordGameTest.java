package onboarding.problem4;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseWordGameTest {
    @Test
    void if_under_MIN() {
        assertThrows(ReverseException.class, () -> ReverseWordGame.start(" "));
    }

    @Test
    void if_over_MAX() {
        String test = IntStream.range(0, 1004).mapToObj(String::valueOf).collect(Collectors.joining());
        assertThrows(ReverseException.class, () -> ReverseWordGame.start(test));
    }

    @Test
    void not_revers_if_not_english_letter() {
        String test = "123!ㄱ";
        assertEquals(ReverseWordGame.start("123!ㄱ"), test);
    }
}
