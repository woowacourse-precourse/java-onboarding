package onboarding;

import java.util.*;

public class Problem7 {
    public static void makeNonFriendList(String user,List<List<String>> friends,List<String> myFriend,List<String> nonFriend,List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        int score = 0;
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            for (int j = 0; j < myFriend.size(); j++) {
                if (!friend.contains(user) && friend.get(0).equals(myFriend.get(j)) && !friend.get(1).equals(myFriend.get(j))) {
                    if (!nonFriend.contains(friend.get(1))) {
                        nonFriend.add(friend.get(1));
                        scoreMap.put(friend.get(1), score + 10);
                    } else {//이미 존재
                        scoreMap.replace(friend.get(1), scoreMap.get(friend.get(1)) + 10);

                    }

                } else if (!friend.contains(user) && !friend.get(0).equals(myFriend.get(j)) && friend.get(1).equals(myFriend.get(j))) {
                    if (!nonFriend.contains(friend.get(0))) {
                        nonFriend.add(friend.get(0));
                        scoreMap.put(friend.get(0), score + 10);
                    } else {//이미 존재
                        scoreMap.replace(friend.get(0), scoreMap.get(friend.get(0)) + 10);

                    }
                }
            }
        }

        for(int k=0;k<visitors.size();k++){
            for(int p=0;p<myFriend.size();p++){
                if(!visitors.get(k).equals(myFriend.get(p))){ //visitor에 myfriend가 없어야함
                    if(!nonFriend.contains(visitors.get(k)) && !myFriend.contains(visitors.get(k))) {
                        nonFriend.add(visitors.get(k));
                        scoreMap.put(visitors.get(k), score + 1);
                    }
                }
            }
            if(nonFriend.contains(visitors.get(k)) && k < visitors.size()-2){
                scoreMap.replace(visitors.get(k),scoreMap.get(visitors.get(k))+1);
            }
        }
        nonFriend.clear();
        List<Map.Entry<String,Integer>> list_entries = new ArrayList<Map.Entry<String,Integer>>(scoreMap.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<String,Integer> entry : list_entries){
            nonFriend.add(entry.getKey());
        }
    }

    public static void makeFriendList(String user,List<List<String>> friends,List<String> myFriend){

        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            if(friend.contains(user)){
                String myF = friend.indexOf(user) == 0 ? friend.get(1) : friend.get(0);
                myFriend.add(myF);

            }
        }

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myFriend = new ArrayList<>();
        List<String> nonFriend = new ArrayList<>();

        makeFriendList(user,friends,myFriend);
        makeNonFriendList(user,friends,myFriend,nonFriend,visitors);

        answer = nonFriend;
        return answer;
    }
}
