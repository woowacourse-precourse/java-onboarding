package onboarding;

import java.util.*;

public class Problem7 {
    /** 기능 명세
     * 1. user의 친구 찾기
     * 2. 추천 점수 계산하기
     * 3. 가장 높은 점수를 받은 친구 5명 추천하기
     */
    public static List<String> listOfRecommend(String user, List<List<String>> friends, List<String> visitors) {
        List<String> listOfUserFriends = findUserFriend(user, friends);
        Map<String, Integer> listOfScore = new HashMap<String, Integer>();

        for (String visitor : visitors) {
            if (!listOfUserFriends.contains(visitor)) { listOfScore.put(visitor, listOfScore.getOrDefault(visitor, 0) + 1); }
        }
        for (String friend : listOfUserFriends) {
            for (int i = 0; i <friends.size(); i++) {
                List<String> getList = friends.get(i);
                if (getList.contains(friend) && getList.indexOf(friend)==0 && !getList.contains(user))      { listOfScore.put(getList.get(1), listOfScore.getOrDefault(getList.get(1), 0) +10); }
                else if (getList.contains(friend) && getList.indexOf(friend)!=0 && !getList.contains(user)) { listOfScore.put(getList.get(0), listOfScore.getOrDefault(getList.get(0), 0) +10); }
            }
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(listOfScore.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        Map<String, Integer> sortedListOfScore = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedListOfScore.put(entry.getKey(), entry.getValue());
        }

        List<String> listOfRecommend = new ArrayList<>(sortedListOfScore.keySet());
        if (listOfRecommend.size() > 5) { return listOfRecommend.subList(0,5); }
        return listOfRecommend;
    }

    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        ArrayList<String> listOfUserFriends = new ArrayList<>();
        for (List<String> relationship : friends) {
            if (relationship.contains(user) && relationship.get(0) == user)      { listOfUserFriends.add(relationship.get(1)); }
            else if (relationship.contains(user) && relationship.get(0) != user) { listOfUserFriends.add(relationship.get(0)); }
        }
        return listOfUserFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = listOfRecommend(user, friends, visitors);
        return answer;
    }
}
