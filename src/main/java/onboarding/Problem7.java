package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> set = new HashSet<String>();

        for(List<String> friend :friends){
            set.add(friend.get(0));
            set.add(friend.get(1));
        }

        List<String> peopleList = new ArrayList<>(set);
        HashMap<String, Integer> people= new HashMap<>();

        for (String s : peopleList) {
            people.put(s, 0);
        }

        int userIndex = 0;

        for (int i = 0; i < peopleList.size(); i++){
            if(user.equals(peopleList.get(i))){
                userIndex = i;
                break;
            }
        }

        List<List<String >> relation = new ArrayList<>();

        for (String person : peopleList) {
            List<String> relate = new ArrayList<>();
            for (List<String> friend : friends) {
                if (Objects.equals(person, friend.get(0))) {
                    relate.add(friend.get(1));
                } else if (Objects.equals(person, friend.get(1))) {
                    relate.add(friend.get(0));
                }
            }
            relation.add(relate);
        }

        List<String> userFriends = relation.get(userIndex);

        for(int i = 0; i < relation.size(); i++){
            if (userIndex == i) continue;
            if(userFriends.contains(peopleList.get(i))) continue;

            List<String> compareList = relation.get(i);
            String compareFriend = peopleList.get(i);

            for (String userFriend : userFriends) {
                if (compareList.contains(userFriend)) {
                    int tmpScore = people.get(compareFriend);
                    people.put(compareFriend, tmpScore + 10);
                }
            }
        }

        for(String visitor : visitors){
            if (userFriends.contains(visitor)) continue;
            if (people.containsKey(visitor)){
                int tmpScore = people.get(visitor);
                people.put(visitor, tmpScore + 1);
            }else{
                people.put(visitor, 1);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String person : people.keySet()) {
            if (people.get(person) != 0) {
                answer.add(person);
            }
        }
        Collections.sort(answer);

        answer.sort((a, b) -> {
            return people.get(b).compareTo(people.get(a));
        });
        System.out.println(people);
        System.out.println(relation);
        return answer;
    }
}
