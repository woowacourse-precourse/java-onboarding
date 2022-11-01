package onboarding.problem7.repository;

import java.util.List;

public interface PointRepository {

    void save(String userName, int point);
    int findFriendshipPoint(String userName);
    List<String> friendshipOrderByPointAndLimitFive(String userName);
}
