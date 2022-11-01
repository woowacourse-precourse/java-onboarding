package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, ArrayList<String>> friendList = new HashMap<>();
        HashMap<String, Integer> recommendPoint = new HashMap<>();
        matchingList(friendList, friends);
        try {
            ArrayList<String> userFriends = friendList.get(user);
            ArrayList<String> addingList = new ArrayList<>();
            for (int i = 0; i < userFriends.size(); i++) {
                addingList.addAll(friendList.get(userFriends.get(i)));
                addingList.remove(user);
            }


            for(int i = 0; i < addingList.size(); i++) {
                if (recommendPoint.containsKey(addingList.get(i)))
                    recommendPoint.put(addingList.get(i), recommendPoint.get(addingList.get(i)) + 10);
                else recommendPoint.put(addingList.get(i), 10);
            }
        } catch (Exception ignored) {
        }


        for (String visitor : visitors) {
            if(friendList.get(user).contains(visitor)) continue;
            if (recommendPoint.containsKey(visitor))
                recommendPoint.put(visitor, recommendPoint.get(visitor) + 1);
            else recommendPoint.put(visitor, 1);
        }


        ArrayList<String> answer = new ArrayList<>(recommendPoint.keySet());
        for (int i = 0; i < answer.size() - 1; i++) {
            for (int j = i + 1; j < answer.size(); j++) {
                if (recommendPoint.get(answer.get(i)) < recommendPoint.get(answer.get(j))) {
                    Collections.swap(answer, answer.indexOf(answer.get(i)), answer.indexOf(answer.get(j)));
                }
            }
        }

        return answer;
    }

    public static void matchingList(HashMap<String, ArrayList<String>> friendList, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            if (!friendList.containsKey(friends.get(i).get(0)) && !friendList.containsKey(friends.get(i).get(1))) {
                friendList.put(friends.get(i).get(0), new ArrayList<String>(Arrays.asList(friends.get(i).get(1))));
                friendList.put(friends.get(i).get(1), new ArrayList<String>(Arrays.asList(friends.get(i).get(0))));
            } else if (!friendList.containsKey(friends.get(i).get(0)) && friendList.containsKey(friends.get(i).get(1))) {
                friendList.put(friends.get(i).get(0), new ArrayList<String>(Arrays.asList(friends.get(i).get(1))));
                friendList.get(friends.get(i).get(1)).add(friends.get(i).get(0));
            } else if (friendList.containsKey(friends.get(i).get(0)) && !friendList.containsKey(friends.get(i).get(1))) {
                friendList.get(friends.get(i).get(0)).add(friends.get(i).get(1));
                friendList.put(friends.get(i).get(1), new ArrayList<String>(Arrays.asList(friends.get(i).get(0))));
            } else {
                friendList.get(friends.get(i).get(0)).add(friends.get(i).get(1));
                friendList.get(friends.get(i).get(1)).add(friends.get(i).get(0));
            }
        }
    }
}
