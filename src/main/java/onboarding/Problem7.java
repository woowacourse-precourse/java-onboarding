package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> myFriendList = findMyFriend(user, friends);
        HashMap<String, Integer> findMyfriendsFriend = findMyFriendsFriend(user, myFriendList, friends);
        HashMap<String, Integer> findMyVisitors = findMyVisitors(user, myFriendList, visitors);

        HashMap<String, Integer> answerMap = new HashMap<>();
        answerMap.putAll(findMyVisitors);
        answerMap.putAll(findMyfriendsFriend);

        answerMap = sortByValue(answerMap);

        Iterator<String> keys = answerMap.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            answer.add(key);
            System.out.println(answer);
        }

        return answer;
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends) {
        List<String> realFriend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(1).equals(user)){
                realFriend.add(friends.get(i).get(0));
            }
        }
        return realFriend;
    }

    public static HashMap<String, Integer> findMyFriendsFriend(String user, List<String> myFriend, List<List<String>> friendsList) {

        HashMap<String, Integer> myFriendsFriend = new HashMap<>();
        for(int i = 0; i < friendsList.size(); i++) {
            int count = 10;
            if (!friendsList.get(i).get(1).equals(user) && myFriend.contains(friendsList.get(i).get(0))) {
                myFriendsFriend.put(friendsList.get(i).get(1), count * 10);
            }
        }
        myFriendsFriend = sortByValue(myFriendsFriend);
        return myFriendsFriend;
    }

    public static HashMap<String, Integer> findMyVisitors(String user, List<String> myFriend, List<String> visitors) {
        HashMap<String, Integer> notMyFriendVisitors = new HashMap<>();
        for(int i = 0; i < visitors.size(); i++) {
            int count = 1;
            for (String f : myFriend) {
                if (!visitors.get(i).equals(f)) {
                    notMyFriendVisitors.put(visitors.get(i), count++);
                }
            }
        }
        return notMyFriendVisitors;
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
