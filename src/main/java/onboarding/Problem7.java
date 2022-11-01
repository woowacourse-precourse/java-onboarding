package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        int knowFriendPoint = 10;
        int visitPoint = 1;
        int maxRecommend = 5;

        // user의 friends를 Map 형식으로 변환
        HashMap<String, List<String>> users_friends = new HashMap<String, List<String>>();
        for(int i=0; i<friends.size(); i++) {
            users_friends = make_friends(users_friends, friends.get(i));
        }

        // 사용자와 함께 아는 친구의 수 계산
        HashMap<String, Integer> friendsPoint = new HashMap<String, Integer>();
        List<String> user_friends = users_friends.get(user);
        for(int i=0; i<user_friends.size(); i++) {
            List<String> friend_friends = users_friends.get(user_friends.get(i));
            for(int j=0; j<friend_friends.size(); j++) {
                if (!friendsPoint.containsKey(friend_friends.get(j))) {
                    friendsPoint.put(friend_friends.get(i), knowFriendPoint);
                }
            }
        }

        // 사용자의 타임 라인에 방문한 횟수 계산
        for(int i=0; i<visitors.size(); i++) {
            if (user_friends.contains(visitors.get(i))) {       // 사용자의 친구에 이미 있으면 추천에서 제외
                continue;
            }

            if (!friendsPoint.containsKey(visitors.get(i))) {
                friendsPoint.put(visitors.get(i), visitPoint);
            } else {
                int points = friendsPoint.get(visitors.get(i));
                friendsPoint.put(visitors.get(i), points + visitPoint);
            }
        }

        // 정렬
        List<Entry<String, Integer>> sortFriendsPoint = new ArrayList<Entry<String, Integer>>(friendsPoint.entrySet());

        Collections.sort(sortFriendsPoint, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // 최대 5개 추천
        if (sortFriendsPoint.size() < maxRecommend) {   // 점수가 있는 추천사용자가 max보다 작으면, max값 변경
            maxRecommend = sortFriendsPoint.size();
        }

        for(int i=0; i<maxRecommend; i++) {
            answer.add(sortFriendsPoint.get(i).getKey());
        }

        return answer;
    }

    private static HashMap<String, List<String>> make_friends(HashMap<String, List<String>> users_friends, List<String> relations) {

        if (users_friends.containsKey(relations.get(0))) {
            List<String> user_friends = users_friends.get(relations.get(0));
            user_friends.add(relations.get(1));
            users_friends.put(relations.get(0), user_friends);
        }
        else {
            List<String> user_friends = new ArrayList<String>();
            user_friends.add(relations.get(1));
            users_friends.put(relations.get(0), user_friends);
        }

        if (users_friends.containsKey(relations.get(1))) {
            List<String> user_friends = users_friends.get(relations.get(1));
            user_friends.add(relations.get(0));
            users_friends.put(relations.get(1), user_friends);
        }
        else {
            List<String> user_friends = new ArrayList<String>();
            user_friends.add(relations.get(0));
            users_friends.put(relations.get(1), user_friends);
        }

        return users_friends;
    }
}
