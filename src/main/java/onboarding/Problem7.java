package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> friendsWithUser = new ArrayList<>();
    public static Map<String, Integer> sameFriendWithUser = new HashMap<String, Integer>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        addFriendsWithUser(user,friends);
        findSameFriendWithUser(user,friends);
        findVisitor(visitors);
        makeOrder();
        return answer;
    }

    private static void makeOrder() {
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(sameFriendWithUser.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {

                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
    }

    private static void findVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if(sameFriendWithUser.containsKey(visitor)){
                sameFriendWithUser.replace(visitor, sameFriendWithUser.get(visitor)+1);
            }else{
                sameFriendWithUser.put(visitor,1);
            }
        }
    }

    public static void findSameFriendWithUser(String user, List<List<String>> friends) {
        for (List<String> list : friends) {
            for (String friendWithUser : friendsWithUser) {
                if(list.contains(friendWithUser)) {
                    for (String friend : list) {
                        if(!friend.equals(user) && !friend.equals(friendWithUser)){
                            if(sameFriendWithUser.containsKey(friend)){
                                sameFriendWithUser.replace(friend, sameFriendWithUser.get(friend)+20);
                            }else{
                                sameFriendWithUser.put(friend,20);

                            }
                        }
                    }
                }
            }
        }
    }

    public static void addFriendsWithUser(String user, List<List<String>> friends) {
        for(List<String> list : friends){
            if(list.contains(user)) {
                for (String friend : list) {
                    if(!friend.equals(user)){
                        friendsWithUser.add(friend);
                    }
                }
            }
        }
    }
}