package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FriendsTest {
    private Friends jun;
    
    @BeforeEach
    void setUp() {
        jun = new Friends();
    }
    
    @Test
    @DisplayName("유저의 친구목록 저장하기")
    void addFriend() {
        jun.add("pobi");
        assertThat(jun.friends()).isEqualTo(Set.of("pobi"));
    }
    
    @Test
    @DisplayName("함계 아는 친구 명수 구하기")
    void numberOfFriendsYouKnowTogether() {
        Friends pobi = new Friends();
        
        jun.add("jk");
        jun.add("crong");
        pobi.add("jk");
        pobi.add("crong");
        
        assertThat(jun.numberOfFriendsYouKnowTogether(pobi)).isEqualTo(2);
    }
    
    @Test
    @DisplayName("친구인지 확인")
    void contains() {
        jun.add("pobi");
        assertAll(
                () -> assertThat(jun.contains("pobi")).isTrue(),
                () -> assertThat(jun.contains("jk")).isFalse()
        );
    }
}