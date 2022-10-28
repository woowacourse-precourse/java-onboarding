package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> findUserFriends(String user,List<List<String>> friends){ //유저와 친구관계 파악.
        List<String> exceptUser = new ArrayList<>();
        exceptUser.add(user);

        for(int i=0;i<friends.size();i++){
            String friendsTarget = friends.get(i).get(1);
            String exceptTarget = friends.get(i).get(0);

            if(user == friendsTarget) exceptUser.add(exceptTarget);
        }

        return exceptUser;
    }
    public static List<String> changeList(List<List<String>> friends){// 일차원 리스트로 변형.
        List<String> friendsList = new ArrayList<>();

        for(int i =0;i<friends.size();i++){
            String leftFriend = friends.get(i).get(0);
            String rightFriend = friends.get(i).get(1);
            friendsList.add(leftFriend);
            friendsList.add(rightFriend);
        }

        return friendsList;
    }

    public static HashMap<String,Integer> countUserFriends(List<String> friendsList){ //친구 추천 점수 체크
        HashMap<String,Integer> userPoint = new HashMap<String,Integer>();

        for(int i =0;i<friendsList.size();i++){
            String friendName = friendsList.get(i);
            if(!userPoint.containsKey(friendName)) {
                userPoint.put(friendName,10);
                continue;
            }
            userPoint.put(friendName,userPoint.get(friendName)+10); //userPoint.replace(friendName,userPoint.get(friendName)+10);
        }
        return userPoint;
    }

    public static HashMap<String,Integer> countUserVisit(HashMap<String,Integer> userPoint, List<String> visitors){ // 방문자 점수 체크
        for(int i=0;i<visitors.size();i++){
            String visitorName = visitors.get(i);
            if(!userPoint.containsKey(visitorName)) {
                userPoint.put(visitorName,1);
                continue;
            }
            userPoint.put(visitorName,userPoint.get(visitorName)+1);
        }
        return userPoint;
    }

    public static HashMap<String,Integer> removeExceptUser(String exceptUser,HashMap<String,Integer> userPoint){

        for(int i =0;i< userPoint.size();i++){
            if(userPoint.containsKey(exceptUser)) userPoint.remove(exceptUser);
        }

        return userPoint;
    }

    public static HashMap<String,Integer> sortUserPoint (HashMap<String,Integer> userPoint){

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>();
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return userPoint;
    }
    public static List<String> getRanking(List<String> answer, HashMap<String,Integer> userPoint){

        for(String name : userPoint.keySet()) answer.add(name);


        return answer;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> exceptUser = new ArrayList<>();
        List<String> friendsList = new ArrayList<>();
        HashMap<String,Integer> userPoint = new HashMap<>();

        exceptUser = findUserFriends(user,friends);
        friendsList = changeList(friends);
        userPoint = countUserFriends(friendsList);
        userPoint = countUserVisit(userPoint,visitors);
        for(int i =0;i<exceptUser.size();i++)   userPoint = removeExceptUser(exceptUser.get(i),userPoint);
        userPoint = sortUserPoint(userPoint);
        getRanking(answer, userPoint);

        return answer;
    }
}
