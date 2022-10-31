package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Set<String>> friendsMap;

    static TreeMap<String, Score> scores;

    public static class Score{
        String name;
        int score;
        public void changeScore(int update){
            this.score = this.score + update;
        }
        public Score(String name , int score){
            this.name = name;
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result;
        friendsMap = new HashMap<>();
        scores = new TreeMap<>();
        //친구관계 저장
        saveFriendship(friends, friendsMap);

        Set<String> userFriend = friendsMap.get(user);

        //겹치는 친구 수 에 따른 점수 저장
        addFriendScore(user, userFriend);
        // 방문 수 에 따른 점수 저장
        addVisitorScore(visitors);

        result = recommendFriend(userFriend);

        return result;
    }

    private static void saveFriendship(List<List<String>> friends, HashMap<String, Set<String>> friendsMap){
        for (List<String> friendList : friends) {
            for(int i = 0 ; i < friendList.size() ; i++){
                String f1 = friendList.get(0);
                String f2 = friendList.get(1);

                if( !friendsMap.containsKey(f1) && !friendsMap.containsKey(f2) ){  //없는 경우
                    Set<String> f1Friend = new HashSet<>();
                    f1Friend.add(f2);
                    Set<String> f2Friend = new HashSet<>();
                    f2Friend.add(f1);

                    friendsMap.put(f1, f1Friend);
                    friendsMap.put(f2, f2Friend);

                } else if( friendsMap.containsKey(f1) && !friendsMap.containsKey(f2) ) {
                    friendsMap.get(f1).add(f2);

                    Set<String> f2Friend = new HashSet<>();
                    f2Friend.add(f1);

                    friendsMap.put(f2, f2Friend);
                } else if( friendsMap.containsKey(f2) && !friendsMap.containsKey(f1)) {
                    friendsMap.get(f2).add(f1);
                    Set<String> f1Friend = new HashSet<>();

                    f1Friend.add(f2);
                    friendsMap.put(f1, f1Friend);
                }
                else {  //이미 있는 경우
                    friendsMap.get(f1).add(f2);
                    friendsMap.get(f2).add(f1);
                }
            }
        }
    }

    private static void addVisitorScore( List<String> visitors ){
        for(String visitor : visitors){
            boolean contains = scores.keySet().contains(visitor);
            if( contains ){
                scores.get(visitor).changeScore(1);
            } else scores.put(visitor, new Score(visitor, 1));
        }
    }

    private static void addFriendScore( String user, Set<String> userFriend ){
        for(int i = 0 ; i < friendsMap.size() ; i++){
            Set<String> keySet = friendsMap.keySet();

            for(String key : keySet){
                int count = 0;
                if( key.equals(user)){
                    continue;
                }
                Set<String> iFriend = friendsMap.get(key);
                for( String friend : iFriend ){
                    if( userFriend.contains(friend) ){
                        count++;
                    }
                }
                scores.put( key, new Score( key, count * 10) );
            }
        }
    }

    private static List<String> recommendFriend( Set<String> userFriend ){
        List<Score> sortedScore = new ArrayList<>(scores.values());
        sortedScore.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                    return o2.score - o1.score;
                }
        });
        List<String> result = new ArrayList<>();

        sortedScore.forEach(candidate -> {
            if ( candidate.score > 0 && result.size() < 5 && !userFriend.contains(candidate.name))  result.add(candidate.name);
        });

        return result;
    }

}
