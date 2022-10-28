package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // user의 direct friend 구하기
        HashSet<String> directFriends = new HashSet<String>();
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                // add friend
                for(String friendName: friendList){
                    if(friendName != user){
                        directFriends.add(friendName);
                    }
                }
            }
        }

        // user의 mutual friend 구하기
        HashSet<String> mutualFriends = new HashSet<>();
        for(String directFriend: directFriends){
            for(List<String> friendList: friends){
                for(String friendName: friendList){
                    if(friendName != directFriend && friendName != user){
                        mutualFriends.add(friendName);
                    }
                }
            }
        }
        mutualFriends.removeAll(directFriends);

        // 추천인 리스트 만들기
        HashSet<String> suggestedAccouts = new HashSet<>();
        suggestedAccouts.addAll(mutualFriends);
        suggestedAccouts.addAll(visitors);
        suggestedAccouts.removeAll(directFriends);

        System.out.println(suggestedAccouts);

        return answer;
    }

}
