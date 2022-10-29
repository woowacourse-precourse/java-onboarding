package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

class Problem2Test {
    @Test
    void StringToCharsTest() {
        List<Character> chars = Problem2.StringToChars("hello");
        chars.forEach(c -> System.out.print(c + " "));
    }

    @Test
    void CharsToStringTest() {
        List<Character> chars = Problem2.StringToChars("hello");
        String string = Problem2.CharsToString(chars);
        System.out.println("string = " + string);
    }
}