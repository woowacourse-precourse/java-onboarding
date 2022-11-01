package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Set<String> members;
    static List<String> recommendFriends;
    static Set<String> userFriends;
    static List<String> memberList;
    static int[] memberPoint;
    static int max;
    static List memberPointList;


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        createFriendsList(user, friends, visitors);
        recommendPoint(user, friends, visitors);
        List<String> answer = recommendList();
        return answer;
    }

    public static List<String> createFriendsList(String user, List<List<String>> friends, List<String> visitors) {
        members = new HashSet<>();
        userFriends = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if (j == 0 && name == user) {
                    userFriends.add(friends.get(i).get(1));
                }
                if (j == 1 && name == user) {
                    userFriends.add(friends.get(i).get(0));
                }
                members.add(name);
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            members.add(name);
        }
        members.remove(user);
        for (String name : userFriends) {
            members.remove(name);
        }
        memberList = new ArrayList<>(members);
        return memberList;
    }

    public static List<Integer> recommendPoint(String user, List<List<String>> friends, List<String> visitors) {
        memberPoint = new int[memberList.size()];
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                continue;
            }
            for (String name : userFriends) {
                if (friends.get(i).contains(name)) {
                    if (friends.get(i).get(0) == name) {
                        int index = memberList.indexOf(friends.get(i).get(1));
                        memberPoint[index] += 10;
                    }
                    if (friends.get(i).get(1) == name) {
                        int index = memberList.indexOf(friends.get(i).get(0));
                        memberPoint[index] += 10;
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (memberList.contains(visitor)) {
                int index = memberList.indexOf(visitor);
                memberPoint[index]++;
            }
        }
        for (int i = 0; i < memberPoint.length; i++) {
        }
        memberPointList = Arrays.stream(memberPoint).boxed().collect(Collectors.toList());

        return memberPointList;
    }

    public static List<String> recommendList() {
        recommendFriends = new ArrayList<>();
        for (int i = 0; i < memberPointList.size(); i++) {
            max = (int) memberPointList.get(i);
            for (int j = 0; j < memberPointList.size(); j++) {
                if ((int) memberPointList.get(j) > max) {
                    max = (int) memberPointList.get(j); //20
                }
            }
            if (max == 0) {
                break;
            }
            for (int j = 0; j < memberPointList.size(); j++) {
                if ((int) memberPointList.get(j) == max) {
                    recommendFriends.add(memberList.get(j));
                    memberPointList.set(j, 0);
                    if (j == memberPointList.size()) {
                        Collections.sort(recommendList(), Collections.reverseOrder());
                    }
                }
            }
        }
        return recommendFriends;
    }
}