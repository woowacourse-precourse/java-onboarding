package onboarding;

import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        List<String> resultFineMyFriend = findMyFriend(user, friends);

        return answer;
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends){

        String newString;
        List<String> friend = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            for (int j = 0; j < friends.get(i).size(); j++){
                if(friends.get(i).get(j).equals(user)){
                    List<String> newList = new ArrayList<>(friends.get(i));
                    newList.remove(user);
                    newString = String.join(",", newList);
                    friend.add(newString);
                }
            }
        }
        return friend;
    }
}
