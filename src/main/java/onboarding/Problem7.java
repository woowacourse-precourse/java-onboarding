package onboarding;

import java.util.*;

public class Problem7 {
    /* value 기준 내림차순 정렬, 같은 value는 key 기준 오름차순 정렬하는 메서드 */
    public static ArrayList<String> sort(HashMap<String, Integer> sharedFriends) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(sharedFriends.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        ArrayList<String> sortedMap = new ArrayList<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            if(sortedMap.size() == 5) {
                break;
            }
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.add(entry.getKey());
        }
        return sortedMap;
    }

    /* user 또는 user 친구 목록에 있는지 확인 */
    public static boolean containsUserFriends(HashSet<String> userFriends, String user, String name) {
        if(userFriends.contains(name) || user == name) {
            return true;
        }
        return false;
    }

    /* 방문자 점수 등록 메서드 */
    public static HashMap<String, Integer> checkVisitors(List<String> visitors, HashMap<String, Integer> sharedFriends, HashSet<String> userFriends, String user) {
        for(String visitor : visitors) {
            if(containsUserFriends(userFriends, user, visitor)) {
                continue;
            }
            if(sharedFriends.containsKey(visitor)) {
                sharedFriends.replace(visitor, sharedFriends.get(visitor), sharedFriends.get(visitor) + 1);
            } else {
                sharedFriends.put(visitor, 1);
            }
        }
        System.out.println(sharedFriends);
        return sharedFriends;
    }

    /* 함께 아는 친구 점수 등록 메서드 */
    public static HashMap<String, Integer> createSharedFriendsHashmap(List<List<String>> friends, HashSet<String> userFriends, String user) {
        HashMap<String, Integer> sharedFriends = new HashMap<String, Integer>();
        for(String userFriend : userFriends) {
            for(List<String> friend : friends) {
                String firstName = friend.get(0);
                String secondName = friend.get(1);
                if(firstName == user || secondName == user) {
                    continue;
                } else if(firstName == userFriend || secondName == userFriend) {
                    String key = (firstName == userFriend) ? secondName : firstName;
                    if(containsUserFriends(userFriends, user, key)) {
                        continue;
                    } else if(sharedFriends.containsKey(key)) {
                        sharedFriends.replace(key, sharedFriends.get(key), sharedFriends.get(key) + 10);
                    } else {
                        sharedFriends.put(key, 10);
                    }
                }
            }
        }
        return sharedFriends;
    }

    /* user 친구 목록 저장 메서드 */
    public static HashSet<String> findUserFriends(String user, List<List<String>> friends) {
        HashSet<String> userFriend = new HashSet<String>();
        for(List<String> friend :  friends) {
            if(friend.get(0) == user) {
                userFriend.add(friend.get(1));
            } else if(friend.get(1) == user) {
                userFriend.add(friend.get(0));
            }
        }
        return userFriend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> userFriends = findUserFriends(user, friends);
        HashMap<String, Integer> sharedFriendsMap = createSharedFriendsHashmap(friends, userFriends, user);
        sharedFriendsMap = checkVisitors(visitors, sharedFriendsMap, userFriends, user);
        answer = sort(sharedFriendsMap);
        System.out.println(answer);
        return answer;
    }
}
