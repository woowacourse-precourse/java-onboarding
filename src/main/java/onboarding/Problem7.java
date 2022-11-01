package onboarding;

import java.util.*;

class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userfriendList = new ArrayList<>();
        List<String> withfriendList = new ArrayList<>();
        List<String> visitcount = new ArrayList<>(); // 이미 친구인 사람과 user는 뺌


        HashMap<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                if (friends.get(i).get(0) == user) {
                    userfriendList.add(friends.get(i).get(1));
                } else if (friends.get(i).get(1) == user) {
                    userfriendList.add(friends.get(i).get(0));
                }
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userfriendList.size(); j++) {
                if (friends.get(i).contains(userfriendList.get(j))) {
                    if (friends.get(i).get(0) == userfriendList.get(j)) {
                        withfriendList.add(friends.get(i).get(1));
                    } else if (friends.get(i).get(1) == userfriendList.get(j)) {
                        withfriendList.add(friends.get(i).get(0));
                    }
                }
            }
        }

        while (withfriendList.remove(String.valueOf(user))){} ; // user제거
//        System . out . println ( withfriendList );
        Set<String> set = new HashSet<String>(withfriendList);
        List<String> tmpwithfriendList = new ArrayList<String>(set);

        return answer;
    }
}