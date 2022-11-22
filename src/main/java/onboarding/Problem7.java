package onboarding;

import java.util.*;

public class Problem7 {
    // 친구 관계 만들어주는 함수
    static HashMap<String, ArrayList<String>> friendRelation(List<List<String>> friends){
        HashMap<String, ArrayList<String>> relation = new HashMap<>();
        for(int i = 0 ; i < friends.size(); i++){
            ArrayList<String> list = new ArrayList<>();
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            // 친구1의 친구들 갱신
            if (relation.containsKey(friend1)){
                list = relation.get(friend1);
                list.add(friend2);
            }else{
                list.add(friend2);
            }
            relation.put(friend1, list);
            // 친구2의 친구들 갱신
            list = new ArrayList<>();
            if(relation.containsKey(friend2)){
                list = relation.get(friend2);
                list.add(friend1);
            }else{
                list.add(friend1);
            }
            relation.put(friend2, list);
        }
        return relation;
    }
    // 점수 계산
    static HashMap<String, Integer> calScore(HashMap<String, ArrayList<String>> relation, String user, List<String> visitors){
        HashMap<String, Integer> totalScore = new HashMap<>();
        // 점수 저장 Map 초기화
        for(String friend : relation.keySet()){
            totalScore.put(friend, 0);
        }
        for(String visitor : visitors){
            totalScore.put(visitor, 0);
        }
        Set<String> userFriends = new HashSet<>(relation.get(user)); // user의 친구인지 검색을 O(1)의 시간복잡도를 위해 Set으로 구현
        // 함께 아는 친구를 통한 점수 계산
        for(String userFriend : userFriends){
            for(String userFriendF : relation.get(userFriend)){
                if (!userFriends.contains(userFriendF)){// 사용자와 친구가 아니라면
                    totalScore.put(userFriendF, totalScore.get(userFriendF) + 10);
                }
            }
        }

        // 방문한 횟수를 통한 점수 계산
        for(String visitor : visitors){
            if (!userFriends.contains(visitor)){
                totalScore.put(visitor, totalScore.get(visitor) + 1);
            }
        }

        // 점수가 0인 값들과 key값이 user인 값 제거해서 반환
        totalScore.keySet().removeIf(n -> n.equals(user));
        totalScore.values().removeIf(n -> n == 0);
        return totalScore;
    }

    // 결과 값을 점수가 가장 높은 순으로 정렬하여 최대 5명만 반환하는 함수
    static List<String> highScoreFriends(HashMap<String, Integer> friends){
        List<String> result = new ArrayList<>();
        PriorityQueue<Person> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1.getScore() < p2.getScore()) return 1;
            else if (p1.getScore() > p2.getScore()) return -1;
            else{
                return p1.getName().compareTo(p2.getName());
            }
        });
        for(Map.Entry<String, Integer> entry : friends.entrySet()){
            Person person = new Person(entry.getKey(),entry.getValue());
            heap.add(person);
        }
        int cnt = 0;
        while (!heap.isEmpty()){
            result.add(heap.poll().getName());
            cnt++;
            if (cnt == 5){
                break;
            }
        }
        return result;
    }

    // Person 객체 생성
    public static class Person{
        private String name;
        private int score;
        public Person() {}
        public Person(String name, int score){
            this.name = name;
            this.score = score;
        }
        public String getName(){
            return name;
        }
        public int getScore(){
            return score;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        answer = highScoreFriends(calScore(friendRelation(friends),user,visitors));
        return answer;
    }
}
