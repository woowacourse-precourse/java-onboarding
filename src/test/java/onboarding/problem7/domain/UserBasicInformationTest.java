package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserBasicInformationTest {
    private UserBasicInformation jun;
    
    @BeforeEach
    void setUp() {
        jun = new UserBasicInformation("jun");
    }
    
    @Test
    @DisplayName("스코어, 유저 이름 비교")
    void compareTo() {
        final UserBasicInformation jun = new UserBasicInformation("jun");
        final UserBasicInformation pobi = new UserBasicInformation("pobi");
        
        assertAll(
                () -> assertThat(jun.compareTo(pobi) < 0).isTrue(),
                pobi::scoreIncrease,
                () -> assertThat(jun.compareTo(pobi) > 0).isTrue()
        );
    }
    
    @Test
    void isScoreNotZero() {
        assertThat(jun.isScoreNotZero()).isFalse();
    }
}