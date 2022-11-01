package onboarding.P7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotFriendVisitor {

    public List<String> getvisitors(List<String> visitors, String user, List<List<String>> friends){
        FriendList friendList = new FriendList();

        return visitors.stream()
                .filter(x -> !friendList.friendsList(user, friends).contains(x))
                .collect(Collectors.toList());

    }
}
