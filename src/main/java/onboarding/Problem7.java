package onboarding;

import problem7.FriendDto;
import problem7.RecommendationDto;
import problem7.Timeline;
import problem7.User;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User mainUser = new User(user, new Timeline(visitors));
        HashMap<String, Integer> connection = new HashMap<>();
        List<List<String>> friendList = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();
        boolean[] isFriend = new boolean[10000];
        FriendDto friendDto = new FriendDto(connection, friendList);
        int cnt = 0;

        cnt = mainUser.addFriends(friends, friendDto, cnt);
        mainUser.checkHaveSameFriends(friendDto, isFriend, score);
        mainUser.checkTimeline(friendDto,score, cnt);
        return mainUser.getRecommendations(new RecommendationDto(score, connection, isFriend));
    }
}
