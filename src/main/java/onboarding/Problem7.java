package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> uniqueFriends = new HashSet<>();
        List<String> listOfUniqueFriends;
        ArrayList<String>[] friendsOfUsers;
        ArrayList<String> friendsOfThisUser;
        Map<String, Integer> scoresWithNames = new HashMap<>();

        int[] scores;
        int idx1, idx2, userIdx, numOfUsers;

        for (List<String> friendship : friends) {
            uniqueFriends.addAll(friendship);
        }
        uniqueFriends.addAll(visitors);
        numOfUsers = uniqueFriends.size();

        listOfUniqueFriends = new ArrayList<>(uniqueFriends);
        friendsOfUsers = new ArrayList[numOfUsers];
        for (int i = 0; i < numOfUsers; i ++) {
            friendsOfUsers[i] = new ArrayList<>();
        }

        for (List<String> friendship : friends) {
            idx1 = listOfUniqueFriends.indexOf(friendship.get(0));
            idx2 = listOfUniqueFriends.indexOf(friendship.get(1));
            friendsOfUsers[idx1].add(friendship.get(1));
            friendsOfUsers[idx2].add(friendship.get(0));
        }

        userIdx = listOfUniqueFriends.indexOf(user);
        friendsOfThisUser = friendsOfUsers[userIdx];
        friendsOfUsers[userIdx] = new ArrayList<>();
        scores = new int[numOfUsers];
        Arrays.fill(scores, 0);

        // 함께 아는 친구 수 당 10점 추가
        for (int j = 0; j < numOfUsers; j++) {
            for (String friend : friendsOfUsers[j]) {
                if (friendsOfThisUser.contains(friend)) {
                    scores[j] += 10;
                }
            }
        }

        // 방문 횟수 당 1점 추가
        for (String visitor : visitors) {
            idx1 = listOfUniqueFriends.indexOf(visitor);
            scores[idx1] ++;
        }

        //현재 유저와 이미 친구면 추천 친구에서 제거 (스코어 0점 처리)
        for (String friendOfThisUser : friendsOfThisUser) {
            idx1 = listOfUniqueFriends.indexOf(friendOfThisUser);
            scores[idx1] = 0;
        }

        for (int k = 0; k < numOfUsers; k++) {
            scoresWithNames.put(listOfUniqueFriends.get(k), scores[k]);
        }

        return top_five(sortByValueThenKey(scoresWithNames));

    }

    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValueThenKey(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> user1, Map.Entry<K, V> user2) {
                if (user1.getValue().equals(user2.getValue()))
                    return user1.getKey().compareTo(user2.getKey());
                else
                    return user2.getValue().compareTo(user1.getValue());
            }
        });

        Map<K, V> sorted = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    static ArrayList<String> top_five(Map<String, Integer> hm) {
        int count = 0;
        ArrayList<String> recommended = new ArrayList<>();
        for (Map.Entry<String, Integer> user : hm.entrySet()) {
            if (user.getValue() > 0 && count < 6) {
                recommended.add(user.getKey());
                count++;
            }
        }
        return recommended;
    }
}
