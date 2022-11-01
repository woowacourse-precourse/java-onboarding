package onboarding;

import onboarding.pkgProblem7.service.RecommendFriendService;

import java.util.*;

/**
 * 추천 점수에 따라 사용자에게 친구를 추천해주는 문제
 * @author 유지웅
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendFriendService recService = new RecommendFriendService();

        HashMap<String,ArrayList<String>> organizeFriends = recService.organizeFriends(friends);
        ArrayList<String> getUserFriends = organizeFriends.get(user);
        HashMap<String,Integer> recommendScore =
                recService.addFriendsScore(user,getUserFriends,organizeFriends);
        recService.addVisitorScore(visitors,getUserFriends,recommendScore);
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(recommendScore.entrySet());
        recService.sortByNameScore(list_entries);

        return recService.getRecommendFriends(list_entries);
    }
}
