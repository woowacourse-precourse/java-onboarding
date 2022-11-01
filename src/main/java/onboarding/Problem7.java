package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static List<String> knownFriends=new ArrayList<>();
    static HashMap<String,Integer> usersInfo=new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setKnownFriends(user,friends);
        setUserInfo(friends);
        calUserPointByKnownFriends(friends);
        calUserPointByVisitors(visitors);
        usersInfo.remove(user);

        eliminateKnownFriends(user);
        usersInfo=sortUserInfo();
        List<String> answer=new ArrayList<>(usersInfo.keySet());
        return answer;
    }

    private static void eliminateKnownFriends(String user) {
        for (int i=0;i<knownFriends.size();i++ ) {
            if (usersInfo.containsKey(knownFriends.get(i)))
                usersInfo.remove(knownFriends.get(i));
        }
    }

    private static HashMap<String, Integer> sortUserInfo() {
        List<Map.Entry<String, Integer>> entries =usersInfo.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        HashMap<String,Integer> newInfo=new HashMap<>();
        for(int i=0;i<entries.size();i++){
            newInfo.put(entries.get(i).getKey(),entries.get(i).getValue());
        }
        return newInfo;
    }

    private static void calUserPointByVisitors(List<String> visitors) {
        int temp=0;
        for(int i=0;i<visitors.size();i++){
            if(!usersInfo.containsKey(visitors.get(i)))
                usersInfo.put(visitors.get(i),0 );
            temp= usersInfo.get(visitors.get(i));
            usersInfo.put(visitors.get(i),temp+1);
        }
    }

    private static void calUserPointByKnownFriends(List<List<String>> friends) {
        for (int i=0;i<friends.size();i++){
            for (int j=0;j<2;j++){
                for(int k=0;k<knownFriends.size();k++){
                    if(friends.get(i).get(j).equals(knownFriends.get(k))){
                        int temp= usersInfo.get(friends.get(i).get(1-j));
                        usersInfo.put(friends.get(i).get(1-j),temp+10);
                    }
                }
            }
        }
    }

    private static void setUserInfo(List<List<String>> friends) {
        for(int i=0;i<friends.size();i++){
            for(int j=0;j<2;j++)
                if(!usersInfo.containsKey(friends.get(i).get(j)))
                    usersInfo.put(friends.get(i).get(j),0 );
        }
    }

    private static void setKnownFriends(String user, List<List<String>> friends) {
        for (int i=0;i<friends.size();i++){//아는 친구 만들기
            if(friends.get(i).contains(user)){
                knownFriends.addAll(friends.get(i));
                knownFriends.remove(user);
            }
        }
    }
}
