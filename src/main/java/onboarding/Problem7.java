package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> nameAndPoint = new HashMap<>();

        for (int j = 0; j < visitors.size() ; j++){
            String name = visitors.get(j);

            if (nameAndPoint.containsKey(name)){
                int presentPoint = nameAndPoint.get(name);
                presentPoint += 1;
                nameAndPoint.put(name,presentPoint);
                continue;
            }

            nameAndPoint.put(name,1);
        }

        for (int i = 0; i < 2 ; i++){
            for (int j = 0; j < friends.size() ; j++){
                String name = friends.get(j).get(i);

                if (nameAndPoint.containsKey(name)){
                    continue;
                }

                nameAndPoint.put(name,0);
            }
        }



        List<String> friendsOfUser = new ArrayList<>();

        for (int i =0 ; i < friends.size() ; i++) {
            int userIndex = friends.get(i).indexOf(user);

            int friendIndex = 1-userIndex;

            friendsOfUser.add(friends.get(i).get(friendIndex));
        }


        for (int i = 0 ; i < friendsOfUser.size() ; i ++){
            for (int j =0 ; j < friends.size() ; j++) {
                int friendsIndex = friends.get(j).indexOf(friendsOfUser.get(i));

                int friendOfFriendIndex = 1-friendsIndex;

                String friendNameOfFriendOfUser = friends.get(i).get(friendOfFriendIndex);

            }
        }


        List<String> answer = Collections.emptyList();
        return answer;
    }
}
