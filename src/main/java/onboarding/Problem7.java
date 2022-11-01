package onboarding;

import java.util.*;

public class Problem7 {

    public static HashMap<String,Boolean> user_friend;
    public static HashMap<String,Integer> friend_friend;
    public static List<Map.Entry<String, Integer>> result ;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        user_friend = new HashMap<String,Boolean>();
        friend_friend = new HashMap<String,Integer>();

        userFriendCheck(user,friends);
        friendOfFriend(user,friends);
        friendVisitCheck(visitors);

        result = new LinkedList<>(friend_friend.entrySet());
        friendScoreSort();

        List<String> answer = isResult();

        return answer;
    }

    public static void userFriendCheck(String user,List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0)==user){
                user_friend.put(friends.get(i).get(1),true);
            }
            else if(friends.get(i).get(1)==user){
                user_friend.put(friends.get(i).get(0),true);
            }
            else continue;
        }
    }

    public static void friendOfFriend(String user,List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0)==user||friends.get(i).get(1)==user)continue;
            else{
                if(user_friend.containsKey(friends.get(i).get(0))==true){
                    friendException(friends.get(i).get(1));
                }
                else if(user_friend.containsKey(friends.get(i).get(1))==true){
                    friendException(friends.get(i).get(0));
                }
                else continue;
            }
        }

    }

    public static void friendException(String name){
        if(user_friend.containsKey(name)==true) return;
        else{
            if(friend_friend.containsKey(name)==false){
                friend_friend.put(name,10);
            }
            else{
                friend_friend.put(name,friend_friend.get(name)+10);
            }
        }
    }

    public static void friendVisitCheck(List<String> visitors){
        for(int i=0;i<visitors.size();i++){
            friendVisitException(visitors.get(i));
        }
    }

    public static void friendVisitException(String name){
        if(user_friend.containsKey(name)==true)return;
        else{
            if(friend_friend.containsKey(name)==false){
                friend_friend.put(name,1);
            }
            else {
                friend_friend.put(name, friend_friend.get(name) + 1);
            }
        }
    }

    public static void friendScoreSort(){
        Collections.sort(result, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> score1, Map.Entry<String, Integer> score2) {
                if (score1.getValue() > score2.getValue()) {
                    return -1;
                }
                else if (score1.getValue() < score2.getValue()) {
                    return 1;
                }

                return score1.getKey().compareTo(score2.getKey());
            }
        });
    }

    public static List<String> isResult(){

        List<String> answer= new ArrayList<>();

        for(int i=0;i<result.size();i++){
            answer.add(result.get(i).getKey());
        }
        return answer;
    }


}
