package onboarding.problem7;

import java.util.ArrayList;
import java.util.Arrays;
import onboarding.problem1.problem7.UserConnection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserConnectionTest {
    @Test
    @DisplayName("CRUD TEST")
    void validateUserConnection(){
        UserConnection connection = new UserConnection();
        connection.connectNewFriendship(new ArrayList<>(Arrays.asList("1","2")));
        connection.connectNewFriendship(new ArrayList<>(Arrays.asList("2","3")));
        connection.connectNewFriendship(new ArrayList<>(Arrays.asList("1","3")));
        connection.connectNewFriendship(new ArrayList<>(Arrays.asList("4","3")));
        connection.connectNewFriendship(new ArrayList<>(Arrays.asList("4","2")));

        Assertions.assertThat(connection.isFriendWith("1","2")).isEqualTo(true);
        Assertions.assertThat(connection.isFriendWith("3","2")).isEqualTo(true);
        Assertions.assertThat(connection.isFriendWith("3","1")).isEqualTo(true);
        Assertions.assertThat(connection.isFriendWith("1","4")).isEqualTo(false);

        Assertions.assertThat(connection.getNumberOfCommonFriends("1","4")).isEqualTo(2);
        //System.out.println("connection.getUserGroup().toString() = " + connection.getUserGroup().toString());
    }

}
