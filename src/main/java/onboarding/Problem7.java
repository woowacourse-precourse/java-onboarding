package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static ArrayList friend(String user, List<List<String>> friends) {
        ArrayList<String> friendsList = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                friendsList.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1).equals(user)) {
                friendsList.add(friends.get(i).get(0));
            }
        }

        return friendsList;
    }

    public static ArrayList people(String user, List<List<String>> friends, List<String> friendsList) {
        ArrayList<String> people = new ArrayList<>();
        for(int i = 0; i < friendsList.size(); i++) {
            for(int j = 0; j < friends.size(); j++) {
                if(!(friends.get(j).get(0).equals(user) || friends.get(j).get(1).equals(user))) {
                    if(friendsList.get(i).equals(friends.get(j).get(0))) {
                        if(!(people.contains(friends.get(j).get(1)))) {
                            people.add(friends.get(j).get(1));
                        }
                    }
                    if(friendsList.get(i).equals(friends.get(j).get(1))) {
                        if(!(people.contains(friends.get(j).get(0)))) {
                            people.add(friends.get(j).get(0));
                        }
                    }
                }
            }
        }

        return people;
    }

    public static HashMap count(List<String> people, List<List<String>> friends) {
        HashMap<String, Integer> count = new HashMap<>();

        for(int i = 0; i < people.size(); i++) {
            for(int j = 0; j < friends.size(); j++) {
                if(friends.get(j).contains(people.get(i))) {
                    if(count.get(people.get(i)) == null) count.put(people.get(i), 10);
                    else count.put(people.get(i), count.get(people.get(i)) + 10);
                }
            }
        }

        return count;
    }
}
