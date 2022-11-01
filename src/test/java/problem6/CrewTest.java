package problem6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrewTest {

    @Test
    void 크루의_닉네임중복_발생여부_확인() {
        Crew crew1 = new Crew(List.of("jm@email.com", "제이엠"));
        Crew crew2 = new Crew(List.of("jason@email.com", "제이슨"));
        Crew crew3 = new Crew(List.of("nowm@email.com", "이제엠"));

        boolean result1 = crew1.isDuplicateNickname(crew2);
        boolean result2 = crew1.isDuplicateNickname(crew3);
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}
