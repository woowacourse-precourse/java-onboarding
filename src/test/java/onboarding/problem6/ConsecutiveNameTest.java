package onboarding.problem6;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ConsecutiveNameTest {

    @Test
    void 문자열이_주어질_경우_해당_문자열의_연속된_문자열_집합을_만듦니다() {
        var expected = Arrays.asList("제이", "이엠", "제이엠");

        var consecutiveNames = new ConsecutiveNames("제이엠");

        var actual = consecutiveNames.names();

        System.out.println(actual);
        assertThat(actual.size()).isEqualTo(expected.size());

        // 순서는 상관 없으므로 모든 요소들이 잡합내부에 존재하면 됩니다.
        actual.forEach(s -> assertThat(expected.contains(s)).isTrue());
    }


    @Test
    void 연속된_집합과_다른_연속된_문자열_집합을_비교할때_하나라도_포함된다면_참을_반환합니다(){
        var consecutiveNames = new ConsecutiveNames("제이엠");

        var actual =  consecutiveNames.isSimilar(new ConsecutiveNames("제이제이엠"));
        assertThat(actual).isTrue();
    }
}