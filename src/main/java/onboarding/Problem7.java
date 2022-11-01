package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static final HashMap<String, Integer> userFriendScore = new HashMap();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Userfriends us = new Userfriends();
        visitor vs =new visitor();

        HashMap<String, ArrayList<String>> userlist = us.makeList(friends);
        us.makeScore(userlist,user);
        vs.makeScore(userlist,visitors,user);
        return null;
    }

    private static class Userfriends {
        HashMap<String, ArrayList<String>> userFriendList = new HashMap();

        ArrayList<String> friend;

        public HashMap<String, ArrayList<String>> makeList(List<List<String>> userfriend) {
            for (List<String> name : userfriend) {
                friend = new ArrayList<>();
                String username = name.get(0);
                for (List<String> uf : userfriend) {
                    if (uf.get(0).equals(username)) {
                        friend.add(uf.get(1));
                    }
                }
                userFriendList.put(username, friend);
            }
            return userFriendList;
        }

        public HashMap<String, Integer> makeScore(HashMap<String, ArrayList<String>> friendlist, String name) {

            final ArrayList<String> compare = friendlist.get(name);

            friendlist.forEach((key, value) -> {

                if (value == compare) {
                    if (userFriendScore.containsKey(key)) {
                        userFriendScore.put(key, userFriendScore.get(key) + 20);
                    } else {
                        userFriendScore.put(key, 20);
                    }
                }
            });
            return userFriendScore;
        }

    }

    private static class visitor {
        public HashMap<String, Integer> makeScore(HashMap<String, ArrayList<String>> friendlist, List<String> visitors,
                                                  String name) {

            final ArrayList<String> compare = friendlist.get(name);

            for (int i = 0; i < compare.size(); i++) {
                String friend = compare.get(i);
                for (int j = 0; j < visitors.size(); j++) {
                    if (!friend.equals(visitors.get(j))) {
                        userFriendScore.put(visitors.get(j), userFriendScore.get(j) + 1);
                    }
                }

            }
            return userFriendScore;
        }

    }

}
