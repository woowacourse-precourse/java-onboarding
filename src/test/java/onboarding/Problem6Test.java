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

    @Test
    public void getEmailsFromFormsTest() {
        //given
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        //when
        List<String> getEmailsFromFroms = Problem6.getEmailsFromForms(forms);

        //then
        assertThat(getEmailsFromFroms.size()).isEqualTo(5);
        assertThat(getEmailsFromFroms).containsExactly("jm@email.com", "jason@email.com", "woniee@email.com", "mj@email.com", "nowm@email.com");
    }

    @Test
    void case1() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "리에제이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }
}