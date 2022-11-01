package onboarding.problem7.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendshipPointRepositoryImpl implements PointRepository {

    private static Map<String, Integer> friendPoints = new LinkedHashMap<>();
    private static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void save(String userName, int point) {
        friendPoints.put(userName, point);
    }

    @Override
    public int findFriendshipPoint(String userName) {
        return friendPoints.getOrDefault(userName, 0);
    }

    @Override
    public List<String> friendshipOrderByPointAndLimitFive(String userName) {
        return friendPoints.entrySet().stream()
                .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
                .map(Map.Entry::getKey)
                .filter(s -> !userRepository.findFriends(userName).contains(s))
                .limit(5)
                .collect(Collectors.toList());
    }
}
