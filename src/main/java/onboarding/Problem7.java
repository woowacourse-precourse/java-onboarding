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

        // 함께하는 친구: 10점, 타임라인 방문자 1점을 계산한 각각의 score를 얻는다.
        Map<String,Integer> relationScore = getAddedScoreBoard(tenPoint, myFriends,10);
        Map<String,Integer> visitorScore = getAddedScoreBoard(visitors, myFriends, 1);

        // 두 scoreBoard를 합친다.
        Map<String,Integer> totalScore = new HashMap<>(relationScore);
        for(String name : visitorScore.keySet()) {
            if (relationScore.keySet().contains(name)) {
                relationScore.put(name, relationScore.get(name)+visitorScore.get(name));
            }else {
                totalScore.put(name, visitorScore.get(name));
            }
        }

        // 역순으로 정렬한다.
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        totalScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        // 0점을 제외하고 내림차순으로 5개 이하의 요소를 가진 list를 answer에 집어넣는다.
        for(Map.Entry<String,Integer> person : reverseSortedMap.entrySet()) {
            if (person.getValue() == 0) {
                reverseSortedMap.remove(person.getKey());
            }
        }
        Iterator it = reverseSortedMap.entrySet().iterator();
        for(int i=0; i<4; i++) {
            if (it.hasNext())
                it.next();
        }
        while(it.hasNext()) {
            it.next();
            it.remove();
        }

        answer = new ArrayList<>(reverseSortedMap.keySet());

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
                score.put(name, score.get(name) + point);
            }else {
                score.put(name,point);
            }
        }

        return score;
    }
}
