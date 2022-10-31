package onboarding.problem7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("유저 id 기능 검증")
public class UserIdTest {
    @DisplayName("잘 작동함")
    @Test
    void case1() {
        Assertions.assertDoesNotThrow(() -> {
            new UserId("hello");
        });
    }

    @DisplayName("전체가 null")
    @Test
    void case2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserId(null);
        });
    }

    @DisplayName("길이가 0")
    @Test
    void case3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserId("");
        });
    }

    @DisplayName("소문자만으로 이루어지지 않음")
    @Test
    void case4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserId("ㅁ is not english");
        });
    }
}
