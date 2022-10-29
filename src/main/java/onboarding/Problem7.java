package onboarding;

import java.util.*;

/**
 * 생각 정리
 * 사용자와 함께아는 친구의 수*10 + 타임라인 방문횟수
 * 친구추천 점수는 자료구조 HashMap <String, Integer>에 저장.
 * 인접리스트를 사용해 친구 관계를 구현해보자.
 * user의 친구들에 각각 접근해서 친구들의 친구에 대해 아이디로 HashMap에서 찾아서 친구추천 점수에 더해준다.
 * 이때 이미 user와 친구인 사람은 추천해주면 안되므로 다 추가한 뒤에 다시 유저의 친구들만 HashMap에서 삭제
 * 이후 정렬하고 최대 5개까지만 answer List에 추가한다.
 * 기능 명세
 * 1. 유저의 친구정보들을 초기화
 * 2. 친구정보를 사용해 친구추천 점수를 계산
 * 3. visitor 정보로 점수 추가
 * 4. 친구추천 목록에 있는 사람들을 배열에 담고 정렬.
 * 5. 상위 5명 추가. 이때 친구추천 목록 중 점수가 0이하인 사람들이 있으면 answer에 추가하지 않는다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> recommend = new HashMap<>();
        //1. initialize relation
        Map<String, List<String>> relation = initializeRelation(friends);

        //2. calculate friend score by friend info
        for(String friend : relation.get(user)){
            addPointToRecommended(relation,recommend,friend);
        }

        //3. add score by visitor
        addPointToVisitor(recommend, visitors);

        //4. delete all who is already his friends or himself.
        removeAlreadyFriendsOrHimself(relation,recommend, user);

        //5. add to array and sort
        List<String> allId = new ArrayList<>(recommend.keySet());
        allId.sort((o1, o2) -> {
            Integer result = recommend.get(o2)-recommend.get(o1);
            result = (result==0) ? o1.compareTo(o2) : result;
            return result;
        });

        int count=0;
        for(String id : allId){
            if(count==5)break;
            answer.add(id);
            count++;
        }

        return answer;
    }

    public static void removeAlreadyFriendsOrHimself(Map<String, List<String>> relation, Map<String, Integer> recommend, String user) {
        for(String friend : relation.get(user)){
            if(recommend.containsKey(friend)) recommend.remove(friend);
        }
        recommend.remove(user);
    }

    public static void addPointToVisitor(Map<String, Integer> recommend, List<String> visitors) {
        for(String visitor : visitors)
            recommend.put(visitor, recommend.getOrDefault(visitor, 0)+1);
    }

    public static void addPointToRecommended(Map<String, List<String>> relation,
                                    Map<String, Integer> recommend, String friend) {
        for(String toAdd : relation.get(friend)){
            recommend.put(toAdd, recommend.getOrDefault(toAdd,0)+10);
        }
    }

    public static Map<String, List<String>> initializeRelation(List<List<String>> friends) {
        Map<String, List<String>> relation = new HashMap<>();

        for(List<String> friendship : friends){
            relation.put(friendship.get(0),
                    relation.getOrDefault(friendship.get(0), new ArrayList<>()));
            relation.put(friendship.get(1),
                    relation.getOrDefault(friendship.get(1), new ArrayList<>()));

            List<String> friendsOfA = relation.get(friendship.get(0));
            List<String> friendsOfB = relation.get(friendship.get(1));
            friendsOfA.add(friendship.get(1));
            friendsOfB.add(friendship.get(0));
        }

        return relation;
    }


}
