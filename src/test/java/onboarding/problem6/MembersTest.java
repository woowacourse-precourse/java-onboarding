package onboarding.problem6;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MembersTest {
    @Test
    void 유사한_이름을_사용하는_크루들을_반환합니다() {

        var members = new Members(
                Arrays.asList(
                        Arrays.asList("이메일1@email.com", "제이엠"),
                        Arrays.asList("이메일2@email.com", "제이슨"),
                        Arrays.asList("이메일3@email.com", "워니"),
                        Arrays.asList("이메일4@email.com", "엠제이"),
                        Arrays.asList("이메일5@email.com","이제엠")
                )
        );

        var expected = Arrays.asList("이메일1@email.com","이메일2@email.com","이메일4@email.com");
        var actual = members.findCrewsAtSimilarUserName();

        System.out.println(actual);
        assertThat(actual).hasSize(3);

        actual.forEach(crew ->{
            assertThat(expected.contains(crew.getEmail())).isTrue();
        });
    }
}
