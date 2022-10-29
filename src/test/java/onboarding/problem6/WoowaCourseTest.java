package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Lists;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WoowaCourseTest {
    @Test
    void 우아한_코스_내_구성원들_중_유사한_닉네임을_가진_사람들의_이메일을_오름차순으로_가져와주세요(){
        var woowacourse = new WoowaCourse(
                new Members(List.of(
                        List.of("jm@email.com", "제이엠"),
                        List.of("jason@email.com", "제이슨"),
                        List.of("woniee@email.com", "워니"),
                        List.of("mj@email.com", "엠제이"),
                        List.of("nowm@email.com", "이제엠")
                ))
        );

        var actual = woowacourse.findEmailsAtSimilarUserName();
        var expected = List.of("jason@email.com", "jm@email.com", "mj@email.com");

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 모든_사용자_이메일이_포함되고_중복된_이메일을_제거함(){
        var woowacourse = new WoowaCourse(
                new Members(List.of(
                        List.of("a@email.com","제이엠제이슨워니엠제이이제엠"),
                        List.of("e@email.com", "제이엠"),
                        List.of("d@email.com", "제이슨"),
                        List.of("c@email.com", "워니"),
                        List.of("b@email.com", "엠제이"),
                        List.of("a@email.com", "이제엠")
                ))
        );

        var actual = woowacourse.findEmailsAtSimilarUserName();
        var expected = List.of("a@email.com", "b@email.com", "c@email.com", "d@email.com", "e@email.com");

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}