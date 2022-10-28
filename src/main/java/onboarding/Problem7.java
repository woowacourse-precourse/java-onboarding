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
        HashSet<String> suggestedAccounts = new HashSet<>();
        suggestedAccounts.addAll(mutualFriends);
        suggestedAccounts.addAll(visitors);
        suggestedAccounts.removeAll(directFriends);

        System.out.println("suggested: "+suggestedAccounts);
        System.out.println("mutual: "+mutualFriends);
        System.out.println("visited: "+visitors);

        // score 정의하기
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        for(String suggestedAccount: suggestedAccounts){
            score.put(suggestedAccount, 0);
        }
        System.out.println(score);

        // mutual friend => + 10점
        for(String mutualFriend: mutualFriends){
            if(suggestedAccounts.contains(mutualFriend)){
                score.put(mutualFriend, score.get(mutualFriend)+10);
            }
        }

        // visitor => + 1 점
        for(String visitor: visitors){
            if(suggestedAccounts.contains(visitor)){
                score.put(visitor, score.get(visitor)+1);
            }
        }

        System.out.println(score);





        return answer;
    }

}
