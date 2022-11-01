package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem6Test {

    @Test
    void 정상적인_입력인_경우() {
        Assertions.assertThatCode(() -> Problem6.solution(List.of(List.of("jb@email.com", "진범"))))
            .doesNotThrowAnyException();
    }

    @Test
    void 크루_인원이_비정상_입력인_경우() {
        List<List<String>> forms = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> Problem6.solution(forms));

        IntStream.range(0, 10001)
            .forEach(i -> forms.add(List.of("hi@email.com", "진범")));
        Assertions.assertThatThrownBy(() -> Problem6.solution(forms));
    }

    @Test
    void 이메일이_비정상_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("@email.com", "진범"))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("eeeemail.com", "진범"))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("eee@emailcom", "진범"))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("eee@email.co", "진범"))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("eeeeeeeeeee@email.com", "진범"))));
    }

    @Test
    void 닉네임이_비정상_입력인_경우() {
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("hi@email.com", "k진범"))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("hi@email.com", ""))));
        Assertions.assertThatThrownBy(() -> Problem6.solution(List.of(List.of("hi@email.com", "가나다라마가나다라마가나다라마가나다라마"))));
    }

    @Test
    void 테스트케이스() {
        List<List<String>> forms1 = List.of(List.of("onepiece@email.com", "원피수"), List.of("jason@email.com", "제이슨"), List.of("onepisu@email.com", "원피수"), List.of("mj@email.com", "엠제이"), List.of("suonepi@email.com", "수원피"));
        Assertions.assertThat(Problem6.solution(forms1))
            .isEqualTo(List.of("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi" + "@email.com"));

        List<List<String>> forms2 = List.of(List.of("jm@email.com", "제이엠"), List.of("jason@email.com", "제이슨"), List.of("woniee@email.com", "워니"), List.of("mj@email.com", "엠제이"), List.of("nowm@email.com", "이제엠"), List.of("jasp@email.com", "박이김"), List.of("jp@email.com", "김이박"), List.of("qpw@email.com", "김이순"), List.of("teemo@email.com", "티모"), List.of("banana@email.com", "대위티모"), List.of("secondJm@email.com", "제이엠"), List.of("apple@email.com", "땷횱봵"), List.of("stran@email.com", "횱봵으"), List.of("zebra@email.com", "두글자이상의문자가연속적으로이제맞티모"));
        Assertions.assertThat(Problem6.solution(forms2))
            .isEqualTo(List.of("apple@email.com", "banana@email.com", "jason@email.com", "jm@email.com", "jp@email.com", "mj@email.com", "nowm@email.com", "qpw@email.com", "secondJm@email.com", "stran@email.com", "teemo@email.com", "zebra@email.com"));

        List<List<String>> forms3 = List.of(List.of("jm@email.com", "제이엠제이워니"), List.of("jason@email.com", "제이슨"), List.of("woniee@email.com", "워니"), List.of("mj@email.com", "엠제이"), List.of("nowm@email.com", "이워니"));
        Assertions.assertThat(Problem6.solution(forms3))
            .isEqualTo(List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com", "woniee@email.com"));

        List<List<String>> forms4 = List.of(List.of("kim@email.com", "김ㅡ이"), List.of("nam@email.com", "ㅡ이야"), List.of("choi@email.com", "최강"), List.of("lee@email.com", "강합니다"), List.of("jun@email.com", "왜ㅇㅡ이야"));
        Assertions.assertThat(Problem6.solution(forms4))
            .isEqualTo(List.of("jun@email.com", "kim@email.com", "nam@email.com"));
    }
}