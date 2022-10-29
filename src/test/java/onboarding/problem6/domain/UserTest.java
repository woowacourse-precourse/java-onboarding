package onboarding.problem6.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private Map<UserName, UserEmail> map;
    
    @BeforeEach
    void setUp() {
        user = new User("준혁", "tjdtls690@email.com");
        map = new HashMap<>();
        map.put(new UserName("준혁"), new UserEmail("abc@email.com"));
    }
    
    @Test
    @DisplayName("두 글자 닉네임이 중복된 것인지 확인하기")
    void isInADuplicateAccountEmail() {
        assertThat(user.isInADuplicateAccountEmail(map)).isTrue();
    }
    
    @Test
    @DisplayName("중복된 계정의 이메일 가져오기")
    void findDuplicateAccountEmail() {
        assertThat(user.findDuplicateAccountEmail(map)).isEqualTo(new UserEmail("abc@email.com"));
    }
}