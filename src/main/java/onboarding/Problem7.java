package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(
            String user,
            List<List<String>> friends,
            List<String> visitors
    ) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        Map<String, ArrayList<String>> friendList = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> friendScoreList = new HashMap<String, Integer>();


        friendScoreList = getMemberList(friends, visitors);
        friendList = getFriendList(friends);
        friendScoreList = countFriendsPoints(user, friendList, visitors, friendScoreList);
        friendScoreList = countVisitorsPoints(friendScoreList, visitors);
        answer = sortByScoreAndName(answer, friendScoreList, user, friendList);

        return answer;
    }

    public static Map<String, Integer> getMemberList(
            List<List<String>> friends,
            List<String> visitors) {
        HashSet<String> eraseDuplicates = new HashSet<String>();
        for (int i = 0; i < friends.size(); i++) {
            eraseDuplicates.add(friends.get(i).get(0));
            eraseDuplicates.add(friends.get(i).get(1));
        }
        for (int i = 0; i < visitors.size(); i++) {
            eraseDuplicates.add(visitors.get(i));
        }
        List<String> memberList = new ArrayList<>(eraseDuplicates);
        Map<String, Integer> list_up = new HashMap<String, Integer>();
        for (int i = 0; i < eraseDuplicates.size(); i++) {
            list_up.put(memberList.get(i), 0);
        }
        return list_up;
    }
    public static Map<String, ArrayList<String>> getFriendList(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendList = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < friends.size(); i++) {

            ArrayList<String> memberFriendTmp1 = friendList.getOrDefault(friends.get(i).get(0), new ArrayList<String>());
            memberFriendTmp1.add(friends.get(i).get(1));
            friendList.put(friends.get(i).get(0), memberFriendTmp1);

            ArrayList<String> memberFriendTmp2 = friendList.getOrDefault(friends.get(i).get(1), new ArrayList<String>());
            memberFriendTmp2.add(friends.get(i).get(0));
            friendList.put(friends.get(i).get(1), memberFriendTmp2);
        }
        return friendList;
    }

    public static Map<String, Integer> countFriendsPoints(
            String user,
            Map<String, ArrayList<String>> friend_list,
            List<String> visitors,
            Map<String, Integer> list_up) {

        ArrayList<String> userFriends = new ArrayList<>();
        userFriends = friend_list.getOrDefault(user, new ArrayList<String>());

        Set<String> keySet = friend_list.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        for (int i  = 0; i < userFriends.size(); i++) {
            for (int j = 0; j < keyList.size(); j++) {
                if (friend_list.get(keyList.get(j)).contains(userFriends.get(i))) {
                    list_up.put(keyList.get(j), list_up.getOrDefault(keyList.get(j), 0) + 10);
                }
            }
        }

        return list_up;
    }

    public static Map<String, Integer> countVisitorsPoints(Map<String, Integer> list_up, List<String> visitors) {

        for(int i = 0; i < visitors.size(); i++) {
            list_up.put(visitors.get(i), list_up.getOrDefault(visitors.get(i), 0) + 1 );
        }
        return list_up;
    }

    public static List<String> sortByScoreAndName(
            List<String> answer,
            Map<String,Integer> list_up,
            String user,
            Map<String, ArrayList<String>> friend_list) {

        List<Map.Entry<String, Integer>> sortByScore = new LinkedList<>(list_up.entrySet());

        Collections.sort(sortByScore, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<String, Integer>> iter = sortByScore.iterator(); iter.hasNext();) {
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.remove(user);
        for (int i = 0; i < friend_list.get(user).size(); i++) {
            sortedMap.remove(friend_list.get(user).get(i));
        }

        Set<String> keySet = sortedMap.keySet();
        answer = new ArrayList<>(keySet);

        return answer;
    }

}
