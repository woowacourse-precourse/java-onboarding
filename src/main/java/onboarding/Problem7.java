package onboarding;

import java.util.*;

public class Problem7 {
    // 기능 목록 1 : user의 친구를 구하는 함수
    public static List<String> findUserFriends(List<List<String>> friends,String user){
        List<String> myfriends = new ArrayList<>();

        for(List<String> friend:friends){
            if(friend.contains(user)){
                if(friend.get(0)==user){
                    myfriends.add(friend.get(1));
                }
                if(friend.get(1)==user){
                    myfriends.add(friend.get(0));
                }
            }
        }
        return myfriends;
    }

    // 기능 목록 2 : 함께 아는 친구를 구하는 함수
    public static List<String> findFriendsOfFriends(List<List<String>> friends, List<String> myfriends, String user){
        List<String> friendsOffriends = new ArrayList<>();

        for(String myfriend:myfriends){
            for(List<String> friend:friends){
                if(friend.contains(myfriend)&&!friend.contains(user)){
                    if(friend.get(0)==myfriend){
                        friendsOffriends.add(friend.get(1));
                    }
                    if(friend.get(1)==myfriend){
                        friendsOffriends.add(friend.get(0));
                    }
                }
            }
        }

        return friendsOffriends;
    }

    // 기능 목록 3 : 친구 추천 알고리즘의 10점인 경우를 만족하는 사용자들의 점수를 계산하는 함수
    public static Map<String, Integer> tenScoreCalculation(List<String> myfriends, List<String> friendsOffriends){
        Map<String, Integer> friendsRecommend = new TreeMap<>();

        for(String f:friendsOffriends){
            if(!myfriends.contains(f)){
                if(!friendsRecommend.containsKey(f)){
                    friendsRecommend.put(f,0);
                }
                friendsRecommend.replace(f,friendsRecommend.get(f)+10);
            }
        }

        return friendsRecommend;
    }

    // 기능 목록 4 : 친구 추천 알고리즘의 1점인 경우를 만족하는 사용자들의 점수를 계산하는 함수
    public static Map<String, Integer> oneScoreCalculation(List<String> myfriends, List<String> visitors, Map<String, Integer> friendsRecommend){
        for(String visitor:visitors){
            if(!myfriends.contains(visitor)){
                if(!friendsRecommend.containsKey(visitor)){
                    friendsRecommend.put(visitor,0);
                }
                friendsRecommend.replace(visitor,friendsRecommend.get(visitor)+1);
            }
        }

        return friendsRecommend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
