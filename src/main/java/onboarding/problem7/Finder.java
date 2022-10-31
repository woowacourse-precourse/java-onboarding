package onboarding.problem7;

import java.util.List;

public interface Finder {

    List<String> findNewFriendsFromUserFriends(String user, List<List<String>> friends);

    List<String> findNewFriendsFromVisitRecord(String user, List<List<String>> friends, List<String> visitors);
}
