package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> myFriends = getUsersFriends(user, friends);

        // 내 친구의 친구를 찾아서 tenPoint에 추가. 나 자신(user)는 제거
        List<String> tenPoint = new ArrayList<>();
        for(String name : myFriends) {
            tenPoint.addAll(getUsersFriends(name, friends));
        }
        while(tenPoint.contains(user)) {
            tenPoint.remove(user);
        }

        // tenPoint에 있는 이름에 점수 부여 (친구의 친구: 10점, 방문자: 1점)
        Map<String,Integer> RelationScore = getAddedScoreBoard(tenPoint, myFriends,10);
        Map<String,Integer> visitorScore = getAddedScoreBoard(visitors, myFriends, 1);


        return answer;
    }

    private static List<String> getUsersFriends(String me, List<List<String>> friends) {
        List<String> my = new ArrayList<>();

        for(List<String> connection : friends) {
            if (connection.contains(me)) {
                my.addAll(connection);
            }
        }

        while(my.contains(me)) {
            my.remove(me);
        }

        return my;
    }

    private static Map<String,Integer> getAddedScoreBoard (List<String> members, List<String> exceptMembers, int point) {
        Map<String,Integer> score = new HashMap<>();

        for(String name : members) {
            if(exceptMembers.contains(name)) continue;

            if (score.containsKey(name)) {
                score.put(name, score.get(name) + 10);
            }else {
                score.put(name,10);
            }
        }

        return score;
    }
}
