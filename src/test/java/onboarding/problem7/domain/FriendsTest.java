package onboarding.problem7.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FriendsTest {
    @Test
    @DisplayName("유저의 친구목록 저장하기")
    void addFriend() {
        Friends friends = new Friends();
        friends.add("pobi");
        
        assertThat(friends).isEqualTo(new Friends(Set.of("pobi")));
    }
    
    @Test
    @DisplayName("함계 아는 친구 명수 구하기")
    void numberOfFriendsYouKnowTogether() {
        Friends jun = new Friends();
        Friends pobi = new Friends();
        
        jun.add("jk");
        jun.add("crong");
        pobi.add("jk");
        pobi.add("crong");
        
        assertThat(jun.numberOfFriendsYouKnowTogether(pobi)).isEqualTo(2);
    }
}