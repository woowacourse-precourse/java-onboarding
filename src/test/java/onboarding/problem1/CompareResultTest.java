package onboarding.problem1;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompareResultTest {
    private CompareResult compareResult = new CompareResult();

    @Test
    void 에러_케이스_생성() {
        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(21, 23)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(-1, 0)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(3, 3)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(399, 400)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(10, 9)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            compareResult.compare(new Player(Arrays.asList(401, 403)), new Player(Arrays.asList(24, 25)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_경우() {
        assertThat(
                compareResult.compare(new Player(Arrays.asList(123, 124)), new Player(Arrays.asList(125, 126)))
        ).isEqualTo(2);

        assertThat(
                compareResult.compare(new Player(Arrays.asList(3, 4)), new Player(Arrays.asList(5, 6)))).isEqualTo(2);

    }

}