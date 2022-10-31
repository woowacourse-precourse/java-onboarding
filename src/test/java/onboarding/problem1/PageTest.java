package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PageTest {

    @Test
    void 배열을_입력받아_페이지의_왼쪽_오른쪽으로_지정() throws Exception {
        List<Integer> input = List.of(21,22);
        Page page = new Page(input);

        Integer leftPage = page.getLeftPage();
        Integer rightPage = page.getRightPage();

        assertThat(leftPage).isEqualTo(21);
        assertThat(rightPage).isEqualTo(22);
    }

    @Test
    void 입력된_배열의_길이가_2보다_큰_경우_예외_발생() throws Exception {
        List<Integer> input = List.of(21,22,23);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 왼쪽_페이지가_홀수가_아니면_예외발생() throws Exception {
        List<Integer> input = List.of(22,23);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오른쪽_페이지가_짝수가_아니면_예외발생() throws Exception {
        List<Integer> input = List.of(21,23);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오른쪽_페이지는_왼쪽_페이지보다_1_만큼_크지않다면_예외발생() throws Exception {
        List<Integer> input = List.of(21,24);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 왼쪽페이지에_null_입력시_예외발생() throws Exception {
        List<Integer> input = new ArrayList<>();
        input.add(null);
        input.add(54);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오른쪽페이지에_null_입력시_예외발생() throws Exception {
        List<Integer> input = new ArrayList<>();
        input.add(53);
        input.add(null);

        assertThatThrownBy(() -> {
            new Page(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 왼쪽페이지는_1부터_399까지의_숫자중_홀수만_입력_예외발생없음(List<Integer> input) throws Exception {
        new Page(input);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 오른쪽페이지는_2부터_400까지의_숫자중_짝수만_입력_예외발생없음(List<Integer> input) throws Exception {
        new Page(input);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(List.of(1, 2)),
            Arguments.of(List.of(399, 400))
        );
    }
}