package onboarding.problem7;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendRecommender {
    private FriendGroupRepository friendGroupRepository = new FriendGroupRepository();
    private TimelineRepository timelineRepository = new TimelineRepository();
    private UserRepository userRepository = new UserRepository();

    public FriendRecommender(List<List<String>> friendGroup){
        for(List<String> friend : friendGroup){
            String userA = friend.get(0);
            String userB = friend.get(1);

            userRepository.addUserIfNotExist(userA);
            userRepository.addUserIfNotExist(userB);

            FriendGroup friendGroupOfA = friendGroupRepository.getFriendGroupOfUser(userA);
            FriendGroup friendGroupOfB = friendGroupRepository.getFriendGroupOfUser(userB);

            friendGroupOfA.addFriendIfNotExist(userB);
            friendGroupOfB.addFriendIfNotExist(userA);
        }
    }

    public List<String> recommendUser(String clientId, List<String> visitors){
        FriendGroup clientFriendGroup = friendGroupRepository.getFriendGroupOfUser(clientId);
        Timeline clientTimeline = timelineRepository.getTimelineOfUser(clientId);

        for(String visitor : visitors){
            userRepository.addUserIfNotExist(visitor);
            clientTimeline.addTimelineVisitInfo(visitor);
        }

        List<String> candidates = new ArrayList<>(userRepository.getUserGroup()).stream()
            .filter((userId) -> (userId != clientId && !clientFriendGroup.isFriendWith(userId)))
            .collect(Collectors.toList());

        Map<String, Integer> scoreBoard = new HashMap<>();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String userA, String userB) {
                if(scoreBoard.get(userA) != scoreBoard.get(userB)){
                    return scoreBoard.get(userB) - scoreBoard.get(userA);
                }
                return userA.compareTo(userB);
            }
        };
        for(String candidate : candidates){
            int score = 0;
            score += 10 * clientFriendGroup.getNumberOfCommonFriends(friendGroupRepository.getFriendGroupOfUser(candidate));
            score += clientTimeline.getTimelineVisitTime(candidate);
            scoreBoard.put(candidate, score);
        }

        Collections.sort(candidates, comparator);

        return candidates.subList(0, Math.min(5, candidates.size()));
    }


}
