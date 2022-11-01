package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String ,Integer> friendRecommendMap = new HashMap<>();
        List<String> userFriendList = getUserFriendList(user, friends);
        addFriendWeKnowScore(user, friends, friendRecommendMap, userFriendList);
        List<List<String>> friendRecommendList = mapToLists(friendRecommendMap, userFriendList);
        listBubbleSort(friendRecommendList);
        addToAnswerList(answer, friendRecommendList);
        return answer;
    }
    private static List<String> getUserFriendList(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for(int i = 0; i< friends.size(); i++){
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);
            if(first== user){
                userFriendList.add(second);
            }
            else if(second == user){
                userFriendList.add(first);
            }
        }
        return userFriendList;
    }

    private static void addFriendWeKnowScore(String user, List<List<String>> friends, Map<String, Integer> friendRecommendMap, List<String> userFriendList) {
        for(int i = 0; i< friends.size(); i++){
            String first = friends.get(i).get(0);
            String second = friends.get(i).get(1);
            if(first == user || second == user){
                continue;
            }
            for(int j = 0; j< userFriendList.size(); j++){
                if(userFriendList.get(j) == first){
                    if(!friendRecommendMap.containsKey(first)){
                        friendRecommendMap.put(second,10);
                    }
                    else{
                        friendRecommendMap.put(second, friendRecommendMap.get(second) +10);
                    }
                }
                else if(userFriendList.get(j) ==second){
                    if(!friendRecommendMap.containsKey(second)){
                        friendRecommendMap.put(first,10);
                    }
                    else{
                        friendRecommendMap.put(first, friendRecommendMap.get(first)+10);
                    }
                }
            }
        }
    }


    private static List<List<String>> mapToLists(Map<String, Integer> friendRecommendMap, List<String> userFriendList) {
        List<List<String> > friendRecommendList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: friendRecommendMap.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(!userFriendList.contains(key)){
                List<String> recommendUnit = new ArrayList<>();
                recommendUnit.add(key);
                recommendUnit.add(value.toString());
                friendRecommendList.add(recommendUnit);
            }
        }
        return friendRecommendList;
    }

    private static void addToAnswerList(List<String> answer, List<List<String>> friendRecommendList) {
        for(int i = 0; i< friendRecommendList.size(); i++){
            answer.add(friendRecommendList.get(i).get(0));
        }
    }
    private static void listBubbleSort(List<List<String>> friendRecommendList) {
        for(int i = 0; i< friendRecommendList.size(); i++){
            for(int j = 0; j< friendRecommendList.size(); j++){
                List<String> first = friendRecommendList.get(i);
                List<String> second = friendRecommendList.get(j);
                if((Integer.parseInt(first.get(1)) == Integer.parseInt(second.get(1)))&& first.get(0).compareTo(second.get(0))<0){
                    List<String> tmp = first;
                    friendRecommendList.set(i,second);
                    friendRecommendList.set(j,tmp);
                }
                else if(Integer.parseInt(first.get(1)) >Integer.parseInt(second.get(1))){
                    List<String> tmp = first;
                    friendRecommendList.set(i,second);
                    friendRecommendList.set(j,tmp);
                }
            }
        }
    }

}

