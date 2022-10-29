package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void returnFriendName() {

        List<String> friend = List.of("donut", "andole");

        String result1 = Problem7.returnFriendName(friend, "andole");
        assertThat(result1).isEqualTo("donut");

        String result2 = Problem7.returnFriendName(friend, "donut");
        assertThat(result2).isEqualTo("andole");
    }
}