package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String,Integer> friendsAdd_score(Map<String,Integer> FriendsAndScore_map,List<List<String>> friends,List<String> user_fri){
        for(int i=0; i<friends.size(); i++) {
            for(int j=0; j<user_fri.size(); j++) {
                if (user_fri.get(j) == friends.get(i).get(0)) {
                    for (Map.Entry<String, Integer> element : FriendsAndScore_map.entrySet()) {
                        if(friends.get(i).get(1)==element.getKey()){
                            element.setValue(element.getValue()+10);
                        }
                    }
                }
                if (user_fri.get(j) == friends.get(i).get(1)) {
                    for (Map.Entry<String, Integer> element : FriendsAndScore_map.entrySet()) {
                        if(friends.get(i).get(0)==element.getKey()){
                            element.setValue(element.getValue()+10);
                        }
                    }
                }
            }
        }
        return FriendsAndScore_map;
    }
    public static Map<String,Integer> visitorsAdd_score(Map<String,Integer> s,List<String> visitors,List<List<String>> friends,List<String> user_friends) {
        Map<String,Integer> friendsAndScores=friendsAdd_score(s,friends,user_friends);
        for(Map.Entry<String,Integer> element:friendsAndScores.entrySet()){
            for(int i=0; i<visitors.size(); i++){
                if(element.getKey()==visitors.get(i)){
                    element.setValue(element.getValue()+1);
                }
            }
        }
        return friendsAndScores;

    }
    public static List<String> userfriends_set(List<List<String>> friends,String user) {
        List<String> user_fri=new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0)==user) {
                user_fri.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1)==user){
                user_fri.add(friends.get(i).get(0));
            }
        }return user_fri;
    }

    public static Map<String,Integer> friendslist_set(List<String> ls,List<String> user_fri) {

    }
    public static List<String> get_result(Map<String,Integer> FriendsAndscore_map){

    }
    public static Map<String,Integer> UpperSort(Map<String,Integer> FriendsAndscore_map){

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}