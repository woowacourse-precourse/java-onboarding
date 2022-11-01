package onboarding.problem7.service;

import onboarding.problem7.repository.PointRepository;
import onboarding.problem7.repository.FriendshipPointRepositoryImpl;
import onboarding.problem7.repository.UserRepository;
import onboarding.problem7.repository.UserRepositoryImpl;

import java.util.List;
import java.util.Set;

public class PointService {

    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final PointRepository pointRepository = new FriendshipPointRepositoryImpl();
    private static final int FRIEND_SHIP_POINT = 10;

    public void friendshipPointCalcul(Set<String> findFriends, String user) {
        for (String findFriend : findFriends) {
            Set<String> knowRelationShip = userRepository.findFriends(findFriend);
            int knowRelationShipCount = knowRelationShip.size();

            if (knowRelationShip.contains(user)) {
                knowRelationShipCount = knowRelationShip.size() - 1;
            }

            int resultRelationPoint = knowRelationShipCount * FRIEND_SHIP_POINT;

            for (String knowUser : knowRelationShip) {

                if (knowUser.equals(user)) {
                    continue;
                }

                // 그게 아니라면 사용자와 친구추천 포인트를 담을 friendPoints 에 저장한다.
                pointRepository.save(knowUser, resultRelationPoint);
            }
        }
    }

    public void visitorPointCalcul(List<String> visitors) {
        for (String visitor : visitors) {

            pointRepository.save(visitor, pointRepository.findFriendshipPoint(visitor) + 1);
        }
    }

    public List<String> getFriendshipList(String userName) {
        return pointRepository.friendshipOrderByPointAndLimitFive(userName);
    }
}
