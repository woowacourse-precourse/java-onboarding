package onboarding.problem1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"3:6", "5:8"})
    void 왼쪽페이지와_오른쪽_페이지의_크기차이는_1_이여만_합니다(final String input) {
        List<Integer> numbers = getIntegers(input);
        assertThatThrownBy(() -> {
            new Player(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"3:6:9", "1", "5:7:9:11"})
    void 플레이어로부터_입력받는_리스트의_크기는_2입니다(final String input) {
        List<Integer> numbers = getIntegers(input);

        assertThatThrownBy(() -> {
            new Player(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource(value= {"3:4,4", "9:10,9"}, delimiterString = ",")
    void 플레이어는_입력받은_페이지에서_가장_큰_값을_반환합니다(final String input, final String result) {
        var numbers = getIntegers(input);

        var actual = new Player(numbers).number();
        Assertions.assertThat(actual)
                  .isEqualTo(Integer.valueOf(result));
    }

    // 입력 받은 문자열을 정수 리스트로 반환
    private List<Integer> getIntegers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(":"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        return numbers;
    }

}