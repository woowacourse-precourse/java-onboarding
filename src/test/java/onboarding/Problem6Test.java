package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    @Test
    public void getNickNamesFromFormsTest() {
        //given
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        //when
        List<String> nickNameFromForms = Problem6.getNickNamesFromForms(forms);

        //then
        assertThat(nickNameFromForms.size()).isEqualTo(5);
        assertThat(nickNameFromForms).containsExactly("제이엠", "제이슨", "워니", "엠제이", "이제엠");
    }
}