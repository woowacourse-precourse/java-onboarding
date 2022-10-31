package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();

        // user의 친구 리스트
        ArrayList<String> friendsList = friend(user, friends);

        // user의 친구의 친구 리스트
        ArrayList<String> people = people(user, friends, friendsList);

        // user와 함께 아는 친구의 수 카운트
        HashMap<String, Integer> count = count(people, friends);

        // 추천 친구
        for(int i = 0; i < visitors.size(); i++) {
            if(friendsList.contains(visitors.get(i))) continue;

            if(count.get(visitors.get(i)) == null) count.put(visitors.get(i), 1);
            else count.put(visitors.get(i), count.get(visitors.get(i)) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(count.entrySet());
        entryList.sort(((o1, o2) -> count.get(o2.getKey()) - count.get(o1.getKey())));

        List<String> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }

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
