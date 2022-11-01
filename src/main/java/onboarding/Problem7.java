package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> algorithmFriends(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> alreadyFriends = new ArrayList<>();
        HashMap<String, Integer> recommendFriends = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                alreadyFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                alreadyFriends.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            if (alreadyFriends.contains(friends.get(i).get(0))) {
                if (!alreadyFriends.contains(friends.get(i).get(1)) && !friends.get(i).get(1).equals(user)) {
                    recommendFriends.put(friends.get(i).get(1), recommendFriends.getOrDefault(friends.get(i).get(1), 0) + 10);
                }
            }

            if (alreadyFriends.contains(friends.get(i).get(1))) {
                if (!alreadyFriends.contains(friends.get(i).get(0)) && !friends.get(i).get(0).equals(user)) {
                    recommendFriends.put(friends.get(i).get(0), recommendFriends.getOrDefault(friends.get(i).get(0), 0) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (alreadyFriends.contains(visitors.get(i))) {
                continue;
            }
            recommendFriends.put(visitors.get(i), recommendFriends.getOrDefault(visitors.get(i), 0) + 1);
        }

        List<String> keySetList = new ArrayList<>(recommendFriends.keySet());
        Collections.sort(keySetList, (o1, o2) -> (recommendFriends.get(o2).compareTo(recommendFriends.get(o1))));

        int count = 0;
        for(String key : keySetList) {
            answer.add(key);

            count++;
            if (count == 4) {
                break;
            }
        }

        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = algorithmFriends(user, friends, visitors);
        return answer;
    }
}
