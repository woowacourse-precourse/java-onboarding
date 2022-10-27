package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendsRelationRepository = new HashMap<>();
    private static Map<String, Integer> friendsScoreRepository = new HashMap<>();
    private static List<String> recommandedList = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 관계 정보를 friendsRelationRepository 에 저장 (key=유저, value=해당 유저와 친구 관계인 Set)
        friends.forEach(x->addFriend(x.get(0), x.get(1)));

        //10점 부여 조건을 만족하는 친구에게 점수를 부여
        assign_10score(user);
        //1점 부여 조건(방문자)을 만족하는 친구에게 점수를 부여
        assign_1score(user, visitors);

        //friendsScoreRepository 에서 필요한 순서대로 정렬을 수행하기 위하여
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(friendsScoreRepository.entrySet());
        scoreList.sort((o1, o2)->{
            if (o1.getValue()==o2.getValue()) o1.getKey().compareTo(o2.getKey());
            return o2.getValue()- o1.getValue();
        });

        //
        for(Map.Entry<String, Integer> i : scoreList) {
            if (i.getValue()!=0) recommandedList.add(i.getKey());
            if (recommandedList.size() > 5) break;
        }

        return recommandedList;
    }
    static void addFriend(String friends1, String friends2) {
        if (!friendsRelationRepository.containsKey(friends1)) friendsRelationRepository.put(friends1, new HashSet<>());
        if (!friendsRelationRepository.containsKey(friends2)) friendsRelationRepository.put(friends2, new HashSet<>());
        friendsRelationRepository.get(friends1).add(friends2);
        friendsRelationRepository.get(friends2).add(friends1);
    }

    static void assign_10score(String user){
        for(String i : friendsRelationRepository.keySet()){
            if(i.equals(user)) continue;
            if(!friendsRelationRepository.get(user).contains(i)) {
                int count = (int)friendsRelationRepository.get(i).stream().
                        filter(x -> friendsRelationRepository.get(user).contains(x)).
                        count();
                friendsScoreRepository.put(i, 10*count);
            }
        }
    }

    static void assign_1score(String user, List<String> visitor) {
        for(String i : visitor){
            if (i.equals(user)) continue;
            if(!friendsRelationRepository.get(user).contains(i)){
                friendsScoreRepository.put(i, friendsScoreRepository.getOrDefault(i,0)+1);
            }
        }
    }
}
