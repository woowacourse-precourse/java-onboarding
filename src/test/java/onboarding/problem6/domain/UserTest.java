package onboarding.problem6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("서로의 객체가 같은지 확인")
    void isSameUser() {
        User sjh = new User("신준혁", "tjdtls690@email.com");
        assertThat(sjh).isEqualTo(new User("신준혁", "tjdtls690@email.com"));
    }
    
    @Test
    @DisplayName("각 계정당 2글자씩 끊어서 객체 생성후 리스트로 반환")
    void twoLetterNameObjects() {
        User sjh = new User("가나다라", "tjdtls690@email.com");
        List<User> twoLetterNamesActual = sjh.twoLetterNames();
        
        final List<User> twoLetterNamesExpected =
                Arrays.asList(
                        new User("가나", "tjdtls690@email.com"),
                        new User("나다", "tjdtls690@email.com"),
                        new User("다라", "tjdtls690@email.com")
                );
        
        assertThat(twoLetterNamesActual).isEqualTo(twoLetterNamesExpected);
    }
}
