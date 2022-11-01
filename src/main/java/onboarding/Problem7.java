package onboarding;

import onboarding.problem7.User;
import onboarding.problem7.Users;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Users users = new Users();

        for (List<String> ids : friends) {
            String id1 = ids.get(0);
            String id2 = ids.get(1);

            User user1 = users.getUserById(id1);
            User user2 = users.getUserById(id2);

            user1.addFriend(user2);
            user2.addFriend(user1);
        }

        return users.recommendFriends(user, visitors);
    }
}
