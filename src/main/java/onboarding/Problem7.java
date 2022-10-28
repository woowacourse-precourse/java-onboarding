package onboarding;

import java.util.*;

public class Problem7 {

    private static Map<String, Set<String>> friendsRelationRepository;
    private static Map<String, Integer> friendsScoreRepository;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsRelationRepository = new HashMap<>();
        friendsScoreRepository = new HashMap<>();

        friends.forEach(x-> saveFriendRelation(x.get(0), x.get(1)));

        assign_10score(user);
        assign_1score(user, visitors);

        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(friendsScoreRepository.entrySet());
        scoreList.sort((o1, o2)->{
            if (o1.getValue()==o2.getValue()) o1.getKey().compareTo(o2.getKey());
            return o2.getValue()- o1.getValue();
        });

        List<String> recommendedList = new ArrayList<>();
        for(Map.Entry<String, Integer> i : scoreList) {
            if (i.getValue()!=0) recommendedList.add(i.getKey());
            if (recommendedList.size() > 5) break;
        }

        return recommendedList;
    }

    static void saveFriendRelation(String friends1, String friends2) {
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
                        filter(x -> friendsRelationRepository.get(user).contains(x)).count();
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
