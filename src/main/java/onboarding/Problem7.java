package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem7 {

    private static Map<String, Set<String>> friendsList = new HashMap<>();
    private static Map<String, Integer> usersScoreDict = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 친구 테이블 구성
        for (List<String> friend : friends) {
            String A = friend.get(0);
            String B = friend.get(1);
            updateFriendsList(A, B);
            updateFriendsList(B, A);
        }
        Set<String> userFreindList = friendsList.get(user);

        //  함께 아는 친구의 수 계산
        for (String name : friendsList.keySet()) {
            if (userFreindList.contains(name) || name.equals(user)) // user와 이미 친구인 경우 패스
                continue;

            Set<String> eachFriendList = friendsList.get(name);
            eachFriendList.retainAll(userFreindList); // user와 함께 아는 친구
            int acquaintanceNum = eachFriendList.size();
            usersScoreDict.put(name, acquaintanceNum * 10);
        }

        // 사용자 타임 라인 방문 점수 계산
        for (String visitor : visitors) {
            if (userFreindList.contains(visitor) || visitor.equals(user)) // user와 이미 친구인 경우 패스
                continue;

            if (usersScoreDict.containsKey(visitor)) {
                int currScore = usersScoreDict.get(visitor);
                usersScoreDict.put(visitor, currScore + 1);
            } else {
                usersScoreDict.put(visitor, 1);
            }
        }

        // 정렬
        PriorityQueue<UserScore> pq = new PriorityQueue<>();
        for (String name : usersScoreDict.keySet()) {
            pq.add(new UserScore(name, usersScoreDict.get(name)));
        }

        return answer;
    }

    static void updateFriendsList(String A, String B) {
        if (friendsList.containsKey(A)) {
            friendsList.get(A).add(B);
        } else {
            Set<String> newFriendList = new HashSet<>();
            newFriendList.add(B);
            friendsList.put(A, newFriendList);
        }
    }
}

class UserScore implements Comparable<UserScore> {
    private String name;
    private int score;

    public UserScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


    @Override
    public int compareTo(UserScore o) {
        if (this.score < o.getScore())
            return 1;
        else if (this.score > o.getScore())
            return -1;
        else
            return this.name.compareTo(o.getName());
    }
}