package onboarding;

import java.awt.*;
import java.awt.image.ImageProducer;
import java.util.*;
import java.util.List;

public class Problem7 {

    public static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {

    }

    private static List<String> makeFriendList(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendlist = new ArrayList<>();
        String friend;

        /* 친구 리스트 생성 */
        for (int i = 0; i < friends.size(); i++) {  // 친구인 유저들과 친구인 유저

            friend = friends.get(i).get(1);

            // 중복 제거 및 자신은 포함시키지 않는다.
            if (!friendlist.contains(friend) && friend != user) {
                friendlist.add(friend);
            }

        }

        for (int i = 0; i < visitors.size(); i++) {  // 내 피드를 조회한 유저

            friend = visitors.get(i);

            // 중복 제거 및 자신은 포함시키지 않는다.
            if (!friendlist.contains(friend) && friend != user) {
                friendlist.add(friend);
            }

        }

        for (int i = 0; i < friends.size(); i++) {  // 친구 관계 목록에서 A에 있는 유저는 이미 친구이므로 제외

            friend = friends.get(i).get(0);

            for (int j = 0; j < friendlist.size(); j++) {
                if (friendlist.get(j) == friend) {
                    friendlist.remove(j);
                }
            }

        }

        return friendlist;

    }

    public static HashMap<String, Integer> calculateScore(List<List<String>> friends, List<String> visitors, List<String> friendList) {

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        return answer;

    }


}
