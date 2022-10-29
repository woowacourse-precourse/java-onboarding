package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void makeDict() {

        Map<String, String> result = Problem4.makeDict();

        System.out.println(result);
    }

    @Test
    void transform() {
        String result = Problem4.transform("I lo?ve you!!");

        assertThat(result).isEqualTo("R ol?ev blf!!");
    }

    @Test
    void exception() {

        assertThatThrownBy(() -> Problem4.solution(""))
                .isInstanceOf(RuntimeException.class);
    }
}