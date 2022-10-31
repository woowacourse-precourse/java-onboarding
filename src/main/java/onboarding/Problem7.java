package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();

        List<String> tempFriends = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++) {
            if (friends.get(i).indexOf(user) != -1) {
                int tempIdx = friends.get(i).indexOf(user) == 0 ? 1 : 0;
                tempFriends.add(friends.get(i).get(tempIdx));
            }
        }

        List<String> userFriends = tempFriends.stream().distinct().collect(Collectors.toList());

        List<String> friendOfFriend = new ArrayList<>();

        for(int i = 0; i < userFriends.size(); i++) {
            for(int j = 0; j < friends.size(); j++) {
                if (friends.get(j).indexOf(userFriends.get(i)) != -1) {
                    int tempIdx = friends.get(j).indexOf(userFriends.get(i)) == 0 ? 1 : 0;
                    if(!friends.get(j).get(tempIdx).equals(user))
                        friendOfFriend.add(friends.get(j).get(tempIdx));
                }
            }
        }

        List<List<String>> friendAndScore = new ArrayList<>();

        t1: for(int i = 0; i < friendOfFriend.size(); i++) {
            for(int j = 0; j < friendAndScore.size(); j++) {
                if(friendAndScore.get(j).get(0).equals(friendOfFriend.get(i))) {
                    friendAndScore.get(j).set(1, Integer.parseInt(friendAndScore.get(j).get(1)) + 10 + "");
                    continue t1;
                }
            }
            friendAndScore.add(Arrays.asList(friendOfFriend.get(i), "10"));
        }

        t2: for(int i = 0; i < visitors.size(); i++) {
            for(int j = 0; j < friendAndScore.size(); j++) {
                if(friendAndScore.get(j).get(0).equals(visitors.get(i))) {
                    friendAndScore.get(j).set(1, Integer.parseInt(friendAndScore.get(j).get(1)) + 1 + "");
                    continue t2;
                }
            }
            if(!userFriends.contains(visitors.get(i)))
                friendAndScore.add(Arrays.asList(visitors.get(i), "1"));
        }

        for(int i = 0; i < friendAndScore.size() - 1; i++) {
            for(int j = i + 1; j < friendAndScore.size(); j++) {
                if(Integer.parseInt(friendAndScore.get(i).get(1)) <= Integer.parseInt(friendAndScore.get(j).get(1))) {
                    if(friendAndScore.get(i).get(0).compareTo(friendAndScore.get(j).get(0)) > 0) {
                        List<String> tempList = friendAndScore.get(i);
                        friendAndScore.set(i, friendAndScore.get(j));
                        friendAndScore.set(j, tempList);
                    }
                }
            }
        }

        for(int i = 0; i < friendAndScore.size(); i++)
            answer.add(friendAndScore.get(i).get(0));

        return answer;
    }
}
