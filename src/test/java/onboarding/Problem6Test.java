package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Problem6Test {
    @Test
    void case1() {
        List<List<String>> forms = List.of(
                List.of("kim@email.com", "김크루"),
                List.of("jang@email.com", "장김크수"),
                List.of("woo00@email.com", "나는야개발자의차은우"),
                List.of("park@email.com", "박개발자"),
                List.of("error@email.com", "에러싫어요"),
                List.of("like@email.com", "좋아요에러"),
                List.of("nomad@email.com", "디지털노마드")
        );
        List<String> result = List.of(
                "error@email.com",
                "jang@email.com",
                "kim@email.com",
                "like@email.com",
                "park@email.com",
                "woo00@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    @DisplayName("email.com 도메인이 아님")
    void case2() {
        List<List<String>> forms = List.of(
                List.of("kim@naver.com", "김크루")
        );
        assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
    }

    @Test
    @DisplayName("이메일 길이 제한 초과")
    void case3() {
        List<List<String>> forms = List.of(
                List.of("kim11111111111@email.com", "김크루")
        );
        assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
    }

    @Test
    @DisplayName("닉네임 영어")
    void case4() {
        List<List<String>> forms = List.of(
                List.of("hello@email.com", "hello")
        );
        assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
    }

    @Test
    @DisplayName("닉네임 길이 제한 초과")
    void case5() {
        List<List<String>> forms = List.of(
                List.of("kim@email.com", "김수한무거북이와두루미삼천갑자동방삭치치카포사리사리센타")
        );
        assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
    }
}
