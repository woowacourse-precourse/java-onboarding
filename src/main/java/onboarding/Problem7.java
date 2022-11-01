package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());

        Map<String,User> userRelationMap = new HashMap<>();

        setUserRelation(userRelationMap,friends);
        findFriendsOfFiends(user,userRelationMap);
        findVisitor(visitors,userRelationMap);

        List<Map.Entry<String,User>> mapEntry = createMapEntry(userRelationMap);

        sorting(userRelationMap,mapEntry);
        recommendFriend(user,userRelationMap.get(user).getConnectedMap(),answer,mapEntry);
         return answer;
    }

    public static void findFriendsOfFiends(String user,Map<String,User> userRelationMap){
        Map<String,User> thisUserConnectRelationMap = userRelationMap.get(user).getConnectedMap();
        for(String userName : thisUserConnectRelationMap.keySet()){

            Map<String,User> targetConnectedMap = userRelationMap.get(userName).getConnectedMap();

            for (String targetsFriend : targetConnectedMap.keySet()){
                userRelationMap.get(targetsFriend).addFriendScore();
            }
        }
    }
    public static void findVisitor(List<String> visitors,Map<String,User> userRelationMap){
        for(String visitor : visitors){
            User visitorUser = userRelationMap.computeIfAbsent(visitor,key -> new User());
            visitorUser.addVisitorScore();
        }
    }

    //유저 관계 정보를 저장한다.
    public static void setUserRelation(Map<String, User> userRelationMap, List<List<String>> friends){

        for(List<String> friend : friends){

            String user1 = friend.get(0);
            String user2 = friend.get(1);

            userRelationMap.computeIfAbsent(user1,k->new User()).connectingFriends(user2,new User());
            userRelationMap.computeIfAbsent(user2,k->new User()).connectingFriends(user1,new User());
        }
    }

    public static void sorting(Map<String,User> userRelationMap, List<Map.Entry<String,User>> mapEntry){
        mapEntry.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {

                int o1Score = o1.getValue().getScore();
                int o2Score = o2.getValue().getScore();

                if (o2Score - o1Score == 0)
                    return o1.getKey().compareTo(o2.getKey());

                return o2Score - o1Score;
            }
        });
    }

    public static void recommendFriend(String user,Map<String,User> userConnectedMap,List<String> answer,List<Map.Entry<String,User>> mapEntry){
        int answerCnt = 0;

        for(Map.Entry<String,User> entry : mapEntry){

            if(answerCnt == 5)
                break;

            if(entry.getValue().getScore() > 0) {
                if(userConnectedMap.get(entry.getKey()) == null && !entry.getKey().equals(user)) {
                    answer.add(entry.getKey());
                    answerCnt += 1;
                }
            }
        }
    }
    public static List<Map.Entry<String,User>> createMapEntry(Map<String,User> userRelationMap){

        return new LinkedList<>(userRelationMap.entrySet());
    }


    static class User {

        //연결된 유저를 저장하는 해시맵
        private final Map<String, User> connectedMap;

        //해당 유저의 추천 가중치
        private int score;

        public User() {
            this.connectedMap = new HashMap<>();
            this.score = 0;
        }


        public void connectingFriends(String friend,User user) {
            connectedMap.put(friend,user);
        }

        public void addFriendScore(){
            this.score += 10;
        }

        public int getScore() {
            return score;
        }

        public void addVisitorScore(){
            this.score += 1;
        }

        public Map<String, User> getConnectedMap() {
            return connectedMap;
        }
    }
}
