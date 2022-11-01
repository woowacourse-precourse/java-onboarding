package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class test {
    @Test
    void case7() {
        List<Integer> pobi = List.of(412, 413);
        List<Integer> crong = List.of(200, 201);
        int result = -1;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }
}
