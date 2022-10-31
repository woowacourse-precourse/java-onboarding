package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

       List<String> answer = new ArrayList<>(Collections.emptyList());

        Map<String, Integer> hashMap = new HashMap<>();

        List<String> buddyList = userList(user, friends);

        List<String> buddyBuddy;

        for(String  i : buddyList){

            buddyBuddy = userList(i, friends);

            for(String j : buddyBuddy){

                if(j.equals(user)){

                    continue;

                }

                if (hashMap.containsKey(j)){

                    hashMap.put(j, hashMap.get(j) + 10);

                }

                hashMap.put(j,10);
            }
        }

        for(String i : visitors){

            if(buddyList.contains(i)){

                continue;
            }
            if (hashMap.containsKey(i)){

                hashMap.put(i, hashMap.get(i) + 1);

                continue;
            }
            hashMap.put(i,1);
        }

        List<String> listKeySet = new ArrayList<>(hashMap.keySet());

        listKeySet.sort((value1, value2) -> (hashMap.get(value2).compareTo(hashMap.get(value1))));

        answer.addAll(hashMap.keySet());

        return answer;
    }

    public static List<String> userList(String user, List<List<String>> freind){

        List<String> answer = new ArrayList<>();

        for (List<String> strings : freind) {

            for (int j = 0; j < 2; j++) {

                if (strings.get(j).equals(user)) {

                    answer.add(strings.get(1 - j));

                }
            }
        }

        return answer;
    }

}
