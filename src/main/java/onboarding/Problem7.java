package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> usersFriend = new HashSet<String>();
        HashSet<String> people = new HashSet<String>();
        HashMap<String, Integer> score = new HashMap<>();

        for (List<String> friend : friends) {
            people.add(friend.get(0));
            people.add(friend.get(1));
            if (friend.contains(user)) {
                usersFriend.add(friend.get(0));
                usersFriend.add(friend.get(1));
            }
        }
        usersFriend.remove(user);
        //Friends List and People List
        for (String person : people) {
            score.put(person,0);
        }
        //score board

        for (List<String> friend : friends) {
            if(usersFriend.contains(friend.get(0)) || usersFriend.contains(friend.get(1))){
                score.put(friend.get(0),score.get(friend.get(0)) +10);
                score.put(friend.get(1),score.get(friend.get(1)) +10);
            }
        }

        for (String visitor : visitors){
            if(score.containsKey(visitor)){
                score.put(visitor,score.get(visitor)+1);
            }else{
                score.put(visitor,1);
            }
        }

        for(String person : usersFriend){
            score.remove(person);
        }
        score.remove(user);

        answer = sortMap(score);

        return answer;

    }

    static List<String> sortMap(HashMap<String,Integer> map){
        List<String> name = new ArrayList<>();

        Object[] sortedList = map.entrySet().toArray();
        Arrays.sort(sortedList, new Comparator() {
            public int compare(Object o1, Object o2){
                return ((Map.Entry<String,Integer>) o2).getValue().compareTo(((Map.Entry<String,Integer>) o1).getValue());
            }
        });
        for (Object e : sortedList){
            name.add(((Map.Entry<String,Integer>) e).getKey());

        }

        return name;
    }

}