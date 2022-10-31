package onboarding;

import java.util.*;

public class Problem7 {
    public static TreeSet<String> userList = new TreeSet<>();
    public static HashMap<String, HashSet<String>> friendListInfo = new HashMap<>();
    public static TreeMap<String,Integer> recommendScore = new TreeMap<>();
    public static void setUserList(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> emptyList = new HashSet<>();
        friendListInfo.put(user,emptyList);
        userList.add(user);

        for(int index = 0; index < friends.size(); index++) {
            HashSet<String> emptyList2 = new HashSet<>();
            HashSet<String> emptyList3 = new HashSet<>();
            String person1 = friends.get(index).get(0);
            String person2 = friends.get(index).get(1);

            friendListInfo.put(person1,emptyList2);
            friendListInfo.put(person2,emptyList3);
            userList.add(person1);
            userList.add(person2);
        }

        for(int index = 0; index < visitors.size(); index++) {
            HashSet<String> emptyList4 = new HashSet<>();
            String person = visitors.get(index);

            friendListInfo.put(person,emptyList4);
            userList.add(person);
        }
    }
    public static void setFriendList(List<List<String>> friends) {
        for(int index = 0; index < friends.size(); index ++) {
            String person1 = friends.get(index).get(0);
            String person2 = friends.get(index).get(1);

            HashSet<String> person1FriendList = friendListInfo.get(person1);
            HashSet<String> person2FriendList = friendListInfo.get(person2);

            person1FriendList.add(person2);
            person2FriendList.add(person1);

            friendListInfo.put(person1,person1FriendList);
            friendListInfo.put(person2,person2FriendList);
        }
    }
    public static List<String> calculateScore(String user, List<String> visitors) {
        Iterator<String> iter = userList.iterator();

        while(iter.hasNext()) {
            String name = iter.next();
            int score = 0;
            HashSet<String> myFriendList = friendListInfo.get(user);
            if(name != user) {
                HashSet<String> yourFriendList = friendListInfo.get(name);
                HashSet<String> tempSet = new HashSet<>(myFriendList);
                tempSet.retainAll(yourFriendList);
                score += 10 * tempSet.size();
            }
            recommendScore.put(name,score);
        }

        for(int index = 0; index < visitors.size(); index++) {
            String visitorName = visitors.get(index);

            int visitorScore = recommendScore.get(visitorName) + 1;
            recommendScore.put(visitorName,visitorScore);
        }

        List<String> nameList = new ArrayList<String>(recommendScore.keySet());
        Collections.sort(nameList,((o1, o2) -> Double.compare(recommendScore.get(o2),recommendScore.get(o1))));

        List<String> answer = selectRecommendFriend(nameList,user);

        return answer;
    }
    public static List<String> selectRecommendFriend(List<String> nameList, String user) {
        List<String> answer = new ArrayList<>();
        HashSet<String> friendList = friendListInfo.get(user);
        Iterator<String> iter = nameList.iterator();

        for(int i = 0; i < 5; i++) {
            String name = iter.next();
            if(friendList.contains(name)) continue;
            if(recommendScore.get(name) > 0){
                answer.add(name);
            }
        }
        return answer;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setUserList(user,friends,visitors);
        setFriendList(friends);
        List<String> answer = calculateScore(user, visitors);
        return answer;
    }
}
