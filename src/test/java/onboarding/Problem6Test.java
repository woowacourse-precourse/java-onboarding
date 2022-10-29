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

}