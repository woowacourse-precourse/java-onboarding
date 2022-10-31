package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendsMap =  getFriendsMap(friends);
        Map<String,Integer> pointMap = getPointMap(friendsMap,user);
        calculatorFriendsPoint(friendsMap,pointMap,user);
        calculatorVisitorPoint(friendsMap.get(user),pointMap,visitors);

        return answer;
    }
    public static Map<String,List<String>> getFriendsMap(List<List<String>> friends){
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0; i<friends.size();i++){
            String leftName = friends.get(i).get(0);
            String rightName = friends.get(i).get(1);
            List<String> leftList= map.getOrDefault(leftName, new ArrayList<>());
            leftList.add(rightName);
            List<String> rightList = map.getOrDefault(rightName, new ArrayList<>());
            rightList.add(leftName);
            map.put(leftName,leftList);
            map.put(rightName,rightList);
        }
        return map;
    }
    public static Map<String,Integer> getPointMap(Map<String,List<String>> friendsMap,String user){
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String str : friendsMap.keySet()){
            if(!friendsMap.get(str).contains(user)) {
                map.put(str,0);
            }
        }
        map.remove(user);
        return map;
    }
    public static void calculatorFriendsPoint(Map<String,List<String>> friendsMap,Map<String,Integer> pointMap,String user){
        List<String> userList = friendsMap.get(user);
        for(String str : pointMap.keySet()){
            List<String> friendList = friendsMap.get(str);
            for(String s : friendList){
                if(userList.contains(s)){
                    pointMap.put(str,pointMap.get(str)+10);
                }
            }
        }
    }
    public static void calculatorVisitorPoint(List<String> userList, Map<String,Integer> pointMap , List<String> visitors){


        for(String str : visitors){
            if(!userList.contains(str)){
                pointMap.put(str,pointMap.getOrDefault(str,0)+1);
            }
        }
    }
}
