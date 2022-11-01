package onboarding;

import static onboarding.problem7.Problem7Constant.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import onboarding.problem7.FriendService;
import onboarding.problem7.User;
import onboarding.problem7.UserRepository;
import onboarding.problem7.dto.FriendRelationDto;

public class Problem7 {
    private static FriendService friendService = new FriendService();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for (List<String> friendRelation : friends) {
            FriendRelationDto friendRelationDto = new FriendRelationDto(friendRelation);
            friendService.addFriend(friendRelationDto);
        }

        answer = friendService.getRecommendFriendOf(user, visitors);

        return answer;
    }
}

