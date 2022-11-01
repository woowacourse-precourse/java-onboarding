package onboarding.problem3;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameRecordTest {

    @Test
    void 게임_기록이_정상적으로_더해진다() {
        var actual = GameRecord.generateEmptyCount()
                               .plus(3)
                               .plus(3);
        assertThat(actual.count())
                .isEqualTo(6);
    }

    @Test
    void 게임_기록에_0을_더해도_된다() {
        assertThat(
                GameRecord.generateEmptyCount()
                          .plus(0)
                          .count()
        ).isEqualTo(0);
    }
}