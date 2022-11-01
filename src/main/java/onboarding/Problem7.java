package onboarding;

import java.util.Collections;
import java.util.List;

import onboarding.problem7.FriendService;
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

