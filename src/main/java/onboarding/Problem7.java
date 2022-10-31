package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> friendScoreMap = new TreeMap<>();

    /**
     * 사용자와 친구인 사람을 구하는 메서드
     *
     * @param user 사용자 아이디
     * @param friends 친구 관계 정보
     * @return 사용자와 친구인 리스트
     */
    static List<String> createUserFriendsList(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friendList = friends.get(i);

            if (friendList.get(0) == user) {
                list.add(friendList.get(1));
            } else if (friendList.get(1) == user) {
                list.add(friendList.get(0));
            }
        }

        return list;
    }

    /**
     * 사용자의 친구 리스트에서 찾고자 하는 사람이 있는지 확인하는 메서드
     * 
     * @param name 확인하는 사람
     * @param friendsList 친구 리스트
     * @return 친구 리스트에 있으면 true, 아니라면 false
     */
    static boolean isFriend(String name, List<String> friendsList) {
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i) == name) {
                return true;
            }
        }

        return false;
    }

    /**
     * 타입에 따라서 점수를 추가하는 메서드
     *
     * @param scoreType 1이면 10점, 2면 1점을 추가한다
     * @param user 점수를 추가할 아이디디
     */
    static void addScoreToMap(int scoreType, String user) {
        if (scoreType == 1) {
            if (friendScoreMap.containsKey(user)) {
                friendScoreMap.put(user, friendScoreMap.get(user) + 10);
            } else {
                friendScoreMap.put(user, 10);
            }
        } else if (scoreType == 2) {
            if (friendScoreMap.containsKey(user)) {
                friendScoreMap.put(user, friendScoreMap.get(user) + 1);
            } else {
                friendScoreMap.put(user, 1);
            }
        }
    }

    /**
     * 친구추천 점수를 조건에 맞춰 정렬해 List로 반환하는 알고리즘
     * 
     * @return 정렬한 친구추천 점수 아이디List
     */
    static List<String> createResultList() {
        List<String> keySet = new ArrayList<>(friendScoreMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return friendScoreMap.get(o2).compareTo(friendScoreMap.get(o1));
            }
        });

        // console 출력 Test
        for (String key : keySet) {
            System.out.print("Key : " + key);
            System.out.println(", Val : " + friendScoreMap.get(key));
        }

        return keySet;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
