package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserTest {
    private User jun;
    
    @BeforeEach
    void setUp() {
        jun = new User("jun");
    }
    
    @Test
    @DisplayName("함계 아는 친구 명수 구하기")
    void numberOfFriendsYouKnowTogether() {
        User pobi = new User("pobi");
        
        jun.addFriend("jk");
        jun.addFriend("crong");
        pobi.addFriend("jk");
        pobi.addFriend("crong");
        
        assertThat(jun.numberOfFriendsYouKnowTogether(pobi)).isEqualTo(2);
    }
    
    @Test
    @DisplayName("0이 아닌지 확인")
    void isNotZero() {
        assertThat(jun.isNotZeroScore()).isFalse();
    }
    
    @Test
    @DisplayName("친구인지 확인")
    void friendsContains() {
        jun.addFriend("pobi");
        assertAll(
                () -> assertThat(jun.friendsContains("pobi")).isTrue(),
                () -> assertThat(jun.friendsContains("jk")).isFalse()
        );
    }
}
