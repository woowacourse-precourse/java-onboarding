package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
        HashMap<String,Integer> score = new HashMap<>();
        if(validateUserCheck(user) && validateFriendsCheck(friends) && validateVisitorsCheck(visitors)){
            hashMap = findFriendsList(friends);
            score = findScoreMap(user,hashMap,visitors);
            List<Map.Entry<String,Integer>> list = new ArrayList<>(score.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            answer = findAnswer(list);
        }
        return answer;
    }
    private static boolean validateUserCheck(String user){
        int idLength = user.length();
        if(idLength < 1 || idLength > 30){
            return false;
        }
        for(int i=0; i<idLength; i++){
            if(user.charAt(i) < 'a' || user.charAt(i) > 'z'){
                return false;
            }
        }
        return true;
    }
    private static boolean validateFriendsCheck(List<List<String>> friends){
        int totalLength = 0;
        for(List<String> list : friends){
            totalLength += list.size();
            if(totalLength < 1 || totalLength > 10000){
                return false;
            }
            else if(list.get(0).length() < 1 || list.get(0).length() > 30){
                return false;
            }
            else if(list.get(1).length() < 1 || list.get(1).length() > 30){
                return false;
            }
            else {
                return true;
            }
        }
        return true;
    }
    private static boolean validateVisitorsCheck(List<String> visitors){
        if(visitors.size() < 0 || visitors.size() > 10000){
            return false;
        }
        return true;
    }
    private static HashMap<String,ArrayList<String>> findFriendsList(List<List<String>> friends){
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for(List<String> list : friends){
            ArrayList<String> tmp;
            if(hashMap.containsKey(list.get(0))){
                tmp = hashMap.get(list.get(0));
            }
            else {
                tmp = new ArrayList<>();
            }
            tmp.add(list.get(1));
            hashMap.put(list.get(0),tmp);

            if(hashMap.containsKey(list.get(1))){
                tmp = hashMap.get(list.get(1));
            }
            else {
                tmp = new ArrayList<>();
            }
            tmp.add(list.get(0));
            hashMap.put(list.get(1),tmp);
        }
        return hashMap;
    }
    private static HashMap<String,Integer> findScoreMap(String user , HashMap<String, ArrayList<String>> hashMap,
    List<String> visitors){
        final int CONNECT = 10;
        final int VISIT = 1;
        HashMap<String,Integer> score = new HashMap<>();
        for(String cmp : hashMap.get(user)){
            for(String friendsList : hashMap.keySet()){
                if(hashMap.get(friendsList).contains(cmp)){
                    score.put(friendsList,score.getOrDefault(friendsList,0)+CONNECT);
                }
            }
        }
        for(String cmp : visitors){
            score.put(cmp,score.getOrDefault(cmp,0)+VISIT);
        }
        for(String cmp : hashMap.get(user)){
            if(score.containsKey(cmp)){
                score.remove(cmp);
            }
        }
        if(score.containsKey(user)){
            score.remove(user);
        }
        return score;
    }
    private static List<String> findAnswer(List<Map.Entry<String,Integer>> list){
        int cnt = 0;
        List<String> answer = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : list){
            answer.add(entry.getKey());
            cnt++;
           if(cnt==5){
               break;
           }
        }
        return answer;
    }
}
